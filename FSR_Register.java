
public class FSR_Register {

    public static void setFsr(int value)
    {
        RAM.setRam(value, 4);
    }

    public static int getFsr()
    {
        return RAM.getRam(4);
    }
}
