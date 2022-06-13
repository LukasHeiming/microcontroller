
public class FSR_Register {
    
    public static int fsr = 0;
    public static int fsrMask = 0b11111111;

    public static void setFsr(int value)
    {
        fsr = value & fsrMask;
    }

    public static int getFsr()
    {
        fsr = RAM.getRam(4);

        return fsr;
    }
}
