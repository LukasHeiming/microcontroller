
public class PC {

    public static int programCounter = 0;
    private static int mask = 0b11111111;

    public static void inc() {

        

        if ((programCounter & 0b11111111)== mask) {
            programCounter = 0;
        }
        programCounter++;
        PCL.setPCL(programCounter);
        //int pclath = PCLATH.getPCLATHInt() << 8;
        //programCounter = programCounter + pclath;
    }

    public static void resetProgrammCounter() {
        programCounter = 0;
        System.out.println("Programmcounter reset.");
    }
}
