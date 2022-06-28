import java.math.BigInteger;

import javax.naming.NoPermissionException;

public class InstructionDecoder {

    public static String instructionToDecode;

    public static void decode(String instruction) {
        System.out.println("");
        // Ram einlesen Anfang
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 8; j++) {
                if (j != 0) {
                    System.out.println("RAm inhalt: " + Integer
                            .parseInt(Controller_UI.table_Panel_Fileregister_SFR_GPR.getValueAt(i, j).toString()));
                    RAM.setRamAll(
                            Integer.parseInt(Controller_UI.table_Panel_Fileregister_SFR_GPR.getValueAt(i, j).toString()),
                            counter);
                    counter += 1;
                }
            }
        }

        // Ram einlesen Ende

        int paraInt = 0;
        int para2Int = 0;
        boolean paraDone = false;
        // boolean isHex = false;
        boolean isDual = false;
        String parameter2 = "";
        char paraChar;
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
                parameter = parameter + "h";
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

        if (parameter.equals("indirect")) {
            paraInt = FSR_Register.getFsr();
        }

        if (parameter.contains("'") == true) {
            parameter = parameter.replaceAll("'", "");
            paraChar = parameter.charAt(0);
            paraInt = (int) paraChar;
            paraDone = true;
        }

        if (parameter.charAt(parameter.length() - 1) == 'B') {
            parameter = parameter.substring(0, parameter.length() - 1);
            paraInt = Integer.parseInt(parameter, 2);
            isDual = true;
            paraDone = true;
        }

        if (parameter.charAt(parameter.length() - 1) == 'h') {
            parameter = parameter.substring(0, parameter.length() - 1);
        }

        if (isDual == false) {
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
            if (parameter.equalsIgnoreCase(Flash.callMarksAndLines[i][0])) {
                paraInt = Integer.parseInt(Flash.callMarksAndLines[i][1]);
                paraDone = true;
                System.out.println("paraInt als call: " + paraInt);
            }
        }

        if (paraDone == false) {
            for (int i = 0; i < Flash.jumpMarksAndLines.length; i++) {
                if (parameter.equalsIgnoreCase(Flash.jumpMarksAndLines[i][0])) {
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
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                ADDWF(paraInt, para2Int);
                break;

            case "ANDWF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                ANDWF(paraInt, para2Int);
                break;

            case "CLRF":
                TMR0.countTimer(1);
                CLRF(paraInt);
                break;

            case "CLRW":
                TMR0.countTimer(1);
                CLRW();
                break;

            case "COMF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                COMF(paraInt, para2Int);
                break;

            case "DECF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                DECF(paraInt, para2Int);
                break;

            case "DECFSZ":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                DECFZS(paraInt, para2Int);
                break;

            case "INCF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                INCF(paraInt, para2Int);
                break;

            case "INCFSZ":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                INCFSZ(paraInt, para2Int);
                break;

            case "IORWF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                IORWF(paraInt, para2Int);
                break;

            case "MOVF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                MOVF(paraInt, para2Int);
                break;

            case "MOVWF":
                // todo
                TMR0.countTimer(1);
                if (paraInt == 1 && StatusReg.getRP0() == 0) {
                    TMR0.vorteilCounter = 0;
                }

                MOVWF(paraInt);
                break;

            case "NOP":
                TMR0.countTimer(1);
                NOP();
                break;

            case "RLF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                RLF(paraInt, para2Int);
                break;

            case "RRF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                RRF(paraInt, para2Int);
                break;

            case "SUBWF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                SUBWF(paraInt, para2Int);
                break;

            case "SWAPF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                SWAPF(paraInt, para2Int);
                break;

            case "XORWF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                XORWF(paraInt, para2Int);
                break;

            case "BCF":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BCF(paraInt, para2Int);
                break;

            case "BSF":
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                System.out.println("BSF: paraInt -> " + paraInt + ", para2Int -> " + para2Int);
                BSF(paraInt, para2Int);
                break;

            case "BTFSC":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BTFSC(paraInt, para2Int);
                break;

            case "BTFSS":
                // todo
                TMR0.countTimer(1);
                if (para2Int == W_Register.getValue() && isW == false) {
                    para2Int = 0;
                }
                BTFSS(paraInt, para2Int);
                break;

            case "ADDLW":
                TMR0.countTimer(1);
                ADDLW(paraInt);
                break;

            case "ANDLW":
                TMR0.countTimer(1);
                ANDLW(paraInt);
                break;

            case "CALL":
                TMR0.countTimer(2);
                CALL(paraInt);
                break;

            case "CLRWDT":
                TMR0.countTimer(1);
                CLRWDT();
                break;

            case "GOTO":
                TMR0.countTimer(2);
                GOTO(paraInt);
                break;

            case "IORLW":
                TMR0.countTimer(1);
                IORLW(paraInt);
                break;

            case "MOVLW":
                TMR0.countTimer(1);
                MOVLW(paraInt);
                break;

            case "RETFIE":
                TMR0.countTimer(2);
                RETFIE();
                break;

            case "RETLW":
                TMR0.countTimer(2);
                RETLW(paraInt);
                break;

            case "RETURN":
                TMR0.countTimer(2);
                RETURN();
                break;

            case "SLEEP":
                TMR0.countTimer(1);
                SLEEP();
                break;

            case "SUBLW":
                TMR0.countTimer(1);
                SUBLW(paraInt);
                break;

            case "XORLW":
                TMR0.countTimer(1);
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
            System.out.println("W Register: " + W_Register.getValue() + " + RAM: " + RAM.getRam((f)));
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
                TMR0.countTimer(1);

            }
        } else {
            RAM.setRam(RAM.getRam(f) - 1, f);
            if (RAM.getRam(f) == 0) {
                PC.inc();
                TMR0.countTimer(1);
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
                TMR0.countTimer(1);
                PC.inc();
            }
        } else {
            RAM.setRam(RAM.getRam(f) + 1, f);
            if (RAM.getRam(f) == 0) {
                TMR0.countTimer(1);
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
        // System.out.println("Wert von f in MOVWF:" + f);
        // System.out.println("W: " + W_Register.getValue());
        System.out.println(RAM.setRam(W_Register.getValue(), f));
        return;
    }

    public static void NOP() {

    }

    public static void RLF(int f, int d) {
        // int temp = RAM.getCarryFlag();
        int temp = StatusReg.getCarryFlag();
        int temp1 = ((RAM.getRam(f) & 0b10000000) >> 7);
        // System.out.println("temp1: " + temp1);
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
        RAM.setRamAll(modifyBit(RAM.getRam(f), b, 0), f);
    }

    public static void BSF(int f, int b) {
        RAM.setRamAll(modifyBit(RAM.getRam(f), b, 1), f);
    }

    public static void BTFSC(int f, int b) {
        if (((RAM.getRam(f) >> b) & 1) == 0) {
            TMR0.countTimer(1);
            PC.inc();
        }
    }

    public static void BTFSS(int f, int b) {
        System.out.println("BTFSS: " + RAM.getRam(f));
        System.out.println(((RAM.getRam(f) >> b) & 1) == 1);
        if (((RAM.getRam(f) >> b) & 1) == 1) {
            System.out.println("SPRINGEN");
            TMR0.countTimer(1);
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
        Stack.push(PC.programCounter + 1);

        // CALL PCLATH
        // int callPCL = (PCL.getPCLInt() & 0b11000) << 8;
        // k = k & callPCL;
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
        Watchdog.resetWatchdogTimer();
    }

    public static void GOTO(int k) {
        // GOTO PCLATH
        // int callPCL = (PCL.getPCLInt() & 0b11000) << 8;
        // k = k & callPCL;
        PC.programCounter = k - 1;
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
        Intcon.setGIE(1);
        GOTO(Stack.pop());
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

    public static int getBit(int n, int b) {
        return (n >> b) & 1;
    }

    static void figureOutDCFlag(int f, boolean addition) {
        String binaryNumber1 = "";
        binaryNumber1 = Integer.toBinaryString(f);
        String binaryNumber2 = "";
        binaryNumber2 = Integer.toBinaryString(W_Register.getValue());

        while (binaryNumber1.length() < 4) {
            binaryNumber1 = "0" + binaryNumber1;
        }

        while (binaryNumber1.length() > 4) {
            binaryNumber1 = binaryNumber1.substring(1, binaryNumber1.length());
        }

        while (binaryNumber2.length() < 4) {
            binaryNumber2 = "0" + binaryNumber2;
        }

        while (binaryNumber2.length() > 4) {
            binaryNumber2 = binaryNumber2.substring(1, binaryNumber2.length());
        }

        System.out.println("binaryNumber1 (only last 4 Bits) - Integer.toBinaryString(" + f + "): " + binaryNumber1);
        System.out.println("binaryNumber2 (only last 4 Bits) - Integer.toBinaryString(" + W_Register.getValue() + "): "
                + binaryNumber2);

        if (binaryNumber1.charAt(0) == '1' && binaryNumber2.charAt(0) == '1') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(0)");
            } else {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(0)");
            }
        } else if (binaryNumber1.charAt(0) == '0' && binaryNumber2.charAt(0) == '0') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(0)");
            } else {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(0)");
            }
        } else if (binaryNumber1.charAt(1) == '1' && binaryNumber2.charAt(1) == '1') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(1)");
            } else {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(1)");
            }
        } else if (binaryNumber1.charAt(1) == '0' && binaryNumber2.charAt(1) == '0') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(1)");
            } else {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(1)");
            }
        } else if (binaryNumber1.charAt(2) == '1' && binaryNumber2.charAt(2) == '1') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(2)");
            } else {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(2)");
            }
        } else if (binaryNumber1.charAt(2) == '0' && binaryNumber2.charAt(2) == '0') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(2)");
            } else {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(2)");
            }
        } else if (binaryNumber1.charAt(3) == '1' && binaryNumber2.charAt(3) == '1') {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(3)");
            } else {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(3)");
            }
        } else {
            if (addition == true) {
                StatusReg.setDigitCarryFlag(0);
                System.out.println("DigitCarryFlag wurde nicht gesetzt aufgrund charAt(3)");
            } else {
                StatusReg.setDigitCarryFlag(1);
                System.out.println("DigitCarryFlag wurde gesetzt aufgrund charAt(3)");
            }
        }
    }

    public String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/* YOUR_CHARSET? */)));
    }
}
