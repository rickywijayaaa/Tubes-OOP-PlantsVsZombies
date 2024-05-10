/*
 * This source file was generated by the Gradle 'init' task
 */
// package app.src.main.java;

import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;

import java.util.concurrent.*;


public class App {
    public static void main(String[] args) {
        NormalZombie zom1 = new NormalZombie(1,1);
        ConeheadZombie zom2 = new ConeheadZombie(1,2);
        PoleVaultingZombie zom3 = new PoleVaultingZombie(1,1);
        BucketheadZombie zom4 = new BucketheadZombie(1,1);
        DuckyTubeZombie zom5 = new DuckyTubeZombie(1,1);
        DolphinRiderZombie zom6 = new DolphinRiderZombie(1,1);
        SnorkelZombie zom7 = new SnorkelZombie(1,1);
        FlagZombie zom8 = new FlagZombie(1,1);
        ScreendoorZombie zom9 = new ScreendoorZombie(1,1);
        FootballZombie zom10 = new FootballZombie(1,1);
        zom1.displayZombie();
        zom2.displayZombie();
        zom3.displayZombie();
        zom4.displayZombie();
        zom5.displayZombie();
        zom6.displayZombie();
        zom7.displayZombie();
        zom8.displayZombie();
        zom9.displayZombie();
        zom10.displayZombie();
        System.out.println(" ");
        Sunflower pl1 = new Sunflower(1,1);
        Peashooter pl2 = new Peashooter(1,1);
        Wallnut pl3 = new Wallnut(1,1);
        SnowPea pl4 = new SnowPea(1,1);
        Squash pl5 = new Squash(1,1);
        Lilypad pl6 = new Lilypad(1,1);
        CherryBomb pl7 = new CherryBomb(1,1);
        Repeater pl8 = new Repeater(1,1);
        CabbagePult pl9 = new CabbagePult(1,1);
        TangleKelp pl10 = new TangleKelp(1,1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pl1.displayPlant();
        pl2.displayPlant();
        pl3.displayPlant();
        pl4.displayPlant();
        pl5.displayPlant();
        pl6.displayPlant();
        pl7.displayPlant();
        pl8.displayPlant();
        pl9.displayPlant();
        pl10.displayPlant();

        zom7.attack(pl3);
        pl3.displayPlant();

        pl2.attack(zom9);
        zom9.displayZombie();


        Peta peta = new Peta();
    

        Tile koor11 = peta.getTile(zom1.getKoordinat().getX(), zom1.getKoordinat().getY());
        Tile koor17 = peta.getTile(1, 2);

        peta.displayMap();

        // Menambahkan entitas ke GameMap pada posisi yang benar
        koor11.addCreature(pl10); // Tambah Sunflower ke Lawn
        koor17.addCreature(pl2); // Tambah Zombie ke ZombieSpaw
        koor11.addCreature(pl3);

        // Menampilkan GameMap
        System.out.println("GameMap after adding entities:");
        peta.displayMap(); // Menampilkan representasi GameMap

        System.out.println("GameMap after remove entities:");
        koor11.removeCreature(pl10);
        peta.displayMap();
        Sun.getInstance();
        Sun.setSun(25);

        System.out.println("jumlah matahari : "+ Sun.getSun());
        // matahari.SunGenerate();
        // System.out.println("Total Sun: " + matahari.getSun());
        //coba desktop
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        System.out.println("detik : " + seconds);
        System.out.println("detik zombie : " + zom1.getStartTime());

        System.out.println("Lokasi zom1 : ");
        zom1.displayCreaturekoor();
        System.out.println("Lokasi zom2 : ");
        zom2.displayCreaturekoor();
        
    }
}
