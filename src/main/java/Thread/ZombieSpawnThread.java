package Thread;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

import Koordinat.Koordinat;
import MapGame.*;
import MenuGame.*;
import Plant.*;
import Zombies.*;
import Creature.*;
import Inventory.*;
import Sun.*;
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
    private volatile boolean zombieWins;
    private volatile boolean noZombie160;

    public ZombieSpawnThread(int gametimer, Peta mainlawn, AtomicBoolean waitingForInput, AtomicBoolean suppressDisplayMap) {
        this.gametimer = gametimer;
        this.peta = mainlawn;
        this.waitingForInput = waitingForInput;
        this.suppressDisplayMap = suppressDisplayMap;
        listzombie = new ArrayList<>();
        listplant = new ArrayList<>();
        uniquePlants = new HashSet<>();
        message = "|| Zombie Count: " + listzombie.size();
       zombieWins = false;
       noZombie160 = false;
    }

    @Override
    public void run() {
        while(!zombieWins){
            try {

                Random rand = new Random();
                ZombieDeck deckzom = new ZombieDeck();
                int zombieCount = 0;

                while (gametimer > 0) {
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

                    int currentTime = ThreadControl.getGameTimerThread().getCurrentGameTime();
                    if (currentTime > 20 && currentTime < 155 && currentTime % 3 == 0) {
                        if ((rand.nextInt(10) > 7) && (zombieCount < 10)) {
                            spawnZombie(rand, deckzom);
                            zombieCount++;
                            updateMessage();
                        }
                    } else if (currentTime > 155 && currentTime <= 160) {
                        while (zombieCount < 25) {
                          //berarti zombie 1<=x<=25
                            spawnZombie(rand, deckzom);
                            zombieCount++;
                        }
                        updateMessage();
                    }
                    else if (currentTime > 160) {
                        if(zombieCount == 0){
                            noZombie160 = true;
                            ThreadControl.stopAllThreads();
                            System.out.println(".-------.   .---.        ____    ,---.   .--.,---------.         .--.      .--..-./`) ,---.   .--.   .-'''-. .---.  .---.  .---.  .---.  .---.         ");
                            System.out.println("\\  _(`)_ \\  | ,_|      .'  __ `. |    \\  |  |\\          \\        |  |_     |  |\\ .-.')|    \\  |  |  / _     \\\\   /  \\   /  \\   /  \\   /  \\   /         ");
                            System.out.println("| (_ o._)|,-./  )     /   '  \\  \\|  ,  \\ |  | `--.  ,---'        | _( )_   |  |/ `-' \\|  ,  \\ |  | (`' )/`--'|   |  |   |  |   |  |   |  |   |         ");
                            System.out.println("|  (_,_) /\\  '_ '`)   |___|  /  ||  |\\_ \\|  |    |   \\           |(_ o _)  |  | `-'`\"`|  |\\_ \\|  |(_ o _).    \\ /    \\ /    \\ /    \\ /    \\ /          ");
                            System.out.println("|   '-.-'  > (_)  )      _.-`   ||  _( )_\\  |    :_ _:           | (_,_) \\ |  | .---. |  _( )_\\  | (_,_). '.   v      v      v      v      v           ");
                            System.out.println("|   |     (  .  .-'   .'   _    || (_ o _)  |    (_I_)           |  |/    \\|  | |   | | (_ o _)  |.---.  \\  : _ _    _ _    _ _    _ _    _ _          ");
                            System.out.println("|   |      `-'`-'|___ |  _( )_  ||  (_,_)/  |   (_(=)_)          |  '  /\\  `  | |   | |  (_,_)/  |\\    `-'  |(_I_)  (_I_)  (_I_)  (_I_)  (_I_)         ");
                            System.out.println("/   )       |        \\\\ (_ o _) /|  |    |  |    (_I_)           |    /  \\    | |   | |  |    |  | \\       /(_(=)_)(_(=)_)(_(=)_)(_(=)_)(_(=)_)        ");
                            System.out.println("`---'       `--------` '.(_,_).' '--'    '--'    '---'           `---'    `---` '---' '--'    '--'  `-...-'  (_I_)  (_I_)  (_I_)  (_I_)  (_I_)         ");
                            MenuGame.Menu();
                            // System.exit(0);
                            break;
                        }
                        
                    }

                    moveZombies();
                    activatePlants();

                    // Update zombie count after moving zombies and activating plants
                    zombieCount = listzombie.size();
                    
                    removeDeadEntities(listzombie, listplant);

                    if (waitingForInput.get() && suppressDisplayMap.get() && currentTime > 20) {
                        System.out.println("");
                        System.out.println("Time right now: " + currentTime + "|| Sun : "+ Sun.getSun());
                        peta.displayMap(false);
                    }


                    for(Zombie z : listzombie){
                        Koordinat kz = z.getKoordinat();
                        if(kz.getY() == 0 ){
//                            System.out.println("shit");
                            zombieWins = true;
                            waitingForInput.set(true);
                            suppressDisplayMap.set(true);
                            ThreadControl.stopAllThreads();
                            System.out.println("  ____..--'    ,-----.    ,---.    ,---. _______  .-./`)     .-''-.          .--.      .--..-./`) ,---.   .--.   .-'''-. .---.  .---.  .---.  .---.  .---.         ");
                            System.out.println(" |        |  .'  .-,  '.  |    \\  /    |\\  ____  \\\\ .-.')  .'_ _   \\         |  |_     |  |\\ .-.')|    \\  |  |  / _     \\\\   /  \\   /  \\   /  \\   /  \\   /         ");
                            System.out.println(" |   .-'  ' / ,-.|  \\ _ \\ |  ,  \\/  ,  || |    \\ |/ `-' \\ / ( ` )   '        | _( )_   |  |/ `-' \\|  ,  \\ |  | (`' )/`--'|   |  |   |  |   |  |   |  |   |         ");
                            System.out.println(" |.-'.'   /;  \\  '_ /  | :|  |\\_   /|  || |____/ / `-'`\"`. (_ o _)  |        |(_ o _)  |  | `-'`\"`|  |\\_ \\|  |(_ o _).    \\ /    \\ /    \\ /    \\ /    \\ /          ");
                            System.out.println("    /   _/ |  _`,/ \\ _/  ||  _( )_/ |  ||   _ _ '. .---. |  (_,_)___|        | (_,_) \\ |  | .---. |  _( )_\\  | (_,_). '.   v      v      v      v      v           ");
                            System.out.println("  .'._( )_ : (  '\\_/ \\   ;| (_ o _) |  ||  ( ' )  \\|   | '  \\   .---.        |  |/    \\|  | |   | | (_ o _)  |.---.  \\  : _ _    _ _    _ _    _ _    _ _          ");
                            System.out.println(".'  (_'o._) \\ `\"/  \\  ) / |  (_,_)  |  || (_{;}_) ||   |  \\  `-'    /        |  '  /\\  `  | |   | |  (_,_)/  | \\    `-'  |(_I_)  (_I_)  (_I_)  (_I_)  (_I_)         ");
                            System.out.println("|    (_,_)|  '. \\_/``\".'  |  |      |  ||  (_,_)  /|   |   \\       /         |    /  \\    | |   | |  |    |  | \\       /(_(=)_)(_(=)_)(_(=)_)(_(=)_)(_(=)_)        ");
                            System.out.println("|_________|    '-----'    '--'      '--'/_______.' '---'    `'-..-'          `---'    `---` '---' '--'    '--'  `-...-'  (_I_)  (_I_)  (_I_)  (_I_)  (_I_)         ");
                            MenuGame.Menu();
                            break;
                        }
                    }
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void spawnZombie(Random rand, ZombieDeck deckzom) {
        int bariszom = rand.nextInt(6);
        int acakzombie = rand.nextInt(deckzom.getZombieDeck().size());
        Zombie zom = deckzom.getZombieDeck().get(acakzombie).clone();
        // System.out.println("\nZombie spawned: " + zom.getName());
        // System.out.println("");

        if (bariszom == 2 || bariszom == 3) {
            if (zom.isAquatic()) {
                peta.getTile(bariszom, 10).addCreature(zom);
                zom.setKoordinat(bariszom, 10);
                listzombie.add(zom);
            }
        } else {
            if (!zom.isAquatic()) {
                peta.getTile(bariszom, 10).addCreature(zom);
                zom.setKoordinat(bariszom, 10);
                listzombie.add(zom);
            }
        }
    }

    private void moveZombies() {
        for (Zombie zombie : listzombie) {
            zombie.walk(peta);
        }
    }

    private void activatePlants() {
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
            } else if (plant instanceof Squash) {
                ((Squash) plant).attack2(peta);
            } else if (plant instanceof TangleKelp) {
                ((TangleKelp) plant).attack2(peta);
            } else if (plant instanceof CherryBomb) {
                ((CherryBomb) plant).attack2(peta);
            }
        }
    }

    private void removeDeadEntities(List<Zombie> zombies, List<Plant> plants) {
        Iterator<Zombie> zombieIterator = zombies.iterator();
        while (zombieIterator.hasNext()) {
            Zombie zombie = zombieIterator.next();
            if (!zombie.isAlive()) {
                zombie.die(peta);
                System.out.println(" ");
                System.out.println(zombie.getName() + " has died!!");
                zombieIterator.remove();
            }
        }

        Iterator<Plant> plantIterator = plants.iterator();
        while (plantIterator.hasNext()) {
            Plant plant = plantIterator.next();
            if (!plant.isAlive()) {
                plant.die(peta);
                System.out.println(" ");
                System.out.println(plant.getName() + " has died!!");
                plantIterator.remove();
            }
        }
    }

    private static void updateMessage() {
        message = " || Zombie Count: " + listzombie.size();
    }

    public static String getMessage() {
        return message;
    }

    public synchronized boolean isZombieWins() {
        return zombieWins;
    }

    public synchronized boolean isNoZombie160() {
        return noZombie160;
    }
}
