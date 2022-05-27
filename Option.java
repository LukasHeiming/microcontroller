
public class Option {

    //7: RBPU 
    //6: INTDEG
    //5: T0CS 
    //4: T0SE
    //3: PSA
    //2: PS2
    //1: PS1
    //0: PS0 

    public static int[] optionReg = {1,1,1,1,1,1,1,1};

    public static String getOption() {
        int iOption = 0;
       
         for (int i = 0; i < optionReg.length; i++) {
                iOption = iOption + optionReg[i] * (int)Math.pow((double)2,(double)i);     
        }
        
        String sOption = Integer.toHexString(iOption).toUpperCase();    
        //sOption = sOption.replace("0x", "");
        return sOption;
    }

    
    public static int getRBPU() {
        return optionReg[7];
    }

    public static void setRBPU(int rBPU) {
        optionReg[7] = rBPU;
    }

    public static int getINTDEG() {
        return optionReg[6];
    }

    public static void setINTDEG(int iNTDEG) {
        optionReg[6] = iNTDEG;
    }

    public static int getT0CS() {
        return optionReg[5];
    }

    public static void setT0CS(int t0cs) {
        optionReg[5] = t0cs;
    }

    public static int getT0SE() {
        return optionReg[4];
    }

    public static void setT0SE(int t0se) {
        optionReg[4] = t0se;
    }

    public static int getPSA() {
        return optionReg[3];
    }

    public static void setPSA(int pSA) {
        optionReg[3] = pSA;
    }

    public static int getPS2() {
        return optionReg[2];
    }

    public static void setPS2(int pS2) {
        optionReg[2] = pS2;
    }

    public static int getPS1() {
        return optionReg[1];
    }

    public static void setPS1(int pS1) {
        optionReg[1] = pS1;
    }

    public static int getPS0() {
        return optionReg[0];
    }

    public static void setPS0(int pS0) {
        optionReg[0] = pS0;
    }

    public static void resetOption() {
        for(int i = 0; i < optionReg.length; i++){
            optionReg[0] = 1;
        }
    }

    
}
