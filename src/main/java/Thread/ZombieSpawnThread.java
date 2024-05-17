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
import Creature.*;
import Inventory.*;

public class ZombieSpawnThread implements Runnable {
    private int gametimer;
    private Peta peta;
    private static ArrayList<Zombie> listzombie;
    private static ArrayList<Plant> listplant;

    public ZombieSpawnThread(int gametimer, Peta mainlawn){
        this.gametimer = gametimer;
        this.peta = mainlawn;
        listzombie = new ArrayList<Zombie>();
        listplant = new ArrayList<Plant>();
    }
    
    @Override
    public void run() {
        try {
                // !! Ini Logic untuk Zombie Spawn !! 
                // Random spawn zombie
                Random rand = new Random();
                ZombieDeck deckzom = new ZombieDeck();
                int zombieCount = 0;
                Sunflower sun1 = new Sunflower(0,1);
                Sunflower sun2 = new Sunflower(1,1);
                Repeater plant2 = new Repeater(4,1);
                Repeater plant3 = new Repeater(5,1);
                Tile zomtile5 = peta.getTile(0,1);
                Tile zomtile6 = peta.getTile(1,1);
                Tile zomtile7 = peta.getTile(4,1);
                Tile zomtile8 = peta.getTile(5,1);
                zomtile5.addCreature(sun1);
                zomtile6.addCreature(sun2);
                zomtile7.addCreature(plant2);
                zomtile8.addCreature(plant3);

                for (int row = 0; row < 6; row++) {
                    for (int col = 0; col < 11; col++) {
                        Tile tile = peta.getTile(row, col);
                        ArrayList<Creature> entities = tile.getEntities();
                        for (Creature creature : entities) {
                            if (creature instanceof Plant) {
                                listplant.add((Plant) creature);
                            }
                        }

                    }
                }
            
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
                        for (int x = 0 ; x < listplant.size();x++) {
                            if (listplant.get(x) instanceof Sunflower) {
                                Sunflower sun = (Sunflower)listplant.get(x); 
                                sun.act();
                            }
                        }
                        System.out.println("jumlah matahari : "+ Sun.getSun());
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