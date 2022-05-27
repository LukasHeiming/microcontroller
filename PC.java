
public class PC {

    static int programCounter = 0;
    private static int mask = 0b111111111;

    public static void inc() {
        programCounter++;
        if (programCounter == mask) {
            programCounter = 0;
        }
    }

    public static void resetProgrammCounter() {
        programCounter = 0;
    }
}
