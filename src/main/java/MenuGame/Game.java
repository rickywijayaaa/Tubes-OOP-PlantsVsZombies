

package MenuGame;

import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;

import java.util.concurrent.*;
import java.util.Scanner;

public class Game {
    public static void play(Inventory inven){
        Scanner scanner = new Scanner(System.in);
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        boolean isRunningGame = true;
        Peta peta = new Peta();
        System.out.println("");
        System.out.println("Deck tanaman yang dapat kamu gunakan");
        System.out.println("");
        inven.displayDeck();

        while(isRunningGame){
            
            System.out.println("");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Tanam tanaman");
            System.out.println("2. Menghapus tanaman dari peta");
            System.out.println("3. Lihat Peta");
            System.out.printf("Masukkan input tindakan (1/2/3) : ");
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx,koory);
                                    Tile posisi2 = peta.getTile(koorx,koory);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx,koory);
                                    Tile posisi3 = peta.getTile(koorx,koory);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx,koory);
                                    Tile posisi4 = peta.getTile(koorx,koory);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx,koory);
                                    Tile posisi5 = peta.getTile(koorx,koory);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx,koory);
                                    Tile posisi6 = peta.getTile(koorx,koory);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx,koory);
                                    Tile posisi7 = peta.getTile(koorx,koory);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx,koory);
                                    Tile posisi8 = peta.getTile(koorx,koory);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx,koory);
                                    Tile posisi9 = peta.getTile(koorx,koory);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx,koory);
                                    Tile posisi10 = peta.getTile(koorx,koory);
                                    posisi10.addCreature(p10);
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx2,koory2);
                                    Tile posisi2 = peta.getTile(koorx2,koory2);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx2,koory2);
                                    Tile posisi3 = peta.getTile(koorx2,koory2);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx2,koory2);
                                    Tile posisi4 = peta.getTile(koorx2,koory2);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx2,koory2);
                                    Tile posisi5 = peta.getTile(koorx2,koory2);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx2,koory2);
                                    Tile posisi6 = peta.getTile(koorx2,koory2);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx2,koory2);
                                    Tile posisi7 = peta.getTile(koorx2,koory2);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx2,koory2);
                                    Tile posisi8 = peta.getTile(koorx2,koory2);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx2,koory2);
                                    Tile posisi9 = peta.getTile(koorx2,koory2);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx2,koory2);
                                    Tile posisi10 = peta.getTile(koorx2,koory2);
                                    posisi10.addCreature(p10);
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx3,koory3);
                                    Tile posisi2 = peta.getTile(koorx3,koory3);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx3,koory3);
                                    Tile posisi3 = peta.getTile(koorx3,koory3);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx3,koory3);
                                    Tile posisi4 = peta.getTile(koorx3,koory3);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx3,koory3);
                                    Tile posisi5 = peta.getTile(koorx3,koory3);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx3,koory3);
                                    Tile posisi6 = peta.getTile(koorx3,koory3);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx3,koory3);
                                    Tile posisi7 = peta.getTile(koorx3,koory3);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx3,koory3);
                                    Tile posisi8 = peta.getTile(koorx3,koory3);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx3,koory3);
                                    Tile posisi9 = peta.getTile(koorx3,koory3);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx3,koory3);
                                    Tile posisi10 = peta.getTile(koorx3,koory3);
                                    posisi10.addCreature(p10);
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx4,koory4);
                                    Tile posisi2 = peta.getTile(koorx4,koory4);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx4,koory4);
                                    Tile posisi3 = peta.getTile(koorx4,koory4);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx4,koory4);
                                    Tile posisi4 = peta.getTile(koorx4,koory4);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx4,koory4);
                                    Tile posisi5 = peta.getTile(koorx4,koory4);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx4,koory4);
                                    Tile posisi6 = peta.getTile(koorx4,koory4);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx4,koory4);
                                    Tile posisi7 = peta.getTile(koorx4,koory4);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx4,koory4);
                                    Tile posisi8 = peta.getTile(koorx4,koory4);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx4,koory4);
                                    Tile posisi9 = peta.getTile(koorx4,koory4);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx4,koory4);
                                    Tile posisi10 = peta.getTile(koorx4,koory4);
                                    posisi10.addCreature(p10);
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx5,koory5);
                                    Tile posisi2 = peta.getTile(koorx5,koory5);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx5,koory5);
                                    Tile posisi3 = peta.getTile(koorx5,koory5);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx5,koory5);
                                    Tile posisi4 = peta.getTile(koorx5,koory5);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx5,koory5);
                                    Tile posisi5 = peta.getTile(koorx5,koory5);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx5,koory5);
                                    Tile posisi6 = peta.getTile(koorx5,koory5);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx5,koory5);
                                    Tile posisi7 = peta.getTile(koorx5,koory5);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx5,koory5);
                                    Tile posisi8 = peta.getTile(koorx5,koory5);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx5,koory5);
                                    Tile posisi9 = peta.getTile(koorx5,koory5);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx5,koory5);
                                    Tile posisi10 = peta.getTile(koorx5,koory5);
                                    posisi10.addCreature(p10);
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
                                    posisi1.addCreature(p1);
                                    break;
                                case "Repeater":
                                    Repeater p2 = new Repeater(koorx6,koory6);
                                    Tile posisi2 = peta.getTile(koorx6,koory6);
                                    posisi2.addCreature(p2);
                                    break;
                                case "Snow Pea":
                                    SnowPea p3 = new SnowPea(koorx6,koory6);
                                    Tile posisi3 = peta.getTile(koorx6,koory6);
                                    posisi3.addCreature(p3);
                                    break;
                                case "Lilypad":
                                    Lilypad p4 = new Lilypad(koorx6,koory6);
                                    Tile posisi4 = peta.getTile(koorx6,koory6);
                                    posisi4.addCreature(p4);
                                    break;    
                                case "Wallnut":
                                    Wallnut p5 = new Wallnut(koorx6,koory6);
                                    Tile posisi5 = peta.getTile(koorx6,koory6);
                                    posisi5.addCreature(p5);
                                    break; 
                                case "Peashooter":
                                    Peashooter p6 = new Peashooter(koorx6,koory6);
                                    Tile posisi6 = peta.getTile(koorx6,koory6);
                                    posisi6.addCreature(p6);
                                    break;    
                                case "Squash":
                                    Squash p7 = new Squash(koorx6,koory6);
                                    Tile posisi7 = peta.getTile(koorx6,koory6);
                                    posisi7.addCreature(p7);
                                    break; 
                                case "Cherry Bomb":
                                    CherryBomb p8 = new CherryBomb(koorx6,koory6);
                                    Tile posisi8 = peta.getTile(koorx6,koory6);
                                    posisi8.addCreature(p8);
                                    break;
                                case "Cabbage Pult":
                                    CabbagePult p9 = new CabbagePult(koorx6,koory6);
                                    Tile posisi9 = peta.getTile(koorx6,koory6);
                                    posisi9.addCreature(p9);
                                    break;   
                                case "Tangle Kelp":
                                    TangleKelp p10 = new TangleKelp(koorx6,koory6);
                                    Tile posisi10 = peta.getTile(koorx6,koory6);
                                    posisi10.addCreature(p10);
                                    break;                    
                                
                            }
                            break;
                            
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Hapus tanaman ");
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