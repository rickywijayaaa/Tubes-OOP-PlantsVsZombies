package MenuGame;

import MapGame.*;
import Sun.*;
import Plant.*;
import Inventory.*;
import Thread.*;

import java.util.concurrent.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {

    private static AtomicBoolean waitingForInput = new AtomicBoolean(false);
    private static AtomicBoolean suppressDisplayMap = new AtomicBoolean(false);
    public static boolean gameRunning = true;

    public static void play(Inventory inven) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunningGame = true;
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Sun.getInstance();
        Sun.setSun(50);
        Peta peta = new Peta();
        //inven.randomDeck();
        System.out.println("");
        System.out.println("Deck tanaman yang dapat kamu gunakan");
        System.out.println("");
        inven.displayDeck();

        GameTimerThread gt = new GameTimerThread(0, waitingForInput, suppressDisplayMap);
        ThreadControl.addThread(gt);
        ThreadControl.addThread(new GenerateSunThread(100));
        ZombieSpawnThread zt = new ZombieSpawnThread(500, peta, waitingForInput, suppressDisplayMap);
        ThreadControl.addThread(zt);
        ThreadControl.startAllThreads();

        while (gameRunning) {

            //isRunningGame ga ke modif , aku hapus aja
            System.out.println();
            // inven.displayDeck();
            System.out.println("\n1. Menanam tanaman\n2. Menghapus tanaman \n3. Melihat Map\n");

            waitingForInput.set(true);
            suppressDisplayMap.set(true);
            int choice2 = scanner.nextInt();
            waitingForInput.set(false);
            suppressDisplayMap.set(true);

            switch (choice2) {
                case 1:
                    int choose4 = scanner.nextInt();
                    // waitingForInput.set(true);
                    if(choose4 < 1 || choose4 > 6){
                        System.out.println(" ");
                        System.out.println("Input invalid");
                    }
                    suppressDisplayMap.set(false);
                    plantSelectedPlant(scanner, inven, peta, choose4);
                    waitingForInput.set(false);
                    suppressDisplayMap.set(false);
                    break;
                case 2:
                    waitingForInput.set(true);
                    suppressDisplayMap.set(false);
                    System.out.printf("Pilih baris untuk tanaman dicabut (x) : ");
                    int koorxRemove = scanner.nextInt();
                    System.out.printf("Pilih kolom untuk tanaman dicabut (y) : ");
                    int kooryRemove = scanner.nextInt();

                    try {
                        peta.removePlant(koorxRemove, kooryRemove);
                        System.out.println("Removed plant from (" + koorxRemove + ", " + kooryRemove + ")");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n");
                    peta.displayMap(true);
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
            }


        }


    }

    private static void plantSelectedPlant(Scanner scanner, Inventory inven, Peta peta, int choose4) {
        System.out.println("");
        System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
        int koorx = scanner.nextInt();
        System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
        int koory = scanner.nextInt();
    
        Plant selectedPlant = (Plant) inven.getDeckInven().get(choose4 - 1);
        String plantName = selectedPlant.getName();
    
        try {
            Plant plantToBePlanted = PlantFactory.createPlant(plantName, koorx, koory);
            peta.plant(plantToBePlanted, koorx, koory);
        } catch (IllegalArgumentException e) {
            System.out.println("Tanaman tidak valid. Silakan pilih tanaman yang sesuai.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void setGameRunning(){
        gameRunning = false;
    }
}
