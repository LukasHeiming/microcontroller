
public class W_Register {
    
    private static int value;
    private static int mask = 0b1111111;

    public static int getValue()
    {
        return value;
    }

    public static void setValue(int pValue)
    {
        value = pValue & mask;
        
    }

    public static void resetValue()
    {
        value = 0;
    }

}
