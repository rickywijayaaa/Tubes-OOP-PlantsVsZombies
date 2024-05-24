package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;


public class FootballZombie extends Zombie {
    public FootballZombie(int x, int y) {
        super("Football Zombie" ,300,100,7,false,x,y,true,0,3);
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
    }

    @Override
    public void walk(Peta gameMap) {
        Koordinat koorZ = getKoordinat(); // Get zombie's current position
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        int nextCol = koory - 1;
        if (nextCol >= 0){
            // Check for plants in the next tile
            Tile checktanaman = gameMap.getTile(koorx,nextCol);
            // fungsi attack tanaman
            if(checktanaman.hasPlanted()){
                for (Creature creature : checktanaman.getEntities()) {
                    if (creature instanceof Plant) {
                        if(creature instanceof Squash){
                            return;
                        }
                        else{
                            this.attack((Plant) creature); // Attack the plant
                            return; // Stop walking since the zombie attacks
                        }
                    }
                }
            }
            else{
                if((this.getSpeed())== 0 ){
                    // Check if the next tile is within the bounds of the game map
                    if (nextCol > 0) {
                        Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
                        Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile
        
                        // Remove the zombie from the current tile
                        // masalah kalau satu tile ada 2 jenis zombie
                        nextTile.addCreature(this);
                        tile.removeCreature(this);
                        this.setKoordinat(koorx,nextCol);
                        this.setSpeed(2);
                    } else if (nextCol == 0 ) {
                        Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
                        Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile
        
                        // Remove the zombie from the current tile
                        nextTile.addCreature(this);
                        tile.removeCreature(this);
                        this.setKoordinat(koorx,nextCol);
                        this.setSpeed(2);
                        // game end
                    }    
                    else{ 
                        // Zombie has reached the end of the map, you may want to handle this case
                        // For example, remove the zombie from the game or trigger a game over condition
                    }            
                }
                else{
                    this.setSpeed(this.getSpeed()-1);
                }
            }
        }
    }
}

