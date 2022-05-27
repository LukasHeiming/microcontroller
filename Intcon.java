public class Intcon {

    //7: GIE
    //6: EEIE
    //5: T0IE
    //4: INTE
    //3: RBIE
    //2: T0IF
    //1: INTF
    //0: RBIF

    public static int[] IntconReg = { 0, 0, 0, 0, 0, 0, 0, 0 };

    public static String getIntcon() {
        int iIntcon = 0;
       
         for (int i = 0; i < IntconReg.length; i++) {
                iIntcon = iIntcon + IntconReg[i] * (int)Math.pow((double)2,(double)i);     
        }
        
        String sIntcon = Integer.toHexString(iIntcon).toUpperCase();    
        return sIntcon;
    
    }


    public static int getGIE() {
        return IntconReg[7];
    }

    public static void setGIE(int gIE) {
        IntconReg[7] = gIE;
    }

    public static int getEEIE() {
        return IntconReg[6];
    }

    public static void setEEIE(int eEIE) {
        IntconReg[6] = eEIE;
    }

    public static int getT0IE() {
        return IntconReg[5];
    }

    public static void setT0IE(int t0ie) {
        IntconReg[5] = t0ie;
    }

    public static int getINTE() {
        return IntconReg[4];
    }

    public static void setINTE(int iNTE) {
        IntconReg[4] = iNTE;
    }

    public static int getRBIE() {
        return IntconReg[3];
    }

    public static void setRBIE(int rBIE) {
        IntconReg[3] = rBIE;
    }

    public static int getT0IF() {
        return IntconReg[2];
    }

    public static void setT0IF(int t0if) {
        IntconReg[2] = t0if;
    }

    public static int getINTF() {
        return IntconReg[1];
    }

    public static void setINTF(int iNTF) {
        IntconReg[1] = iNTF;
    }

    public static int getRBIF() {
        return IntconReg[0];
    }

    public static void setRBIF(int rBIF) {
        IntconReg[0] = rBIF;
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
