package Sun;
import java.util.Random;


public class Sun {
    private int sunWaktuTunggu;
    private int sunProduction = 25;
    private static int lastSun;
    

    public static void SunGenerate(int sunWaktuTunggu, int sunProduction){
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