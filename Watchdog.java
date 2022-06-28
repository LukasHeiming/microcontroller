
public class Watchdog {
    
    static int triggerVal = 18000; // 18 mikro Sekunden Standard Wert
    static int counter = 0; //mikroSekunden


    static void resetWatchdogTimer(){
        counter = 0;
    }

    static void update(){

    }
}
