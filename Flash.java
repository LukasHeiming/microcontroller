import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Flash {

    static String[] flash = new String[1024];
    static List<String> listMatches = new ArrayList<String>();
    static int[] firstCommandLine = new int[100];
    static String[][] jumpMarksAndLines = new String[8][2];
    static String[][] callMarksAndLines = new String[8][2];
    static String[][] equValues = new String[42][2];
    static int commandAmount = 0;

    public static String readFile(String fileName) {
        // reset vars

        for (int i = 0; i < 256; i++) {
            if (i >= 0 && i <= 11 || i >= 128 && i <= 139) {
                RAM.ramUsage[i] = 1;
            }

            if (i > 11 && i <= 79 || i >= 140 && i <= 207) {
                RAM.ramUsage[i] = 0;
            }

            if (i >= 80 && i <= 127 || i >= 208 && i <= 255) {
                RAM.ramUsage[i] = -1;
            }
        }

        for (int i = 0; i < 1024; i++) {
            flash[i] = "";
        }
        listMatches.clear();
        for (int i = 0; i < 100; i++) {
            firstCommandLine[i] = 0;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                jumpMarksAndLines[i][j] = "";
                callMarksAndLines[i][j] = "";
            }
        }
        for (int i = 0; i < 42; i++) {
            for (int j = 0; j < 2; j++) {
                equValues[i][j] = "";
            }
        }
        commandAmount = 0;

        System.out.println("Entered readFile");
        listMatches.clear();
        String sProgram = "";
        BufferedReader in = null;
        int linecounter = 0;
        int jumpMarksCounter = 0;
        int callMarksCounter = 0;
        int equCounter = 0;
        System.out.println("before fileName creation");
        fileName = "./TestFiles/" + fileName;
        System.out.println(fileName);
        File file = new File(fileName);
        System.out.println("File file created");
        if (!file.canRead() || !file.isFile()) {
            System.exit(0);
            in = null;
        }
        System.out.println("Right before try catch");
        try {
            in = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + line);
                if (line.charAt(0) == '0') {
                    firstCommandLine[commandAmount] = linecounter;
                    // System.out.println("firstCommandLine: " + firstCommandLine[commandAmount]);
                    commandAmount++;
                }
                // jumpmarken abspeichern (goto) oder unterprugramm rücksprungmarken mit
                // nächstem befehl in der nächsten zeile
                if (line.matches("^[ ]+[0-9]+[ ]+ [A-Za-z]+[ ][ ]+") == true) {
                    String jumpmark = line.replace(" ", "");
                    jumpmark = jumpmark.substring(5);
                    jumpMarksAndLines[jumpMarksCounter][0] = jumpmark;
                    jumpMarksAndLines[jumpMarksCounter][1] = Integer.toString(commandAmount);
                    System.out.println("jumpMarksAndLines[" + jumpMarksCounter + "][1]: " + commandAmount);
                    jumpMarksCounter++;
                }
                // unterprugramm rücksprungmarken abspeichern (call), nächster befehl in
                // gleicher zeile
                if (line.matches(
                        "^[A-F0-9][A-F0-9][A-F0-9][A-F0-9][ ][A-F0-9][A-F0-9][A-F0-9][A-F0-9][ ]*[0-9]+[ ][ ][A-Za-z0-9]+.*") == true) {
                    String callmark = line;
                    callmark = callmark.substring(27);
                    callmark = callmark.substring(0, callmark.indexOf(" "));
                    callMarksAndLines[callMarksCounter][0] = callmark;
                    callMarksAndLines[callMarksCounter][1] = Integer.toString(commandAmount - 1);
                    System.out.println("callMarksAndLines[" + callMarksCounter + "][1]: " + (commandAmount - 1));
                    callMarksCounter++;
                }
                if (line.matches(".*[0-9A-Za-z]*[ ]*equ[ ]*[0-9A-Za-z]*.*") == true) {
                    String equ = line;
                    String equName = "";
                    String equValue = "";
                    String equAdress = "";
                    if (equ.indexOf(";") != -1) {
                        equ = equ.substring(equ.indexOf("0") + 5, equ.indexOf(";"));
                    } else {
                        equ = equ.substring(equ.indexOf("0") + 5, equ.length());
                    }
                    equName = equ.substring(0, equ.indexOf("equ")).replaceAll("[ ]", "");
                    equValue = equ.substring(equ.indexOf("equ") + 3, equ.length()).replaceAll("[ ]", "");
                    equValue = equValue.replaceAll("h", "");
                    System.out.println("equValue: " + equValue);
                    equValues[equCounter][0] = equName;
                    // equ abspeichern
                    for (int i = 0; i < 256; i++) {
                        if (RAM.ramUsage[i] == 0) {
                            if (RAM.ramUsage[i] > 79) {
                                StatusReg.setRP0(1);
                            } else {
                                StatusReg.setRP0(0);
                            }
                            RAM.setRam(Integer.parseInt(equValue, 16), i);
                            equValues[equCounter][1] = Integer.toString(i);
                            break;
                        }
                    }
                    System.out.println("equName: " + equName);
                    System.out.println("equValue: " + equValue);
                    equCounter++;
                }

                sProgram = sProgram + line + "\n";
                linecounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
        String sProgramEdited = "";

        int index = sProgram.indexOf("org 0");
        sProgramEdited = sProgram.substring(index + 5, sProgram.length() - 1);
        sProgramEdited = sProgramEdited.replaceAll("[;].*", "");
        Pattern p = Pattern.compile("([a-z]+[ ][0-9a-z,]+)|return|nop|clrw|clrwdt|sleep|retfie");
        Matcher m = p.matcher(sProgramEdited);
        while (m.find()) {
            listMatches.add(m.group());
        }

        // sProgramEdited = sProgramEdited.replaceAll("list c=132", ""); ([a-zA-Z]+[
        // ][0-9a-zA-z,]+)|return|nop|clrw|clrwdt|sleep|retfie
        // sProgramEdited = sProgramEdited.replaceAll("device 16F84", "");
        // sProgramEdited = sProgramEdited.replaceAll("org 0", "");
        // System.out.println("edited:" + sProgramEdited);

        // for (String i : listMatches) {
        // System.out.println("listMatches: " + i);
        // }
        System.out.println("Commands:");
        for (int i = 0; i < listMatches.size(); i++) {
            flash[i] = listMatches.get(i);
            System.out.println("flash[" + i + "]: " + flash[i]);
        }
        System.out.println("Commands end.");
        return sProgram;
    }

}
