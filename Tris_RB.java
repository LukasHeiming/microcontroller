public class Tris_RB {

    private static boolean[] Tris_B = {true,true,true,true,true,true,true,true};

    public static boolean getTris_B(int index) {
        int bit = InstructionDecoder.getBit(RAM.ram[134], index);
        if(bit == 0)
        {
            return false;
        } else{
            return true;
        }
    }

    public static void updateTrisB()
    {
        int tris = RAM.getRamAll(134);

        for(int i = 0; i<8; i++)
        {
            if(((tris >> i) & 1) == 0)
            {
                Port_RB.RBStatus[i] = StatusEnum.OUTPUT;
            }
            else{
                Port_RB.RBStatus[i] = StatusEnum.INPUT;
            }
        }
    }


    public static void setTrisRb(int Tris_B_Value, int index) {
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(134), index, Tris_B_Value), 134);
        if (Tris_B_Value == 0) {
            Port_RB.RBStatus[index] = StatusEnum.OUTPUT;
        }

        if (Tris_B_Value == 1) {
            Port_RB.RBStatus[index] = StatusEnum.INPUT;
        }
    }

    public static void resetTrisB() {
        RAM.ram[134] = 0;
    }

    
}
