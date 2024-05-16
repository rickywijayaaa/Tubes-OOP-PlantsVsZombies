package Thread;

import java.util.Random;
import java.util.ArrayList;
import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;

public class ZombieSpawnThread implements Runnable {
    private int gametimer;
    private Peta peta;
    private static ArrayList<Zombie> listzombie;

    public ZombieSpawnThread(int gametimer, Peta mainlawn){
        this.gametimer = gametimer;
        this.peta = mainlawn;
        listzombie = new ArrayList<Zombie>();
    }
    
    @Override
    public void run() {
        try {
                // !! Ini Logic untuk Zombie Spawn !! 
                // Random spawn zombie
                Random rand = new Random();
                ZombieDeck deckzom = new ZombieDeck();
                int zombieCount = 0;
                while(gametimer > 0){
                    if (ThreadControl.getGameTimerThread().getCurrentGameTime() >20 && ThreadControl.getGameTimerThread().getCurrentGameTime() <160) {

                        if(zombieCount <3){
                            int bariszom = rand.nextInt(0, 5);
                            NormalZombie zom1 = new NormalZombie(bariszom,10);
                            Tile zomtile = peta.getTile(bariszom,10);
                            zomtile.addCreature(zom1);
                            listzombie.add(zom1);
                            zombieCount++;
                        }
                        //if (((rand.nextInt(0,10)) > 3) && (zombieCount < 3)) {
                        //     int bariszom = rand.nextInt(0, 5);
                        //     int acakzombie = rand.nextInt(0,9);
                        //     System.out.println("Zombie spawned");
                        //     Tile zomtile = peta.getTile(bariszom,10);
                        //     Koordinat newkoor = new Koordinat(bariszom,10);
                        //     Zombie zomm1
                        //     zomm1.setKoordinat(newkoor);
                        //     zomtile.addCreature(zomm1);
                        //     listzombie.add(zomm1);
                        //     zombieCount++;
                        // } else {
                        //     System.out.println("Zombie not spawned");
                        // }
                    
                        System.out.println("Zombie Count: " + zombieCount);
                        System.out.println();
                        for (Zombie zombie : listzombie) {
                            zombie.walk(peta);
                        }
                        peta.displayMap();
                    }
                    Thread.sleep(1000);
                }
               
                
                
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public ArrayList<Zombie> getListZombie(){
        return listzombie;
    }
    
} 