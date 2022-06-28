
enum StatusEnum {
    INPUT, OUTPUT
}

public class Port_RB {

    // 7: RB7
    // 6: RB6
    // 5: RB5
    // 4: RB4
    // 3: RB3
    // 2: RB2
    // 1: RB1
    // 0: RBo/INT
    static int tempFlanke;

    static int tempRB4;
    static int tempRB5;
    static int tempRB6;
    static int tempRB7;
    public static StatusEnum[] RBStatus = { StatusEnum.INPUT, StatusEnum.INPUT, StatusEnum.INPUT, StatusEnum.INPUT,
            StatusEnum.INPUT, StatusEnum.INPUT, StatusEnum.INPUT, StatusEnum.INPUT };

    public static boolean getPort_RB(int index) {

        int bit = InstructionDecoder.getBit(RAM.ram[6], index);
        if (bit == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void setPort_RB(int Port_RB_Value, int index) {
        RAM.setRam(InstructionDecoder.modifyBit(RAM.getRam(6), index, Port_RB_Value), 6);
    }

    public static void resetPort_RB() {
        RAM.ram[6] = 0;
    }

    public static void RB0Interrupt() {
        System.out.println("RB0 INTERRUPT");

        if (Option.getINTDEG() == 1) {
            System.out.println("RB0 STEIGEND");
            boolean temp = Port_RB.getPort_RB(0);
            int itemp;
            if (temp == true) {
                itemp = 1;
            } else {
                itemp = 0;
            }
            if (tempFlanke == 0 && itemp == 1) {
                Intcon.setINTF(1);
            }
        }

        if (Option.getINTDEG() == 0) {
            System.out.println("RB0 FALLEND");
            boolean temp = Port_RB.getPort_RB(0);
            int itemp;
            if (temp == true) {
                itemp = 1;
            } else {
                itemp = 0;
            }
            if (tempFlanke == 1 && itemp == 0) {
                Intcon.setINTF(1);
            }
            tempFlanke = itemp;
        }

        if (Intcon.getINTF() == 1 && Intcon.getGIE() == 1 && Intcon.getINTE() == 1) {
            System.out.println("RB0 PUSH");
            Intcon.setGIE(0);
            Stack.push(PC.programCounter);
            PC.programCounter = 3;
        }

    }

    public static void RB04_7Interrupt()
    {
        System.out.println("RB4-7 INTERRUPT");
        boolean temp4 = Port_RB.getPort_RB(4);
        boolean temp5 = Port_RB.getPort_RB(5);
        boolean temp6 = Port_RB.getPort_RB(6);
        boolean temp7 = Port_RB.getPort_RB(7);

        int itemp4 = temp4 ? 1 : 0;
        int itemp5 = temp5 ? 1 : 0;
        int itemp6 = temp6 ? 1 : 0;
        int itemp7 = temp7 ? 1 : 0;

        if((itemp4 != tempRB4 && RBStatus[4] == StatusEnum.INPUT)  
        || (itemp5 != tempRB5 && RBStatus[5] == StatusEnum.INPUT) 
        || (itemp6 != tempRB6  && RBStatus[6] == StatusEnum.INPUT)
        || (itemp7 != tempRB7 && RBStatus[7] == StatusEnum.INPUT))
        {
            Intcon.setRBIF(1);
        }

        tempRB4 = itemp4;
        tempRB5 = itemp5;
        tempRB6 = itemp6;
        tempRB7 = itemp7;

        if(Intcon.getRBIE() == 1 && Intcon.getGIE() == 1 && Intcon.getRBIF() == 1)
        {
            System.out.println("RB4-7 PUSH");
            Intcon.setGIE(0);
            Stack.push(PC.programCounter);
            PC.programCounter = 3;
        }

    }
}
