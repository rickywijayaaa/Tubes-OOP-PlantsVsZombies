

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

public class Game {


    public static void play(Inventory inven){
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

        // for (int row = 0; row < 6; row++) {

        //     for (int col = 10; col = 0; col--) {
        //     }
        // }

        while(isRunningGame){
            
            System.out.println("");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tanam tanaman");
            System.out.println("2. Menghapus tanaman dari peta");
            System.out.println("3. Lihat Peta");
            System.out.println("3. Coba Thread");
            System.out.printf("Masukkan input tindakan (1/2/3/4) : ");
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println("");
                    inven.displayDeck();
                    System.out.println("");
                    System.out.printf("Pilih tanaman untuk ditanam : ");
                    int choose4 = scanner.nextInt();
                    switch(choose4){
                        case 1:
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory = scanner.nextInt();
                            Plant plant1 = inven.getDeckInven().get(0);
                            String plantsatu = plant1.getName();
                            switch(plantsatu){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx,koory);
                                    Tile posisi1 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p1, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx,koory);
                                    Tile posisi2 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p2, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx,koory);
                                    Tile posisi3 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p3, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx,koory);
                                    Tile posisi4 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p4, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx,koory);
                                    Tile posisi5 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p5, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx,koory);
                                    Tile posisi6 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p6, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx,koory);
                                    Tile posisi7 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p7, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx,koory);
                                    Tile posisi8 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p8, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx,koory);
                                    Tile posisi9 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p9, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx,koory);
                                    Tile posisi10 = peta.getTile(koorx,koory);
                                    try {
                                        peta.plant(p10, koorx, koory);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
                            break;
                        case 2 : 
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx2 = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory2 = scanner.nextInt();
                            Plant plant2 = inven.getDeckInven().get(1);
                            String plantdua = plant2.getName();
                            switch(plantdua){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx2,koory2);
                                    Tile posisi1 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p1, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx2,koory2);
                                    Tile posisi2 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p2, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx2,koory2);
                                    Tile posisi3 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p3, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx2,koory2);
                                    Tile posisi4 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p4, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx2,koory2);
                                    Tile posisi5 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p5, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx2,koory2);
                                    Tile posisi6 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p6, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx2,koory2);
                                    Tile posisi7 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p7, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx2,koory2);
                                    Tile posisi8 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p8, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx2,koory2);
                                    Tile posisi9 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p9, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx2,koory2);
                                    Tile posisi10 = peta.getTile(koorx2,koory2);
                                    try {
                                        peta.plant(p10, koorx2, koory2);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
                            break;
                        case 3 : 
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx3 = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory3 = scanner.nextInt();
                            Plant plant3 = inven.getDeckInven().get(2);
                            String planttiga = plant3.getName();
                            switch(planttiga){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx3,koory3);
                                    Tile posisi1 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p1, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx3,koory3);
                                    Tile posisi2 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p2, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx3,koory3);
                                    Tile posisi3 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p3, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx3,koory3);
                                    Tile posisi4 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p4, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx3,koory3);
                                    Tile posisi5 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p5, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx3,koory3);
                                    Tile posisi6 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p6, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx3,koory3);
                                    Tile posisi7 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p7, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx3,koory3);
                                    Tile posisi8 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p8, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx3,koory3);
                                    Tile posisi9 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p9, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx3,koory3);
                                    Tile posisi10 = peta.getTile(koorx3,koory3);
                                    try {
                                        peta.plant(p10, koorx3, koory3);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
                            break;
                        case 4 : 
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx4 = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory4 = scanner.nextInt();
                            Plant plant4 = inven.getDeckInven().get(3);
                            String plantempat = plant4.getName();
                            switch(plantempat){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx4,koory4);
                                    Tile posisi1 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p1, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx4,koory4);
                                    Tile posisi2 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p2, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx4,koory4);
                                    Tile posisi3 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p3, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx4,koory4);
                                    Tile posisi4 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p4, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx4,koory4);
                                    Tile posisi5 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p5, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx4,koory4);
                                    Tile posisi6 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p6, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx4,koory4);
                                    Tile posisi7 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p7, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx4,koory4);
                                    Tile posisi8 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p8, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx4,koory4);
                                    Tile posisi9 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p9, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx4,koory4);
                                    Tile posisi10 = peta.getTile(koorx4,koory4);
                                    try {
                                        peta.plant(p10, koorx4, koory4);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
                            break;
                        case 5 : 
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx5 = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory5 = scanner.nextInt();
                            Plant plant5 = inven.getDeckInven().get(4);
                            String plantlima = plant5.getName();
                            switch(plantlima){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx5,koory5);
                                    Tile posisi1 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p1, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx5,koory5);
                                    Tile posisi2 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p2, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx5,koory5);
                                    Tile posisi3 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p3, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx5,koory5);
                                    Tile posisi4 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p4, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx5,koory5);
                                    Tile posisi5 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p5, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx5,koory5);
                                    Tile posisi6 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p6, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx5,koory5);
                                    Tile posisi7 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p7, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx5,koory5);
                                    Tile posisi8 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p8, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx5,koory5);
                                    Tile posisi9 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p9, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx5,koory5);
                                    Tile posisi10 = peta.getTile(koorx5,koory5);
                                    try {
                                        peta.plant(p10, koorx5, koory5);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
                            break;
                        case 6 : 
                            System.out.println("");
                            System.out.printf("Pilih baris untuk tanaman ditanam (x) : ");
                            int koorx6 = scanner.nextInt();
                            System.out.printf("Pilih kolom untuk tanaman ditanam (y) : ");
                            int koory6 = scanner.nextInt();
                            Plant plant6 = inven.getDeckInven().get(5);
                            String plantenam = plant6.getName();
                            switch(plantenam){
                                case "Sunflower":
                                    Sunflower p1 = new Sunflower(koorx6,koory6);
                                    Tile posisi1 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p1, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx6,koory6);
                                    Tile posisi2 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p2, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx6,koory6);
                                    Tile posisi3 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p3, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx6,koory6);
                                    Tile posisi4 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p4, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx6,koory6);
                                    Tile posisi5 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p5, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx6,koory6);
                                    Tile posisi6 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p6, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx6,koory6);
                                    Tile posisi7 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p7, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx6,koory6);
                                    Tile posisi8 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p8, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx6,koory6);
                                    Tile posisi9 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p9, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx6,koory6);
                                    Tile posisi10 = peta.getTile(koorx6,koory6);
                                    try {
                                        peta.plant(p10, koorx6, koory6);
                                    } catch (Exception e) {
                                        System.out.println(" Error: " + e.getMessage());
                                    }
                                    break;                    
                                
                            }
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
                    Tile hapustile = peta.getTile(koorxdel,koorydel);
                    hapustile.removeAllCreatures();
                    break;
                case 3 : 
                    peta.displayMap();
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
            }
        // System.out.println("detik awal game: " + seconds);
    
        // //nyoba thread
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        }
    }
}