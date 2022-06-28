
public class Multiplexer {
    
    static int multiplexT0CS(int clock, int ra4)
    {
        if(Option.getT0CS() == 0)
        {
            return clock;
        } else{
            return ra4;
        }
    }

    static int multiplexPSA1(int prescaler ,int muxT0CS)
    {
        if(Option.getPSA() == 0)
        {
            return prescaler;
        }
        else{
            return muxT0CS;
        }
    }

    static int multiplexPSA2(int muxT0CS, int wDog)
    {
        if(Option.getPSA() == 0)
        {
            return muxT0CS;
        }
        else{
            return wDog;
        } 
    }

    static int mutliplexPSA3(int wDog, int prescaler)
    {
        if(Option.getPSA() == 0)
        {
            return wDog;
        }
        else{
            return prescaler;
        }
    }

    static int multiplexPS(int prescaler)
    {
        int ps = Option.getPS0() + Option.getPS1() * 2 + Option.getPS2() * 4;
        return (prescaler >> ps) & 1;
    }
}
