//import java.util.regex.*;

public class InstructionRegister {
    
    public static String currentInstruction;

    public static void nextInstruction()
    {
        currentInstruction = Flash.flash[PC.programCounter];
        
        InstructionDecoder.decode(currentInstruction);
        PC.inc();
    }
}
