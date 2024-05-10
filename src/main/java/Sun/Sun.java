package Sun;
import java.util.Random;


public class Sun {

    private static int lastSun;
    

    public static void SunGenerate(){
        Random acak = new Random();

         int sunWaktuTunggu =  acak.nextInt(6) + 5;

        try {
            Thread.sleep(sunWaktuTunggu * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        lastSun = lastSun + 25;
    }

    public long getSun(){
        return lastSun;
    }
}