
//import java.util.BitSet;

public class RAM {
    
    private static int[] ram = new int[256];//12 - 79  140-207  SFR: 0 - 11  128 - 139
    private static int mask = 0b11111111;
    public static int[] ramUsage = new int[256];
    //Bank 0: 0 - 79
    //Bank 1: 128-207
    //80 - 127 gibts nich

    public static int getRam(int index)
    {
        if(index >= 0 && index <= 79)
        {
            if(StatusReg.getRP0() == 0 && StatusReg.getRP1() == 0  || StatusReg.getRP0() == 0 && StatusReg.getRP1() == 1)
            {
                return ram[index];
            }
            else if(StatusReg.getRP0() == 1 && StatusReg.getRP1() == 0 || StatusReg.getRP0() == 1 && StatusReg.getRP1() == 1)
            {
                return ram[index+128];
            }
        }
        return -1;
    }

    public static int setRam(int value, int index)
    {
        if(index >= 12 && index <= 79)
        {
            if(StatusReg.getRP0() == 0 && StatusReg.getRP1() == 0  || StatusReg.getRP0() == 0 && StatusReg.getRP1() == 1)
            {
                    ram[index] = value & mask;
                    ramUsage[index] = 1;
                    return 1;
            }
            else if(StatusReg.getRP0() == 1 && StatusReg.getRP1() == 0 || StatusReg.getRP0() == 1 && StatusReg.getRP1() == 1)
            {
                    ram[index+128] = value & mask;
                    ramUsage[index+128] = 1;
                    return 1;
            }
        }
        return -1;
    }

    public static int getRamHex(int index)
    {
       if(index >= 12 && index <= 79)
        {
            if(StatusReg.getRP0() == 0 && StatusReg.getRP1() == 0  || StatusReg.getRP0() == 0 && StatusReg.getRP1() == 1)
            {
                return Integer.parseInt(Integer.toHexString(ram[index]));
            }
            else if(StatusReg.getRP0() == 1 && StatusReg.getRP1() == 0 || StatusReg.getRP0() == 1 && StatusReg.getRP1() == 1)
            {
                return Integer.parseInt(Integer.toHexString(ram[index+128]));
            }
        }
        return -1;
    }
}
