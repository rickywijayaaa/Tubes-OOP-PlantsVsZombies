import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;
import Thread.*;
import java.util.concurrent.*;
import java.util.Scanner;



public class  App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunningGame = true;
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Sun.getInstance();
        Sun.setSun(0);
        Peta peta = new Peta();
        Inventory inven = new Inventory();

    //     ZombieDeck dekzom = new ZombieDeck();
    //     dekzom.displayZombieDeck();
        
    //     GenerateSunThread sunThread = new GenerateSunThread(30);
    //     Sunflower sun1 = new Sunflower(0,1);
    //     sun1.act();
    //     System.out.println("jumlah matahari : " + Sun.getSun());

    //     Sunflower sunflower1 = new Sunflower(0, 0);
    //     Sunflower sunflower2 = new Sunflower(0, 1);
    //     Sunflower sunflower3 = new Sunflower(0, 2);
    //     Sunflower sunflower4 = new Sunflower(0, 3);
    //     sunThread.addSun(sunflower1);
    //     sunThread.addSun(sunflower2);
    //     sunThread.addSun(sunflower3);
    //     sunThread.addSun(sunflower4);

    //     Repeater sun1 = new Repeater(0, 1);
    //     CabbagePult sun2 = new CabbagePult(1, 1);
    //     Peashooter plant2 = new Peashooter(4, 1);
    //     SnowPea plant3 = new SnowPea(5, 1);
    //     Tile zomtile5 = peta.getTile(0, 1);
    //     Tile zomtile6 = peta.getTile(1, 1);
    //     Tile zomtile7 = peta.getTile(4, 1);
    //     Tile zomtile8 = peta.getTile(5, 1);
    //     zomtile5.addCreature(sun1);
    //     zomtile6.addCreature(sun2);
    //     zomtile7.addCreature(plant2);
    //     zomtile8.addCreature(plant3);

    //     sun1.attack2(peta);
    //     sun2.attack2(peta);
    //     plant2.attack2(peta);
    //     plant3.attack2(peta);

    //     NormalZombie zom1 = new NormalZombie(1,10);
    //     ConeheadZombie zom2 = new ConeheadZombie(4,10);
    //     Tile zomtil5 = peta.getTile(1, 10);
    //     Tile zomtil6 = peta.getTile(4, 10);
    //     zomtil5.addCreature(zom1);
    //     zomtil6.addCreature(zom2);
    //     sun1.attack2(peta);
    //     sun2.attack2(peta);
    //     plant2.attack2(peta);
    //     plant3.attack2(peta);
    //    peta.displayMap();

        
        // Start the GenerateSunThread
<<<<<<< HEAD
        // Thread thread = new Thread(sunThread);
        // thread.start();
        // ThreadControl.addThread(new GenerateSunThread(100));
        // ThreadControl.addThread(new GameTimerThread(0));
        // ThreadControl.addThread(new ZombieSpawnThread(200,peta));
        // ThreadControl.startAllThreads();  
    

=======
//         Thread thread = new Thread(sunThread);
//         thread.start();
//        ThreadControl.addThread(new GameTimerThread(0));
//        ThreadControl.addThread(new GenerateSunThread(100));
//        ThreadControl.addThread(new ZombieSpawnThread(200,peta));
//        ThreadControl.startAllThreads();
>>>>>>> 712046afd7339f1aa4c0ad4cf77ef1a3f3936da8
        MenuGame.Menu();

    }       
}