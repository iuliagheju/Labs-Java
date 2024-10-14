import java.util.Random;
public class inputDevice {
    Random rand = new Random();

    static String getType() {
        return "random";
    }

    public int nextInt() {
    return rand.nextInt(100);
    }
   }


