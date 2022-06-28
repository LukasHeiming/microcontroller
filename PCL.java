public class PCL {
    

    public static String getPCL()
    {
        return Integer.toHexString(RAM.getRamAll(2));
    }

    public static void setPCL(int value)
    {
        RAM.setRamAll(value, 2);
    }

    public static int getPCLInt()
    {
        return (RAM.getRamAll(2));
    }
}
