
public class StatusReg {

    // 7: IRP
    // 6: RP1
    // 5: RP0
    // 4: TO
    // 3: PD
    // 2: zeroFlag
    // 1: digitCarryFlag
    // 0: carryFlag

    public static int[] status = { 0, 0, 0, 1, 1, 0, 0, 0 };
    

    public static String getStatus() {
        /*int iStatus = 0;

        for (int i = 0; i < status.length; i++) {
            iStatus = iStatus + status[i] * (int) Math.pow((double) 2, (double) i);
        }

        String sStatus = Integer.toHexString(iStatus).toUpperCase();*/
        //return sStatus;
        return Integer.toHexString(RAM.getRam(3));
    }

    public static int getIRP() {
        /*int regVal = status[7] * (int) Math.pow(2, 7) + status[6] * (int) Math.pow(2, 6)
                + status[5] * (int) Math.pow(2, 5) + status[4] * (int) Math.pow(2, 4) + status[3] * (int) Math.pow(2, 3)
                + status[2] * (int) Math.pow(2, 2) + status[1] * (int) Math.pow(2, 1)
                + status[0] * (int) Math.pow(2, 0);
        
        RAM.setRegister(3, regVal, 0);*/
        //return status[7];
        return(InstructionDecoder.getBit(RAM.ram[3], 7));
    }

    public static void setIRP(int iRP) {
        status[7] = iRP;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 7, iRP), 3);
    }

    public static int getRP1() {
        //return status[6];
        return(InstructionDecoder.getBit(RAM.ram[3], 6));
    }

    public static void setRP1(int rP1) {
        status[6] = rP1;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 6, rP1), 3);
    }

    public static int getRP0() {
        //return status[5];
        return(InstructionDecoder.getBit(RAM.ram[3], 5));
    }

    public static void setRP0(int rP0) {
        
        status[5] = rP0;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 5, rP0), 3);
        System.out.println("RP0:" + +rP0);
    }

    public static int getTO() {
        //return status[4];
        return(InstructionDecoder.getBit(RAM.ram[3], 4));
    }

    public static void setTO(int tO) {
        status[4] = tO;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 4, tO), 3);
    }

    public static int getPD() {
        //return status[3];
        return(InstructionDecoder.getBit(RAM.ram[3], 3));
    }

    public static void setPD(int pD) {
        status[3] = pD;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 3, pD), 3);
    }

    public static int getZeroFlag() {
        //return status[2];
        return(InstructionDecoder.getBit(RAM.ram[3], 2));
    }

    public static void setZeroFlag(int zeroFlag) {
        status[2] = zeroFlag;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 2, zeroFlag), 3);
    }

    public static int getDigitCarryFlag() {
        //return status[1];
        return(InstructionDecoder.getBit(RAM.ram[3], 1));
    }

    public static void setDigitCarryFlag(int digitCarryFlag) {
        status[1] = digitCarryFlag;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 1, digitCarryFlag), 3);
    }

    public static int getCarryFlag() {
        //return status[0];
        return(InstructionDecoder.getBit(RAM.ram[3], 0));
    }

    public static void setCarryFlag(int carryFlag) {
        status[0] = carryFlag;
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 0, carryFlag), 3);
    }

    public static void resetStatusReg() {
        //setCarryFlag(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 0, 0), 3);
        //setDigitCarryFlag(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 1, 0), 3);
        //setIRP(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 7, 0), 3);
        //setPD(1);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 3, 1), 3);
        //setRP0(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 5, 0), 3);
        //setRP1(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 6, 0), 3);
        //setTO(1);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 4, 1), 3);
        //setZeroFlag(0);
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(3), 2, 0), 3);
        
    }

}
