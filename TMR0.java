
public class TMR0 {

    public static double quarztakt = 31.25; // mikroSekunden 32 kHz
    static int vorteilCounter = 0;
    static int tempFlanke;
    public static double laufzeit = 0;
    // Timer Register
    // 8 Bit

    private static int T0IF = 0; // Überlauf Bit

    public static int getTMR0() {
        return RAM.getRamAll(1);
    }

    public static void setTMR0(int value) {
        vorteilCounter = 0;
        RAM.setRamAll(value & 0b11111111, 1);
        Vorteiler.reset();
    }

    public static void countTimer(int befehlstakt) {
        if (Option.getT0CS() == 0) {
            System.out.println("TIMER ZÄHLT: " + RAM.getRamAll(1) + " + " + befehlstakt);

           
           

            if ((RAM.getRamAll(1)) == 255) {
                T0IF = 1;
                System.out.println("ÜBERLAUF");
                Intcon.setT0IF(1);
                System.out.println("PC before:" + PC.programCounter );
                if (Intcon.getT0IE() == 1 && Intcon.getGIE() == 1  ) {
                    System.out.println(("INTERRUPT"));
                    switch (InstructionDecoder.instructionToDecode) {
                        case "DECFSZ":
                        case "INCFSZ":
                        case "BTFSC":
                        case "BTFSS":
                            PC.inc();
                            break;                    
                        default:
                            break;
                    }
                    System.out.println("PC after:" + PC.programCounter );
                    Intcon.setGIE(0);
                    Stack.push(PC.programCounter);
                    PC.programCounter = 3;
                }
            }

            for (int i = 0; i < befehlstakt; i++) {
                countSingle();
            }
        }
       
        laufzeit = laufzeit + (befehlstakt * 4 * quarztakt);

        if (Option.getT0CS() == 1) {
            if(Option.getT0SE() == 1)
            {
            boolean temp = Port_RA.getPortRA(4);
            int itemp;
            if (temp == true) {
                itemp = 1;
            } else {
                itemp = 0;
            }
            if (itemp == 0 && tempFlanke == 1) {
                System.out.println("itemp: " + itemp + "  tempFlanke: " + tempFlanke);
                countSingle();
            }
            tempFlanke = itemp;
        }
        else{
            boolean temp = Port_RA.getPortRA(4);
            int itemp;
            if (temp == true) {
                itemp = 1;
            } else {
                itemp = 0;
            }
            if (itemp == 1 && tempFlanke == 0) {
                System.out.println("itemp: " + itemp + "  tempFlanke: " + tempFlanke);
                countSingle();
            }
            tempFlanke = itemp;
            }
        }
    }

    public static void countSingle() {
        if (Vorteiler.faktor == 1) {
            RAM.setRamAll(RAM.getRamAll(1) + 1, 1);
            vorteilCounter = 0;
            return;
        }
        vorteilCounter++;
        System.out.println("Count Single Vorteilcount: " + vorteilCounter);
        if (vorteilCounter == Vorteiler.faktor) {
            System.out.println("zähle counter hoch");
            RAM.setRamAll(RAM.getRamAll(1) + 1, 1);
            vorteilCounter = 0;
        }
    }

    public static void setQuarztakt(double newQuarztakt) {
        quarztakt = newQuarztakt;
    }

    public static double getQuarztakt() {
        return quarztakt;
    }
}
