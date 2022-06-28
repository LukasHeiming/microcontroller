

public class Tris_Ra {


    public static boolean getTrisA(int index) {
        int bit = InstructionDecoder.getBit(RAM.ram[133], index);
        if(bit == 0)
        {
            return false;
        } else{
            return true;
        }
    }

    public static void updateTrisA()
    {
        int tris = RAM.getRamAll(133);

        for(int i = 0; i<5; i++)
        {
            if(((tris >> i) & 1) == 0)
            {
                Port_RA.PortAStatus[i] = StatusEnum.OUTPUT;
            }
            else{
                Port_RA.PortAStatus[i] = StatusEnum.INPUT;
            }
        }
    }

    public static void setTrisA(int value, int index) {
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(133), index, value), 133);
        if(value == 0)
        {
            Port_RA.PortAStatus[index] = StatusEnum.OUTPUT;
        }
        else if(value == 1)
        {
            Port_RA.PortAStatus[index] = StatusEnum.INPUT;
        }
    }

    public static void resetTrisA() {
        RAM.ram[133] = 0;
    }
}
