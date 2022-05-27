

public class Tris_Ra {

    private static boolean[] Tris_A = {true,true,true,true,true};


    public static boolean getTrisA(int index) {
        return Tris_A[index];
    }

    public static void setTrisA(boolean value, int index) {
        Tris_A[index] = value;
        if(Tris_A[index] == false)
        {
            Port_RA.PortAStatus[index] = StatusEnum.OUTPUT;
        }
        else if(Tris_A[index] == true)
        {
            Port_RA.PortAStatus[index] = StatusEnum.INPUT;
        }
    }

    public static void resetTrisA() {
        for(int i = 0; i < Tris_A.length; i++){
            Tris_A[i] = true;
        }
    }
}
