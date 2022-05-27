
enum StatusEnum {
    INPUT, OUTPUT
}

public class Port_RB {

    //7: RB7
    //6: RB6
    //5: RB5
    //4: RB4
    //3: RB3
    //2: RB2
    //1: RB1
    //0: RBo/INT
    private static boolean[] Port_RB = {false,false,false,false,false,false,false,false};
    public static StatusEnum[] RBStatus = {StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT,StatusEnum.INPUT};

    public static boolean getPort_RB(int index) {
        return Port_RB[index];
    }

    public static void setPort_RB(boolean Port_RB_Value, int index) {
        Port_RB[index] = Port_RB_Value;
    }

    public static void resetPort_RB() {
        for(int i = 0; i < Port_RB.length; i++){
            Port_RB[i] = false;
        }
    }
}
