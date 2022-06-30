//import java.util.regex.*;

public class InstructionRegister {
    
    public static String currentInstruction;

    public static void nextInstruction()
    {
        currentInstruction = Flash.flash[PC.programCounter];
        
        InstructionDecoder.decode(currentInstruction);
        if(!currentInstruction.contains("goto") && !currentInstruction.contains("call") && !currentInstruction.contains("retlw") && !currentInstruction.contains("return") && !currentInstruction.contains("retfie")){
            PC.inc();
        }else{
            System.out.println("PC.inc() wurde übersprungen da letzer Befehl ein Call oder Goto war.");
        }
    }
}
