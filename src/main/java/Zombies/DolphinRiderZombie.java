package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;


public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie(int x, int y) {
        super("Dolphin Rider Zombie", 175, 100, 1, true,x,y,true, 0, 5);
    }



    // Implementasi abstract method 
    @Override
    public void resetCooldown(double newcooldown){
        // Implementasi resetCooldown dari Creature
        System.out.println("nanti dioveerride");
    }

    // Implementasi abstract method 
    @Override
    public void move() {
        // Implementasi move untuk zombie
        System.out.println(getName() + " moves slowly with speed " + getSpeed());
    }

    @Override
    public void attack(Plant pl) {
        // Implementasi attack untuk zombie
        pl.setHealth(pl.getHealth() - this.getAttackDamage());
        System.out.println(this.getName() + " attacked " + pl.getName() + " reducing its health to " + pl.getHealth());
    }

    // fungsi
    public void jump(Peta gameMap){
        Koordinat koorZ = getKoordinat();
        // Posisi zombie sekarang
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        int nextCol = koory - 2;
        int loncat = koory - 1;

        // Check apakah tile sudah lewat
        if (nextCol > 0) {
            Tile tile = gameMap.getTile(koorx,koory); // Get tile sekarang
            Tile nextTile = gameMap.getTile(koorx,nextCol); // Loncat ke 2 tile setelahnya
            Tile matiTile = gameMap.getTile(koorx,loncat); // Tile yang dilompati


            // Remove the zombie from the current tile
            tile.removeCreature(this); //menghapus posisi sekarang
            nextTile.addCreature(this); // pindah ke tile 2 berikutnya
            matiTile.removeAllCreatures(); // membunuh semua creature yang dilompati
            


        } else if (nextCol == 0 ) {
            Tile tile = gameMap.getTile(koorx,koory); // Get tile sekarang
            Tile nextTile = gameMap.getTile(koorx,nextCol); // Loncat ke 2 tile setelahnya
            Tile matiTile = gameMap.getTile(koorx,loncat); // Tile yang dilompati


            // Remove the zombie from the current tile
            tile.removeCreature(this); //menghapus posisi sekarang
            nextTile.addCreature(this); // pindah ke tile 2 berikutnya
            matiTile.removeAllCreatures(); // membunuh semua creature yang dilompati
            // game end
        }    
        else{ 
            // Zombie has reached the end of the map, you may want to handle this case
            // For example, remove the zombie from the game or trigger a game over condition
        }

    }
}

