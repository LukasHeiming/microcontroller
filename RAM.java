
//import java.util.BitSet;

public class RAM {
    
    private static int[] ram = new int[256];//12 - 79  140-207  SFR: 0 - 11  128 - 139
    private static int mask = 0b11111111;
    

    public static int getRam(int index)
    {
        if(index >= 12 && index <= 79)
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

    public static void setRam(int value, int index)
    {
        if(index >= 12 && index <= 79)
        {
            if(StatusReg.getRP0() == 0 && StatusReg.getRP1() == 0  || StatusReg.getRP0() == 0 && StatusReg.getRP1() == 1)
            {
                ram[index] = value & mask;
            }
            else if(StatusReg.getRP0() == 1 && StatusReg.getRP1() == 0 || StatusReg.getRP0() == 1 && StatusReg.getRP1() == 1)
            {
                ram[index+128] = value & mask;
            }
        }
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
