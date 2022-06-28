
public class Vorteiler {

    static int faktor = 1;

    public static void reset()
    {
        faktor = 1;
    }

    public static void setPrescaler() {
        int value = Option.getPS0() * 1 + Option.getPS1() * 2 + Option.getPS2() * 4;
        if (Option.getPSA() == 1) {
            switch (value) {
                case 0:
                    faktor = 1;
                    break;
                case 1:
                    faktor = 2;
                    break;
                case 2:
                    faktor = 4;
                    break;
                case 3:
                    faktor = 8;
                    break;
                case 4:
                    faktor = 16;
                    break;
                case 5:
                    faktor = 32;
                    break;
                case 6:
                    faktor = 64;
                    break;
                case 7:
                    faktor = 128;
                    break;
                default:
                    break;
            }
        }
        else if(Option.getPSA() == 0)
        {
            switch (value) {
                case 0:
                    faktor = 2;
                    break;
                case 1:
                    //System.out.println("Es wird faktor auf 4 gesetzt.");
                    faktor = 4;
                    break;
                case 2:
                    faktor = 8;
                    break;
                case 3:
                    faktor = 16;
                    break;
                case 4:
                    faktor = 32;
                    break;
                case 5:
                    faktor = 64;
                    break;
                case 6:
                    faktor = 128;
                    break;
                case 7:
                    faktor = 256;
                    break;
                default:
                    break;
            }
        }
    }

    public static int getPrescaler() {
        return faktor;
    }
}
