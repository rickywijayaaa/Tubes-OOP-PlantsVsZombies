package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;

public abstract class Zombie extends Creature {
    private double slowed;
    private double speed;

    public Zombie(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic,int x , int y, double slowed, double speed) {
        super(name, health, attackDamage, attackSpeed, isAquatic,x,y);
        this.slowed = slowed;
        this.speed = speed;
    }

    // Getter methods 
    public double getSlowed() {
        return slowed;
    }

    public double getSpeed() {
        return speed;
    }


    
    public void setSpeed(double newspeed){
        speed = newspeed;
    }

    public void setSlowed(double newslow){
        slowed = newslow;
    }

    public void displayZombie(){
        System.out.println("nama: " + getName() + " memiliki health : " + getHealth() + " attack damage : " + getAttackDamage() + " attack speed : " + getAttackSpeed());
    }
    
    // Abstract method attack plant
    public abstract void attack(Plant pl);

    @Override
    public void resetCooldown(){
        // Implementing the resetCooldown from creature
        System.out.println(getName() + " attacks with " + getAttackDamage() + " damage!");
    }

    @Override
    public void move() {
        // Implementing the movement behavior from creature
        System.out.println(getName() + " moves slowly with speed " + getSpeed());
    }
    //the object decrease plant health in the same tile based on its atkdmg
    public void walk(Peta gameMap) {
        Koordinat koorZ = getKoordinat(); // Get zombie's current position
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        // int row = position[0];
        // int col = position[1];
        // Calculate the position of the next tile (moving left)
        int nextCol = koory - 1;

        // Check if the next tile is within the bounds of the game map
        if (nextCol > 0) {
            Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
            Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile

            // Remove the zombie from the current tile
            tile.removeCreature(this);
            nextTile.addCreature(this);
        } else if (nextCol == 0 ) {
            Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
            Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile

            // Remove the zombie from the current tile
            tile.removeCreature(this);
            nextTile.addCreature(this);
            // game end
        }    
        else{ 
            // Zombie has reached the end of the map, you may want to handle this case
            // For example, remove the zombie from the game or trigger a game over condition
        }
    }

    // the object advance in the game map from right to left

    // public void special(GameMap gameMap) {
    //     int[] position = getPosition(); // ? Buat posisi zombie
    //     Tile tile = gameMap.getTile(position[0], position[1]); // ? Buat Nentuin tile zombienya

    //     ArrayList<Entities> entity = tile.getEntities();

    //     for (Entities entities : entity) {
    //         if (entities instanceof Plant) {
    //             Plant plant = (Plant) entities;
    //             plant.die(gameMap); // ? Kalo special ketemu plant, langsung dilompatin trus plantny mati
    //             setSpecial(false);; // ? special nya ilang
    //         }
    //     }
    // }
}



