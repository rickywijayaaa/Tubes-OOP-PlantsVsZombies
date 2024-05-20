package MenuGame;

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
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {

    private static AtomicBoolean waitingForInput = new AtomicBoolean(false);
    private static AtomicBoolean suppressDisplayMap = new AtomicBoolean(false);

    public static void play(Inventory inven) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunningGame = true;
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Sun.getInstance();
        Sun.setSun(500);
        Peta peta = new Peta();
        System.out.println("");
        System.out.println("Deck tanaman yang dapat kamu gunakan");
        System.out.println("");
        inven.displayDeck();

        ThreadControl.addThread(new GameTimerThread(0, waitingForInput, suppressDisplayMap));
        ThreadControl.addThread(new GenerateSunThread(100));
        ThreadControl.addThread(new ZombieSpawnThread(200, peta, waitingForInput, suppressDisplayMap));
        ThreadControl.startAllThreads();

        while (isRunningGame) {
            System.out.println();
            inven.displayDeck();
            System.out.println("\n<1 x y indexplant> menanam tanaman di koordinat (x,y)\n<2 x y> dig tanaman di map\n");

            waitingForInput.set(true);
            suppressDisplayMap.set(true);
            int choice2 = scanner.nextInt();
            waitingForInput.set(false);
            suppressDisplayMap.set(false);

            switch (choice2) {
                case 1:
                    int choose4 = scanner.nextInt();
                    waitingForInput.set(true);
                    suppressDisplayMap.set(true);
                    plantSelectedPlant(scanner, inven, peta, choose4);
                    waitingForInput.set(false);
                    suppressDisplayMap.set(false);
                    break;
                case 2:
                    // Handle plant removal logic
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
        Plant plantToBePlanted = null;

        switch (plantName) {
            case "Sunflower":
                plantToBePlanted = new Sunflower(koorx, koory);
                break;
            case "Repeater":
                plantToBePlanted = new Repeater(koorx, koory);
                break;
            case "Snow Pea":
                plantToBePlanted = new SnowPea(koorx, koory);
                break;
            case "Lilypad":
                plantToBePlanted = new Lilypad(koorx, koory);
                break;
            case "Wallnut":
                plantToBePlanted = new Wallnut(koorx, koory);
                break;
            case "Peashooter":
                plantToBePlanted = new Peashooter(koorx, koory);
                break;
            case "Squash":
                plantToBePlanted = new Squash(koorx, koory);
                break;
            case "Cherry Bomb":
                plantToBePlanted = new CherryBomb(koorx, koory);
                break;
            case "Cabbage Pult":
                plantToBePlanted = new CabbagePult(koorx, koory);
                break;
            case "Tangle Kelp":
                plantToBePlanted = new TangleKelp(koorx, koory);
                break;
            default:
                System.out.println("Tanaman tidak valid. Silakan pilih tanaman yang sesuai.");
                return;
        }

        if (plantToBePlanted != null) {
            try {
                peta.plant(plantToBePlanted, koorx, koory);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
