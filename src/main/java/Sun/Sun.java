package Sun;


public class Sun {

    private static Sun sun;
    private static int amountSun;

    private Sun(){
        amountSun = 25;
    }

    public static Sun getInstance(){
        if (sun == null){
            sun = new Sun();
        }
        return sun;
    }

    public static int getSun() {
        return amountSun;
    }

    public static synchronized void addSun(){
        amountSun += 25;
    }

    public static synchronized void reduceSun(int harga){
        Sun.amountSun -= harga;
    }

    public static void setSun(int jumlah){
        Sun.amountSun = jumlah;
    }
}