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
    private AtomicBoolean suppressDisplayMap;
    private static HashSet<Plant> uniquePlants;

    public ZombieSpawnThread(int gametimer, Peta mainlawn, AtomicBoolean waitingForInput, AtomicBoolean suppressDisplayMap) {
        this.gametimer = gametimer;
        this.peta = mainlawn;
        this.waitingForInput = waitingForInput;
        this.suppressDisplayMap = suppressDisplayMap;
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
                // Scan plants on the map and add to list
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
                if (ThreadControl.getGameTimerThread().getCurrentGameTime() > 2 && ThreadControl.getGameTimerThread().getCurrentGameTime() < 160 && ThreadControl.getGameTimerThread().getCurrentGameTime() % 3 == 0) {
                    if ((rand.nextInt(10) > 2) && (zombieCount < 10)) {
                        int bariszom = rand.nextInt(6);
                        int acakzombie = rand.nextInt(deckzom.getZombieDeck().size());
                        Zombie zom = deckzom.getZombieDeck().get(2).clone();
                        System.out.println("\nZombie spawned: " + zom.getName());
                        System.out.println("");

                        if (bariszom == 2 || bariszom == 3) {
                            if (zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            }
                        } else {
                            if (!zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            }
                        }
                        updateMessage();
                    }
                    // System.out.println("jumlah matahari : " + Sun.getSun());
                }
                for (Zombie zombie : listzombie) {
                    zombie.walk(peta);
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
                    } else if (plant instanceof Squash){
                        ((Squash) plant).attack2(peta);
                    } else if (plant instanceof TangleKelp){
                        ((TangleKelp) plant).attack2(peta);
                    }
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
                System.out.println("");
                peta.displayMap(false);

                // for(int i=0; i<listplant.size();i++){
                //     System.out.println(listplant.get(i).getName());
                // }
                if (waitingForInput.get() && suppressDisplayMap.get() &&ThreadControl.getGameTimerThread().getCurrentGameTime()>20) {
                    System.out.println("Time right now : " + ThreadControl.getGameTimerThread().getCurrentGameTime() );
                    System.out.println("");
                    peta.displayMap(false);
                    System.out.println("");
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
            e.printStackTrace();
        }
    }

    private static void updateMessage() {
        message = " || Zombie Count: " + listzombie.size();
    }

    public static String getMessage() {
        return message;
    }
}
