public class Intcon {

    // 7: GIE   Enables Interrupts in General
    // 6: EEIE  Enables EEPROM write complete interrupt
    // 5: T0IE  Enables TMR0 Overflow Interrupt
    // 4: INTE  Enables RB0 interrupt
    // 3: RBIE  Enables RB Port Change Interrupt
    // 2: T0IF  TMR0 Overflow Flag
    // 1: INTF  RB0 Interrupt occured
    // 0: RBIF  1 = Atleast one of RB7-RB4 pins changed state

    public static int[] IntconReg = { 0, 0, 0, 0, 0, 0, 0, 0 };

    public static String getIntcon() {
        return Integer.toHexString(RAM.getRamAll(11));
    }

    public static int getGIE() {
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 7));
    }

    public static void setGIE(int gIE) {
        //IntconReg[7] = gIE;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 7, gIE), 11);
    }

    public static int getEEIE() {
        //return IntconReg[6];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 6));

    }

    public static void setEEIE(int eEIE) {
        //IntconReg[6] = eEIE;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 6, eEIE), 11);
    }

    public static int getT0IE() {
        //return IntconReg[5];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 5));

    }

    public static void setT0IE(int t0ie) {
        //IntconReg[5] = t0ie;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 5, t0ie), 11);
    }

    public static int getINTE() {
        //return IntconReg[4];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 4));
    }

    public static void setINTE(int iNTE) {
        //IntconReg[4] = iNTE;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 4,iNTE), 11);
    }

    public static int getRBIE() {
        //return IntconReg[3];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 3));
    }

    public static void setRBIE(int rBIE) {
        //IntconReg[3] = rBIE;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 3, rBIE), 11);
    }

    public static int getT0IF() {
        //return IntconReg[2];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 2));
    }

    public static void setT0IF(int t0if) {
        //IntconReg[2] = t0if;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 2, t0if), 11);
    }

    public static int getINTF() {
        //return IntconReg[1];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 1));
    }

    public static void setINTF(int iNTF) {
        //IntconReg[1] = iNTF;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 1, iNTF), 11);
    }

    public static int getRBIF() {
        //return IntconReg[0];
        return(InstructionDecoder.getBit(RAM.getRamAll(11), 0));
    }

    public static void setRBIF(int rBIF) {
        //IntconReg[0] = rBIF;
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(11), 0, rBIF), 11);
    }

    public static void resetIntcon() {
        setGIE(0);
        setEEIE(0);
        setT0IE(0);
        setINTE(0);
        setRBIE(0);
        setT0IF(0);
        setINTF(0);
        setRBIF(0);
    }

}
