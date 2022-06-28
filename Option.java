
public class Option {

    //7: RBPU 
    //6: INTDEG
    //5: T0CS 
    //4: T0SE
    //3: PSA
    //2: PS2
    //1: PS1
    //0: PS0 


    public static String getOption() {
        if(StatusReg.getRP0() == 0)
        {
        return Integer.toHexString(RAM.getRam(129));
        }
        else{
            return Integer.toHexString(RAM.getRam(1));
        }
    }

    public static int getRBPU() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 7));
    }

    public static void setRBPU(int rBPU) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 7, rBPU), 129);
    }

    public static int getINTDEG() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 6));
    }

    public static void setINTDEG(int iNTDEG) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 6, iNTDEG), 129);
    }

    public static int getT0CS() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 5));
    }

    public static void setT0CS(int t0cs) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 5, t0cs), 129);
    }

    public static int getT0SE() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 4));
    }

    public static void setT0SE(int t0se) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 4, t0se), 129);
    }

    public static int getPSA() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 3));
    }

    public static void setPSA(int pSA) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 3, pSA), 129);
    }

    public static int getPS2() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 2));
    }

    public static void setPS2(int pS2) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 2, pS2), 129);
    }

    public static int getPS1() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 1));
    }

    public static void setPS1(int pS1) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 1, pS1), 129);
    }

    public static int getPS0() {
        return(InstructionDecoder.getBit(RAM.getRamAll(129), 0));
    }

    public static void setPS0(int pS0) {
        RAM.setRamAll(InstructionDecoder.modifyBit(RAM.getRamAll(129), 0, pS0), 129);
    }

    public static void resetOption() {
        RAM.ram[129] = 255; 
    }

    
}
