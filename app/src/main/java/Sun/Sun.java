package Sun;
import java.util.Random;


public class Sun {
    private int sunWaktuTunggu;
    private static int lastSun;
    private int sunProduction = 25;

    public static void SunProducing(int sunWaktuTunggu, int sunProduction){
        Random acak = new Random();

        sunWaktuTunggu =  acak.nextInt(6) + 5;

        try {
            Thread.sleep(sunWaktuTunggu * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        lastSun = lastSun + sunProduction;
    }

    public long getSun(){
        return lastSun;
    }
}