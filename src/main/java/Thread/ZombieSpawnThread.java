package Thread;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Creature.*;
import Inventory.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ZombieSpawnThread implements Runnable {
    private int gametimer;
    private Peta peta;
    private static List<Zombie> listzombie;
    private static ArrayList<Plant> listplant;
    private static String message;
    private AtomicBoolean waitingForInput;
    private static HashSet<Plant> uniquePlants;

    public ZombieSpawnThread(int gametimer, Peta mainlawn,AtomicBoolean waitingForInput) {
        this.gametimer = gametimer;
        this.peta = mainlawn;
        this.waitingForInput = waitingForInput;
        listzombie = new ArrayList<>();
        listplant = new ArrayList<>();
        uniquePlants = new HashSet<>();
        message = "|| Zombie Count: " + listzombie.size();
    }

    @Override
    public void run() {
        try {
            // Zombie Spawn Logic
            Random rand = new Random();
            ZombieDeck deckzom = new ZombieDeck();
            int zombieCount = 0;
            // Repeater sun1 = new Repeater(0, 1);
            // CabbagePult sun2 = new CabbagePult(1, 1);
            // Peashooter plant2 = new Peashooter(4, 1);
            // SnowPea plant3 = new SnowPea(5, 1);
            // Tile zomtile5 = peta.getTile(0, 1);
            // Tile zomtile6 = peta.getTile(1, 1);
            // Tile zomtile7 = peta.getTile(4, 1);
            // Tile zomtile8 = peta.getTile(5, 1);
            // zomtile5.addCreature(sun1);
            // zomtile6.addCreature(sun2);
            // zomtile7.addCreature(plant2);
            // zomtile8.addCreature(plant3);

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

            while (gametimer > 0) {
                // scan tanaman yang sedang ada di peta dan dimasukkan ke list
                for (int row = 0; row < 6; row++) {
                    for (int col = 0; col < 11; col++) {
                        Tile tile = peta.getTile(row, col);
                        ArrayList<Creature> entities = tile.getEntities();
                        for (Creature creature : entities) {
                            if (creature instanceof Plant) {
                                Plant plant = (Plant) creature;
                                if (!uniquePlants.contains(plant)) {
                                    uniquePlants.add(plant);
                                    listplant.add(plant);
                                }
                            }
                        }
                    }
                }
                if (ThreadControl.getGameTimerThread().getCurrentGameTime() > 20 && ThreadControl.getGameTimerThread().getCurrentGameTime() < 160) {
                    if ((rand.nextInt(10) >7) && (zombieCount < 10)) {
                        int bariszom = rand.nextInt(6); // Perbaiki jangkauan bariszom
                        int acakzombie = rand.nextInt(deckzom.getZombieDeck().size());
                        Zombie zom = deckzom.getZombieDeck().get(acakzombie).clone(); // Buat salinan baru dari zombie
                        System.out.println("\nZombie spawned: " + zom.getName());

                        if (bariszom == 2 || bariszom == 3) {
                            if (zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            } else {
                                //System.out.println("Aquatic zombie cannot spawn on non-aquatic tile");
                            }
                        } else {
                            if (!zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            } else {
                                //System.out.println("Non-aquatic zombie cannot spawn on aquatic tile");
                            }
                        }
                        updateMessage();
                    } else {
                        //System.out.println("Zombie not spawned");
                    }
//                    System.out.println("Zombie Count: " + listzombie.size());
                    System.out.println();
                    for (Zombie zombie : listzombie) {
                        zombie.walk(peta);
                    }

                    if(!waitingForInput.get()){
                        peta.displayMap(false);
                    }
                    

                    for (Plant plant : listplant) {
                        if (plant instanceof Sunflower) {
                            ((Sunflower) plant).act();
                        } else if (plant instanceof Peashooter) {
                            ((Peashooter) plant).attack2(peta);
                        } else if (plant instanceof CabbagePult) {
                            ((CabbagePult) plant).attack2(peta);
                        } else if (plant instanceof SnowPea) {
                            ((SnowPea) plant).attack2(peta);
                        } else if (plant instanceof Repeater) {
                            ((Repeater) plant).attack2(peta);
                        }
                    }
                    System.out.println("jumlah matahari : " + Sun.getSun());
                }
                if (!listzombie.isEmpty()) {
                    Iterator<Zombie> iter = listzombie.iterator();
                    while (iter.hasNext()) {
                        Zombie zombie = iter.next();
                        if (!zombie.isAlive()) {
                            zombie.die(peta);
                            System.out.println("");
                            System.out.println(zombie.getName() + " telah matii!!");
                            iter.remove();
                        }
                    }
                }
                if (!listplant.isEmpty()) {
                    Iterator<Plant> iter2 = listplant.iterator();
                    while (iter2.hasNext()) {
                        Plant pl = iter2.next();
                        if (!pl.isAlive()) {
                            pl.die(peta);
                            System.out.println("");
                            System.out.println(pl.getName() + " telah matii!!");
                            iter2.remove();
                        }
                    }
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
    
    public static void attackZombie(Peta peta) {
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 10; j++) {
                Tile tile = peta.getTile(i, j);
                List<Plant> plants = listplant;
                List<Zombie> zombies = listzombie;
    
                if (!plants.isEmpty()) {
                    Plant plant = plants.get(0); // Assuming attacking the first plant
                    for (Zombie zombie : zombies) {
                        zombie.setAttack(true);
                        zombie.attack(plant);
                        if (plant.getHealth() <= 0) {
                            tile.removeCreature(plant);
                        }
                    }
                }
            }
        }
    }

    private static void updateMessage(){
        message = " || Zombie Count: " + listzombie.size();
    }

    public static String getMessage(){
        return message;
    }
}