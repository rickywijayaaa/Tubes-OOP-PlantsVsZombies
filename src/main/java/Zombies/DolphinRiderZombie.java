package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;


public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie(int x, int y) {
        super("Dolphin Rider Zombie", 175, 100, 1, true,x,y,true, 0, 10);
    }

    private boolean jump = false;

    public boolean isJump(){
        return jump;
    }

    public void setJump(){
        jump = true;
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
        pl.setHealth(getAttackDamage());
        //System.out.println(this.getName() + " attacked " + pl.getName() + " reducing its health to " + pl.getHealth());
    }

    // fungsi

    public void jump(Peta gameMap) {
        Koordinat koorZ = getKoordinat();
        // Posisi zombie sekarang
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        int nextCol = koory - 2;
    
        // Check apakah tile sudah lewat
        if (nextCol >= 0) {
            Tile tile = gameMap.getTile(koorx, koory); // Get tile sekarang
            Tile nextTile = gameMap.getTile(koorx, nextCol); // Loncat ke 2 tile setelahnya
    
            // Remove the zombie from the current tile
            tile.removeCreature(this); // Menghapus posisi sekarang
    
            // Remove only Plant creatures from the next tile
            nextTile.getEntities().removeIf(creature -> creature instanceof Plant || creature instanceof Lilypad);
    
            nextTile.addCreature(this); // Pindah ke tile 2 berikutnya
            this.setKoordinat(koorx, nextCol);
        } else if (nextCol == 0) {
            Tile tile = gameMap.getTile(koorx, koory); // Get tile sekarang
            Tile nextTile = gameMap.getTile(koorx, nextCol); // Loncat ke 2 tile setelahnya
    
            // Remove the zombie from the current tile
            tile.removeCreature(this); // Menghapus posisi sekarang
    
            // Remove only Plant creatures from the next tile
            nextTile.getEntities().removeIf(creature -> creature instanceof Plant || creature instanceof Lilypad);
    
            nextTile.addCreature(this); // Pindah ke tile 2 berikutnya
            this.setKoordinat(koorx, nextCol);
            // Handle game end condition here if needed
        } else {
            // Zombie has reached the end of the map
            // Handle this case (e.g., remove the zombie or trigger game over)
        }
    }
}

