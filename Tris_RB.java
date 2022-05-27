public class Tris_RB {

    private static boolean[] Tris_B = {true,true,true,true,true,true,true,true};

    public static boolean getTris_B(int index) {
        return Tris_B[index];
    }

    public static void setTris_B_0(boolean tris_B, int index) {
        Tris_B[index] = tris_B;
    }


    public static void setTrisRb(boolean Tris_B_Value, int index) {
        Tris_B[index] = Tris_B_Value;
        if (Tris_B[index] == false) {
            Port_RB.RBStatus[index] = StatusEnum.OUTPUT;
        }

        if (Tris_B[index] == true) {
            Port_RB.RBStatus[index] = StatusEnum.INPUT;
        }
    }

    public static void resetTrisB() {
        for(int i = 0; i < Tris_B.length; i++){
            Tris_B[i] = true;
        }
    }
}
