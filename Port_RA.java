
public class Port_RA {

    private static  boolean[] Port_RA = {false,false,false,false,false};
    public static StatusEnum[] PortAStatus = {StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT};

    public static void setPortRA(boolean value, int index)
    {
        Port_RA[index] = value;
    }

    public static boolean getPortRA(int index)
    {
        int regVal = 0;
        for(int i = 0; i < Port_RA.length;i++)
        {
            if(Port_RA[i] == true)
            {
                regVal = regVal + (int)Math.pow(2, i);
            }
        }
        RAM.setRegister(5, regVal, 0);
        return Port_RA[index];
    }

    public static void resetPort_RA() {
        for(int i = 0; i < Port_RA.length; i++){
            Port_RA[i] = false;
        }
    }
}
