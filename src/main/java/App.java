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



public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunningGame = true;
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Sun.getInstance();
        Sun.setSun(0);
        Peta peta = new Peta();
        Inventory inven = new Inventory();
        // ZombieDeck dekzom = new ZombieDeck();
        //dekzom.displayZombieDeck();
        
        // GenerateSunThread sunThread = new GenerateSunThread(30);
        // Sunflower sun1 = new Sunflower(0,1);
        // sun1.act();
        // System.out.println("jumlah matahari : " + Sun.getSun());

        // Sunflower sunflower1 = new Sunflower(0, 0);
        // Sunflower sunflower2 = new Sunflower(0, 1);
        // Sunflower sunflower3 = new Sunflower(0, 2);
        // Sunflower sunflower4 = new Sunflower(0, 3);
        // sunThread.addSun(sunflower1);
        // sunThread.addSun(sunflower2);
        // sunThread.addSun(sunflower3);
        // sunThread.addSun(sunflower4);
        
        // Start the GenerateSunThread
        // Thread thread = new Thread(sunThread);
        // thread.start();
        //MenuGame.Menu();
        ThreadControl.addThread(new GenerateSunThread(100));
        ThreadControl.addThread(new GameTimerThread(0));
        ThreadControl.addThread(new ZombieSpawnThread(200,peta));
        ThreadControl.startAllThreads();
    }       
}