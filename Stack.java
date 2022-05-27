public class Stack {

    static int[] stack = new int[8];
    static int stackPointer = 0;

    public static int push(int value) {
        if (stackPointer == 7) {
            return -1;
        }
        stack[stackPointer] = value;
        System.out.println("Value pushed to Stack: " + value);
        stackPointer = stackPointer + 1;
        return 0;
    }

    public static int pop()
    {
        stackPointer--;
        System.out.println("Value poped from Stack: " + stack[stackPointer]);
        return stack[stackPointer];
    }

    public static int getValueUI(int index)
    {
        return stack[index];
    }

    public static void resetStack()
    {
        for(int i = 0; i < stack.length; i++){
            stack[i] = 0;
        }
    }
}