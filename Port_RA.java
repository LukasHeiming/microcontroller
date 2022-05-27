
public class Port_RA {

    private static  boolean[] Port_RA = {false,false,false,false,false};
    public static StatusEnum[] PortAStatus = {StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT};

    public static void setPortRA(boolean value, int index)
    {
        Port_RA[index] = value;
    }

    public static boolean getPortRA(int index)
    {
        return Port_RA[index];
    }

    public static void resetPort_RA() {
        for(int i = 0; i < Port_RA.length; i++){
            Port_RA[i] = false;
        }
    }
}
