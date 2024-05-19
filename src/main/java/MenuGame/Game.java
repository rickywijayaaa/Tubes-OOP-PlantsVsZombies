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

        ThreadControl.addThread(new GameTimerThread(0, waitingForInput));
        ThreadControl.addThread(new GenerateSunThread(100));
        ThreadControl.addThread(new ZombieSpawnThread(200, peta));
        ThreadControl.startAllThreads();

        while (isRunningGame) {
            System.out.println();
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tanam tanaman");
            System.out.println("2. Menghapus tanaman dari peta");
            System.out.println("3. Lihat Peta");
            System.out.println("4. Coba Thread");
            System.out.print("Masukkan input tindakan (1/2/3/4) : ");

            waitingForInput.set(true);
            int choice2 = scanner.nextInt();
            waitingForInput.set(false);

            switch (choice2) {
                case 1:
                    inven.displayDeck();
                    System.out.println();
                    System.out.printf("Pilih tanaman untuk ditanam : ");
                    int choose4 = scanner.nextInt();
                    waitingForInput.set(true);
                    switch (choose4) {
                        case 1:
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory = scanner.nextInt();
                            Plant plant1 = inven.getDeckInven().get(0);
                            String plantsatu = plant1.getName();
                            switch (plantsatu) {
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx, koory);
                                    Tile posisi1 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p1, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx, koory);
                                    Tile posisi2 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p2, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx, koory);
                                    Tile posisi3 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p3, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx, koory);
                                    Tile posisi4 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p4, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx, koory);
                                    Tile posisi5 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p5, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx, koory);
                                    Tile posisi6 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p6, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Squash":
                                    Squash p7 = new Squash(koorx, koory);
                                    Tile posisi7 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p7, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx, koory);
                                    Tile posisi8 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p8, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx, koory);
                                    Tile posisi9 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p9, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx, koory);
                                    Tile posisi10 = peta.getTile(koorx, koory);
                                    try {
                                        peta.plant(p10, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                            }
                            waitingForInput.set(false);
                            break;
                        default:
                            System.out.println("Tanaman tidak valid. Silakan pilih tanaman yang sesuai.");
                            waitingForInput.set(false);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.printf("Pilih baris untuk tanaman yang ingin dihapus (x) : ");
                    int koorxdel = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.printf("Pilih baris untuk tanaman yang ingin dihapus (y) : ");
                    int koorydel = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    System.out.println("");
                    System.out.println("Hapus tanaman ");
                    Tile hapustile = peta.getTile(koorxdel, koorydel);
                    hapustile.removeAllCreatures();
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
}
