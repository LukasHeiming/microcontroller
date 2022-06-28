public class PCLATH {
   
    public static String getPCLATH()
    {
        return Integer.toHexString(RAM.getRamAll(10));
    }

    public static void setPCLATH(int value)
    {
        RAM.setRam(value % 31, 10);
    }

    public static int getPCLATHInt()
    {
        return RAM.getRamAll(10);
    }
}
