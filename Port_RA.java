
public class Port_RA {

    public static StatusEnum[] PortAStatus = {StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT};

    public static void setPortRA(int value, int index)
    {
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(5), index, value), 5);
    }

    public static boolean getPortRA(int index)
    {
        int bit = InstructionDecoder.getBit(RAM.ram[5], index);
        if(bit == 1)
        {
            return true;
        } else{
            return false;
        }
    }

    public static void resetPort_RA() {
        RAM.ram[5] = 0;
    }
}
