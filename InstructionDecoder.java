import javax.naming.NoPermissionException;

public class InstructionDecoder {

    public static String instructionToDecode;

    public static void decode(String instruction) {
        int paraInt = 0;
        boolean paraDone = false;
        instructionToDecode = instruction;
        int index = instructionToDecode.indexOf(" ");
        String parameter = instructionToDecode.substring(index + 1, instructionToDecode.length());
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

        if(index != -1){
            instructionToDecode = instructionToDecode.substring(0, index);
        }

        instructionToDecode = instructionToDecode.toUpperCase();

        if(instructionToDecode.equals("RETURN")){
            paraDone = true;
        }

        System.out.println("Aktueller Befehl: " + instructionToDecode);
        System.out.println("Aktueller Parameter: " + parameter);

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

        System.out.println("Aktueller paraDone: " + paraDone);
        if (paraDone == false) {
            if (parameter.matches("[0][x][0-9A-F]*")) {
                paraInt = Integer.decode(parameter);
            }
        }

        switch (instructionToDecode) {
            case "ADDWF":
            //todo
                ADDWF(0, 0);
                break;

            case "ANDWF":
            //todo
                ANDWF(0, 0);
                break;

            case "CLRF":
                CLRF(paraInt);
                break;

            case "CLRW":
                CLRW();
                break;

            case "COMF":
            //todo
                COMF(0, 0);
                break;

            case "DECF":
            //todo
                DECF(0, 0);
                break;

            case "DECFSZ":
            //todo
                DECFZS(0, 0);
                break;

            case "INCF":
            //todo
                INCF(0, 0);
                break;

            case "INCFSZ":
            //todo
                INCFSZ(0, 0);
                break;

            case "IORWF":
            //todo
                IORWF(0, 0);
                break;

            case "MOVF":
            //todo
                MOVF(0, 0);
                break;

            case "MOVWF":
            //todo
                MOVWF(0);
                break;

            case "NOP":
                NOP();
                break;

            case "RLF":
            //todo
                RLF(0, 0);
                break;

            case "RRF":
            //todo
                RRF(0, 0);
                break;

            case "SUBWF":
            //todo
                SUBWF(0, 0);
                break;

            case "SWAPF":
            //todo
                SWAPF(0, 0);
                break;

            case "XORWF":
            //todo
                XORWF(0, 0);
                break;

            case "BCF":
            //todo
                BCF(0, 0);
                break;

            case "BSF":
                BSF(0, 0);
                break;

            case "BTFSC":
            //todo
                BTFSC(0, 0);
                break;

            case "BTFSS":
            //todo
                BTFSS(0, 0);
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
        if (d == 0) {
            W_Register.setValue(W_Register.getValue() + RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam(W_Register.getValue() + RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            }
        }

        return;
    }

    public static void ANDWF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(W_Register.getValue() & RAM.getRam(f));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam(W_Register.getValue() & RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            }
        }
        return;
    }

    public static void CLRF(int f) {
        RAM.setRam(0, f);
        if (RAM.getRam(f) == 0) {
            StatusReg.setZeroFlag(1);
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
            W_Register.setValue(RAM.getRam(f) ^ 0b11111111);
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam(RAM.getRam(f) ^ 0b11111111, f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            }
        }
        return;
    }

    public static void DECF(int f, int d) {
        if (d == 0) {
            W_Register.setValue(RAM.getRam(f) - 1);
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam(RAM.getRam(f) - 1, f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
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
            }
        } else {
            RAM.setRam(RAM.getRam(f) + 1, f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
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
            }
        }
        if (d == 1) {
            RAM.setRam(RAM.getRam(f), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
            }
        }
        return;
    }

    public static void MOVWF(int f) {
        RAM.setRam(W_Register.getValue(), f);
        return;
    }

    public static void NOP() {

    }

    public static void RLF(int f, int d) {
        // int temp = RAM.getCarryFlag();
        int temp = StatusReg.getCarryFlag();
        if (d == 0) {
            // RAM.setCarryFLag((RAM.getRam(f)>>7)&1);
            StatusReg.setCarryFlag((RAM.getRam(f)) & 1);
            W_Register.setValue(RAM.getRam(f) << 1);
            modifyBit(W_Register.getValue(), 0, temp);
        } else {
            // RAM.setCarryFLag((RAM.getRam(f)>>7)&1);
            StatusReg.setCarryFlag((RAM.getRam(f)) & 1);
            RAM.setRam(RAM.getRam(f) << 1, f);
            modifyBit(RAM.getRam(f), 0, temp);
        }
    }

    public static void RRF(int f, int d) {
        // int temp = RAM.getCarryFlag();
        int temp = StatusReg.getCarryFlag();
        if (d == 0) {
            // RAM.setCarryFLag((RAM.getRam(f))&1);
            StatusReg.setCarryFlag((RAM.getRam(f)) & 1);
            W_Register.setValue(RAM.getRam(f) >> 1);
            modifyBit(W_Register.getValue(), 7, temp);
        } else {
            // RAM.setCarryFLag((RAM.getRam(f))&1);
            StatusReg.setCarryFlag((RAM.getRam(f)) & 1);
            RAM.setRam(RAM.getRam(f) >> 1, f);
            modifyBit(RAM.getRam(f), 7, temp);
        }
    }

    public static void SUBWF(int f, int d) {
        if (d == 0) {
            W_Register.setValue((RAM.getRam(f) - W_Register.getValue()));
            if (W_Register.getValue() == 0) {
                StatusReg.setZeroFlag(1);
            }
        } else {
            RAM.setRam((RAM.getRam(f) - W_Register.getValue()), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
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
            }
        } else {
            RAM.setRam(RAM.getRam(f) ^ W_Register.getValue(), f);
            if (RAM.getRam(f) == 0) {
                StatusReg.setZeroFlag(1);
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
        W_Register.setValue(W_Register.getValue() + k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        }
        return;
    }

    public static void ANDLW(int k) {
        W_Register.setValue(W_Register.getValue() & k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
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
        W_Register.setValue(k - W_Register.getValue());
    }

    public static void XORLW(int k) {
        W_Register.setValue(W_Register.getValue() ^ k);
        if (W_Register.getValue() == 0) {
            StatusReg.setZeroFlag(1);
        }
    }

    // new selfcreated Methods
    public static int modifyBit(int n, int p, int b) {
        int mask = 1 << p;
        return (n & ~mask) | ((b << p) & mask);
    }
}
