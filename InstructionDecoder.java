import javax.naming.NoPermissionException;

public class InstructionDecoder {

    public static String instructionToDecode;

    public static void decode(String instruction) {
        int paraInt = 0;
        int para2Int = 0;
        boolean paraDone = false;
        String parameter2 = "";
        instructionToDecode = instruction;
        int index = instructionToDecode.indexOf(" ");
        String parameter = instructionToDecode.substring(index + 1, instructionToDecode.length());

        if (parameter.indexOf(",") != -1) {
            parameter2 = parameter.substring(parameter.indexOf(",") + 1, parameter.length());
            parameter = parameter.substring(0, parameter.indexOf(","));
        }

        for (int i = 0; i < Flash.equValues.length; i++) {
            if (parameter.equals(Flash.equValues[i][0]) && !parameter.equals("indirect")) {
                parameter = Integer.toString(Integer.parseInt(Flash.equValues[i][1]));
                System.out.println("Equ Address: " + Flash.equValues[i][1]);

                parameter = Integer.toHexString(Integer.parseInt(parameter));
                parameter = parameter.toUpperCase();
                if (parameter.length() == 1) {
                    parameter = "0" + parameter;
                }
                System.out.println("parameter after getting equ from RAM: " + parameter);
            }
        }
        if (parameter2 != "") {
            for (int i = 0; i < Flash.equValues.length; i++) {
                if (parameter2.equals(Flash.equValues[i][0]) && !parameter.equals("indirect")) {
                    parameter2 = Integer.toString(Integer.parseInt(Flash.equValues[i][1]));
                    parameter2 = Integer.toHexString(Integer.parseInt(parameter2));
                    parameter2 = parameter2.toUpperCase();
                    if (parameter2.length() == 1) {
                        parameter2 = "0" + parameter2;
                    }
                }
            }
        }

        if(parameter.equals("indirect")){
            paraInt = FSR_Register.getFsr();
        }

        if (parameter.charAt(parameter.length() - 1) == 'h') {
            parameter = parameter.substring(0, parameter.length() - 1);
        }

        switch (parameter.charAt(0)) {
            case ('0'):
            case ('1'):
            case ('2'):
            case ('3'):
            case ('4'):
            case ('5'):
            case ('6'):
            case ('7'):
            case ('8'):
            case ('9'):
                parameter = "0x" + parameter;
                break;
            default:

                break;
        }

        if (parameter2 != "") {
            switch (parameter2.charAt(0)) {
                case ('0'):
                case ('1'):
                case ('2'):
                case ('3'):
                case ('4'):
                case ('5'):
                case ('6'):
                case ('7'):
                case ('8'):
                case ('9'):
                    parameter2 = "0x" + parameter2;
                    break;
                default:

                    break;
            }
        }

        if (index != -1) {
            instructionToDecode = instructionToDecode.substring(0, index);
        }

        instructionToDecode = instructionToDecode.toUpperCase();

        if (instructionToDecode.equals("RETURN")) {
            paraDone = true;
        }
        
        System.out.println("Aktueller Befehl: " + instructionToDecode);
        System.out.println("Aktueller Parameter: " + parameter);
        if (parameter2 != "") {
            System.out.println("Aktueller Parameter2: " + parameter2);
        }

        for (int i = 0; i < Flash.callMarksAndLines.length; i++) {
            if (parameter.equals(Flash.callMarksAndLines[i][0])) {
                paraInt = Integer.parseInt(Flash.callMarksAndLines[i][1]);
                paraDone = true;
                System.out.println("paraInt als call: " + paraInt);
            }
        }

        if (paraDone == false) {
            for (int i = 0; i < Flash.jumpMarksAndLines.length; i++) {
                if (parameter.equals(Flash.jumpMarksAndLines[i][0])) {
                    paraInt = Integer.parseInt(Flash.jumpMarksAndLines[i][1]);
                    paraDone = true;
                    System.out.println("paraInt als jump: " + paraInt);
                }
            }
        }

        boolean isW = false;
        System.out.println("Aktueller paraDone: " + paraDone);
        if (paraDone == false) {
            if (parameter.matches("[0][x][0-9A-Fa-f]*")) {
                System.out.println("paraInt before decode: " + parameter);
                paraInt = Integer.decode(parameter);
                System.out.println("paraInt after decode: " + paraInt);
            }
            if (parameter2.matches("[0][x][0-9A-Fa-f]*")) {
                System.out.println("para2Int before decode: " + parameter2);
                para2Int = Integer.decode(parameter2);
                System.out.println("para2Int after decode: " + para2Int);
            } else {
                if (parameter2.equals("w")) {
                    para2Int = W_Register.getValue();
                } else {
                    para2Int = 1;
                    isW = true;
                }
            }
        }

        System.out.println("Aktueller paraInt: " + paraInt);
        System.out.println("Aktueller para2Int: " + para2Int);

        switch (instructionToDecode) {
            case "ADDWF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                ADDWF(paraInt, para2Int);
                break;

            case "ANDWF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                ANDWF(paraInt, para2Int);
                break;

            case "CLRF":
                CLRF(paraInt);
                break;

            case "CLRW":
                CLRW();
                break;

            case "COMF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                COMF(paraInt, para2Int);
                break;

            case "DECF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                DECF(paraInt, para2Int);
                break;

            case "DECFSZ":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                DECFZS(paraInt, para2Int);
                break;

            case "INCF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                INCF(paraInt, para2Int);
                break;

            case "INCFSZ":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                INCFSZ(paraInt, para2Int);
                break;

            case "IORWF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                IORWF(paraInt, para2Int);
                break;

            case "MOVF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                MOVF(paraInt, para2Int);
                break;

            case "MOVWF":
                // todo
                MOVWF(paraInt);
                break;

            case "NOP":
                NOP();
                break;

            case "RLF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                RLF(paraInt, para2Int);
                break;

            case "RRF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                RRF(paraInt, para2Int);
                break;

            case "SUBWF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                SUBWF(paraInt, para2Int);
                break;

            case "SWAPF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                SWAPF(paraInt, para2Int);
                break;

            case "XORWF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                XORWF(paraInt, para2Int);
                break;

            case "BCF":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BCF(paraInt, para2Int);
                break;

            case "BSF":
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BSF(paraInt, para2Int);
                break;

            case "BTFSC":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BTFSC(paraInt, para2Int);
                break;

            case "BTFSS":
                // todo
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BTFSS(paraInt, para2Int);
                break;

            case "ADDLW":
                ADDLW(paraInt);
                break;

            case "ANDLW":
                ANDLW(paraInt);
                break;

            case "CALL":
                CALL(paraInt);
                break;

            case "CLRWDT":
                CLRWDT();
                break;

            case "GOTO":
                GOTO(paraInt);
                break;

            case "IORLW":
                IORLW(paraInt);
                break;

            case "MOVLW":
                MOVLW(paraInt);
                break;

            case "RETFIE":
                RETFIE();
                break;

            case "RETLW":
                RETLW(paraInt);
                break;

            case "RETURN":
                RETURN();
                break;

            case "SLEEP":
                SLEEP();
                break;

            case "SUBLW":
                SUBLW(paraInt);
                break;

            case "XORLW":
                XORLW(paraInt);
                break;

            default:
                break;
        }
    }

    // BYTE-ORIENTED FILE REGISTER
    // OPERATIONS-------------------------------------------------------------
    public static void ADDWF(int f, int d) {
        if (W_Register.getValue() + RAM.getRam(f) > 255 || W_Register.getValue() + RAM.getRam(f) < 0) {
            StatusReg.setCarryFlag(1);
        } else {
            StatusReg.setCarryFlag(0);
        }

        figureOutDCFlag(RAM.getRam(f), true);
        
        System.out.println("D ist: " + d);
        if (d == 0) {
            System.out.println("W Register: " + W_Register.getValue() + " + RAM: " + RAM.getRam((f)) );
            W_Register.setValue(W_Register.getValue() + RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(W_Register.getValue() + RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }

        return;
    }

    public static void ANDWF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(W_Register.getValue() & RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(W_Register.getValue() & RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        return;
    }

    public static void CLRF(int f) {
        RAM.setRam(0, f);
        if (RAM.getRam(f) == 0) {
            StatusReg.setZeroFlag(1);
        } else {
            StatusReg.setZeroFlag(0);
        }
        return;
    }

    public static void CLRW() {
        W_Register.setValue(0);
        StatusReg.setZeroFlag(1);
        return;
    }

    public static void COMF(int f, int d) {
        if (d == 0) {
            System.out.println("Ergebnis: " + (255 - RAM.getRam(f)));
            W_Register.setValue(255 - RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(255 - RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        return;
    }

    public static void DECF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) - 1);
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(RAM.getRam(f) - 1, f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        return;
    }

    public static void DECFZS(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) - 1);
            if (W_Register.getValue() == 0) {
                PC.inc();
            }
        } else {
            RAM.setRam(RAM.getRam(f) - 1, f);
            if (RAM.getRam(f) == 0) {
                PC.inc();
            }
        }
        return;
    }

    public static void INCF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) + 1);
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(RAM.getRam(f) + 1, f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        return;
    }

    public static void INCFSZ(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) + 1);
            if (W_Register.getValue() == 0) {
                PC.inc();
            }
        } else {
            RAM.setRam(RAM.getRam(f) + 1, f);
            if (RAM.getRam(f) == 0) {
                PC.inc();
            }
        }
        return;
    }

    public static void IORWF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) | W_Register.getValue());
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam(RAM.getRam(f) | W_Register.getValue(), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            }
        }
    }

    public static void MOVF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        if (d == 1) {
            RAM.setRam(RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
        return;
    }

    public static void MOVWF(int f) {
        System.out.println("Wert von f:" + f);
        System.out.println("W: " + W_Register.getValue());
        System.out.println(RAM.setRam(W_Register.getValue(), f));
        return;
    }

    public static void NOP() {

    }

    public static void RLF(int f, int d) {
        // int temp = RAM.getCarryFlag();
        int temp = StatusReg.getCarryFlag();
        int temp1 = ((RAM.getRam(f) & 0b10000000) >> 7);
        System.out.println("temp1: " + temp1);
        StatusReg.setCarryFlag(temp1);
        if (d == 0) {
            W_Register.setValue((RAM.getRam(f) << 1) + temp);
        } else {
            RAM.setRam((RAM.getRam(f) << 1) + temp, f);
        }
    }

    public static void RRF(int f, int d) {
        // int temp = RAM.getCarryFlag();
        int temp = StatusReg.getCarryFlag();
        int temp1 = ((RAM.getRam(f) & 0b1));
        StatusReg.setCarryFlag(temp1);
        if (d == 0) {
            W_Register.setValue((RAM.getRam(f) >> 1) + (temp << 7));
        } else {
            RAM.setRam((RAM.getRam(f) >> 1) + (temp << 7), f);
        }
    }

    public static void SUBWF(int f, int d) {
        if ((RAM.getRam(f) - W_Register.getValue()) >= 0) {
            StatusReg.setCarryFlag(1);
        } else {
            StatusReg.setCarryFlag(0);
        }

        figureOutDCFlag(RAM.getRam(f), false);

        if (d == 0) {
            W_Register.setValue((RAM.getRam(f) - W_Register.getValue()));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam((RAM.getRam(f) - W_Register.getValue()), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
    }

    public static void SWAPF(int f, int d) {
        if (d == 0) {
            W_Register.setValue((RAM.getRam(f) & 0x0F) << 4 | (RAM.getRam(f) & 0xF0) >> 4);
        } else {
            RAM.setRam(((RAM.getRam(f) & 0x0F) << 4 | (RAM.getRam(f) & 0xF0) >> 4), f);
        }
    }

    public static void XORWF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) ^ W_Register.getValue());
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        } else {
            RAM.setRam(RAM.getRam(f) ^ W_Register.getValue(), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            } else {
                StatusReg.setZeroFlag(0);
            }
        }
    }

    // BIT-ORIENTED FILE REGISTER
    // OPERATIONS-------------------------------------------------------------
    public static void BCF(int f, int b) {
        RAM.setRam(modifyBit(RAM.getRam(f), b, 0), f);
    }

    public static void BSF(int f, int b) {
        RAM.setRam(modifyBit(RAM.getRam(f), b, 1), f);
    }

    public static void BTFSC(int f, int b) {
        if (((RAM.getRam(f) >> b) & 1) == 0) {
            PC.inc();
        }
    }

    public static void BTFSS(int f, int b) {
        if (((RAM.getRam(f) >> b) & 1) == 1) {
            PC.inc();
        }
    }

    // LITERAL AND CONTROL
    // OPERATIONS-------------------------------------------------------------------
    public static void ADDLW(int k) {
        if (W_Register.getValue() + k < 0 || W_Register.getValue() + k > 255) {
            StatusReg.setCarryFlag(1);
        } else {
            StatusReg.setCarryFlag(0);
        }

        figureOutDCFlag(RAM.getRam(k), true);

        W_Register.setValue(W_Register.getValue() + k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        } else {
            StatusReg.setZeroFlag(0);
        }
        return;
    }

    public static void ANDLW(int k) {
        W_Register.setValue(W_Register.getValue() & k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        } else {
            StatusReg.setZeroFlag(0);
        }
        return;
    }

    public static void CALL(int k) {
        // need stack
        System.out.println("This is k in Call method: " + (PC.programCounter));
        Stack.push(PC.programCounter);
        GOTO(k);
        // unfinished
        // Normalerweise ist k eine Marke. Dadurch wird dann ein Bezeichner und keine
        // nackte Zahl verwendet.
        // Um eine 13-Bit lange Sprungadresse zu erhalten werden den im Befehl
        // enthaltenen 11 Bit (k) die Bits 4 und 3 des Registers PCLATCH vorangestellt.
        // An der Adresse k steht ein Unterprogramm, das mit dem Befehl RETURN oder
        // RETLW enden muss.
    }

    public static void CLRWDT() {
        // Watchdog Gedöns
    }

    public static void GOTO(int k) {
        // need stack
        // unfinished
        PC.programCounter = k;
    }

    public static void IORLW(int k) {
        System.out.println("IORLW Übergabeparameter: " + k);
        W_Register.setValue(W_Register.getValue() | k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        }
    }

    public static void MOVLW(int k) {
        System.out.println("movlw Parameter: " + k);
        W_Register.setValue(k);

    }

    public static void RETFIE() {
        // Interrupt Gedöns
    }

    public static void RETLW(int k) {
        // Stack zeug
        W_Register.setValue(k);
        GOTO(Stack.pop());
    }

    public static void RETURN() {
        GOTO(Stack.pop());
    }

    public static void SLEEP() {
        // Vorteiler Zeug
    }

    public static void SUBLW(int k) {
        if (k - W_Register.getValue() >= 0) {
            StatusReg.setCarryFlag(1);
        } else {
            StatusReg.setCarryFlag(0);
        }

        figureOutDCFlag(RAM.getRam(k), false);

        W_Register.setValue(k - W_Register.getValue());
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        } else {
            StatusReg.setZeroFlag(0);
        }
    }

    public static void XORLW(int k) {
        W_Register.setValue(W_Register.getValue() ^ k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        } else {
            StatusReg.setZeroFlag(0);
        }
    }

    // new selfcreated Methods
    public static int modifyBit(int n, int p, int b) {
        int mask = 1 << p;
        return (n & ~mask) | ((b << p) & mask);
    }

    static void figureOutDCFlag(int f, boolean addition){
        String binaryNumber1 = "";
        binaryNumber1 = Integer.toBinaryString(f);
        String binaryNumber2 = "";
        binaryNumber2 = Integer.toBinaryString(W_Register.getValue());

        while(binaryNumber1.length() < 4){
            binaryNumber1 = "0" + binaryNumber1;
        }

        while(binaryNumber1.length() > 4){
            binaryNumber1 = binaryNumber1.substring(1, binaryNumber1.length());
        }

        while(binaryNumber2.length() < 4){
            binaryNumber2 = "0" + binaryNumber2;
        }

        while(binaryNumber2.length() > 4){
            binaryNumber2 = binaryNumber2.substring(1, binaryNumber2.length());
        }

        System.out.println("binaryNumber1 (only last 4 Bits) - Integer.toBinaryString(" + f + "): " + binaryNumber1);
        System.out.println("binaryNumber2 (only last 4 Bits) - Integer.toBinaryString(" + W_Register.getValue() + "): " + binaryNumber2);

        if(binaryNumber1.charAt(0) == '1' && binaryNumber2.charAt(0) == '1'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(0)");
            }else{
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(0)");
            }
        }else if(binaryNumber1.charAt(0) == '0' && binaryNumber2.charAt(0) == '0'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(0)");
            }else{
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(0)");
            }
        }else if(binaryNumber1.charAt(1) == '1' && binaryNumber2.charAt(1) == '1'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(1)");
            }else{
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(1)");
            }
        }else if(binaryNumber1.charAt(1) == '0' && binaryNumber2.charAt(1) == '0'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(1)");
            }else{
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(1)");
            }
        }else if(binaryNumber1.charAt(2) == '1' && binaryNumber2.charAt(2) == '1'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(2)");
            }else{
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(2)");
            }
        }else if(binaryNumber1.charAt(2) == '0' && binaryNumber2.charAt(2) == '0'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(2)");
            }else{
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(2)");
            }
        }else if(binaryNumber1.charAt(3) == '1' && binaryNumber2.charAt(3) == '1'){
            if(addition == true){
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(3)");
            }else{
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(3)");
            }
        }else{
            if(addition == true){
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(3)");
            }else{
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(3)");
            }
        }
    }
}

