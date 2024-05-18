package Thread;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    private static List<Zombie> listzombie;
    private static ArrayList<Plant> listplant;

    public ZombieSpawnThread(int gametimer, Peta mainlawn) {
        this.gametimer = gametimer;
        this.peta = mainlawn;
        listzombie = new ArrayList<>();
        listplant = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            // Zombie Spawn Logic
            Random rand = new Random();
            ZombieDeck deckzom = new ZombieDeck();
            int zombieCount = 0;
            Repeater sun1 = new Repeater(0, 1);
            CabbagePult sun2 = new CabbagePult(1, 1);
            Peashooter plant2 = new Peashooter(4, 1);
            SnowPea plant3 = new SnowPea(5, 1);
            Tile zomtile5 = peta.getTile(0, 1);
            Tile zomtile6 = peta.getTile(1, 1);
            Tile zomtile7 = peta.getTile(4, 1);
            Tile zomtile8 = peta.getTile(5, 1);
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

            while (gametimer > 0) {
                if (ThreadControl.getGameTimerThread().getCurrentGameTime() > 2 && ThreadControl.getGameTimerThread().getCurrentGameTime() < 160) {
                    if ((rand.nextInt(10) > 3) && (zombieCount < 10)) {
                        int bariszom = rand.nextInt(6); // Perbaiki jangkauan bariszom
                        int acakzombie = rand.nextInt(deckzom.getZombieDeck().size());
                        Zombie zom = deckzom.getZombieDeck().get(acakzombie).clone(); // Buat salinan baru dari zombie
                        System.out.println("Zombie spawned: " + zom.getName());

                        if (bariszom == 2 || bariszom == 3) {
                            if (zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            } else {
                                System.out.println("Aquatic zombie cannot spawn on non-aquatic tile");
                            }
                        } else {
                            if (!zom.isAquatic()) {
                                peta.getTile(bariszom, 10).addCreature(zom);
                                zom.setKoordinat(bariszom, 10);
                                listzombie.add(zom);
                                zombieCount++;
                            } else {
                                System.out.println("Non-aquatic zombie cannot spawn on aquatic tile");
                            }
                        }
                    } else {
                        System.out.println("Zombie not spawned");
                    }
                    System.out.println("Zombie Count: " + listzombie.size());
                    System.out.println();
                    for (Zombie zombie : listzombie) {
                        zombie.walk(peta);
                    }

                    peta.displayMap();

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
                        if (!zombie.getIsAlive()) {
                            zombie.die(peta);
                            System.out.println(zombie.getName() + " telah matii!!");
                            iter.remove();
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
}
