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
        int nextCol = koory - 1;

        if((this.getSpeed())== 0){
            // Check if the next tile is within the bounds of the game map
            if (nextCol > 0) {
                Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
                Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile

                // Remove the zombie from the current tile
                // masalah kalau satu tile ada 2 jenis zombie
                nextTile.addCreature(this);
                tile.removeCreature(this);
                this.setKoordinat(koorx,nextCol);
                this.setSpeed(5);
            } else if (nextCol == 0 ) {
                Tile tile = gameMap.getTile(koorx,koory); // Get the current tile
                Tile nextTile = gameMap.getTile(koorx,nextCol); // Get the next tile

                // Remove the zombie from the current tile
                nextTile.addCreature(this);
                tile.removeCreature(this);
                this.setKoordinat(koorx,nextCol);
                this.setSpeed(5);
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

    // the object advance in the game map from right to left

    // public void special(GameMap gameMap) {
    //     Koordinat koorZ = getKoordinat(); // Get zombie's current position
    //     int koorx = koorZ.getX();
    //     int koory = koorZ.getY();

    //     ArrayList<Creature> entity = tile.getCreature();

    //     for (Creature creature : create) {
    //         if (creature instanceof Plant) {
    //             Plant plant = (Plant) creature;
    //             plant.die(gameMap); // ? Kalo special ketemu plant, langsung dilompatin trus plantny mati
    //             setSpecial(false);; // ? special nya ilang
    //         }
    //     }
    // }
}



