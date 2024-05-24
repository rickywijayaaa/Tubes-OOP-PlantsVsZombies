package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Zombie extends Creature implements Cloneable{
    private double slowed;
    private double speed;
    private final double originalSpeed;
    private boolean isAttack;

    public Zombie(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic,int x , int y, boolean isAlive,double slowed, double speed) {
        super(name, health, attackDamage, attackSpeed, isAquatic,x,y,true);
        this.slowed = slowed;
        this.speed = speed;
        this.isAttack = false;
        this.originalSpeed = this.speed; //for snowpea freeze purposes
    }

    // Getter methods 
    public double getSlowed() {
        return slowed;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isAttack(){
        return isAttack;
    }

    public void setAttack(boolean attack){
        isAttack = attack;
    }
    
    public void setSpeed(double newspeed){
        speed = newspeed;
    }

    public void setSlowed(double newslow){
        slowed = newslow;
        this.speed = (this.originalSpeed - slowed);
    }

    public void displayZombie(){
        System.out.println("nama: " + getName() + " memiliki health : " + getHealth() + " attack damage : " + getAttackDamage() + " attack speed : " + getAttackSpeed());
    }

    public void attack(Plant pl){
        // Implementasi attack untuk zombie
        pl.setHealth(getAttackDamage());
    }
    

    @Override
    public void resetCooldown(double newcooldown){
        // Implementing the resetCooldown from creature
        System.out.println(getName() + " attacks with " + getAttackDamage() + " damage!");
    }

    @Override
    public void move() {
        // Implementing the movement behavior from creature
        System.out.println(getName() + " moves slowly with speed " + getSpeed());
    }

    public void walk(Peta gameMap) {
        Koordinat koorZ = getKoordinat(); // Get zombie's current position
        int koorx = koorZ.getX();
        int koory = koorZ.getY();

        // Check the current tile for any plants
        Tile currentTile = gameMap.getTile(koorx, koory);
        if (currentTile.hasPlanted()) {
            List<Creature> creaturesToAttack = new ArrayList<>();
            for (Creature creature : currentTile.getEntities()) {
                if (creature instanceof Plant) {
                    if (creature instanceof Squash || creature instanceof TangleKelp) {
                        return; // Do not attack these plants
                    } else {
                        creaturesToAttack.add(creature);
                    }
                }
            }

            // Attack plants on the current tile
            for (Creature creature : creaturesToAttack) {
                this.attack((Plant) creature);
                return;
            }
        } else {
            // Move to the next tile and check for plants
            int nextCol = koory - 1;
            if (nextCol >= 0) {
                Tile nextTile = gameMap.getTile(koorx, nextCol);
                if (nextTile.hasPlanted()) {
                    List<Creature> creaturesToAttack = new ArrayList<>();
                    for (Creature creature : nextTile.getEntities()) {
                        if (creature instanceof Plant) {
                            if (creature instanceof Squash || creature instanceof TangleKelp) {
                                return; // Do not attack these plants
                            } else {
                                creaturesToAttack.add(creature);
                            }
                        }
                    }

                    // Attack plants on the next tile
                    for (Creature creature : creaturesToAttack) {
                        this.attack((Plant) creature);
                        return;
                    }
                } else {
                    // Move to the next tile if no plants are found
                    if ((this.getSpeed()) == 0) {
                        if (nextCol > 0) {
                            Tile tile2 = gameMap.getTile(koorx, koory); // Get the current tile
                            Tile nextTile2 = gameMap.getTile(koorx, nextCol); // Get the next tile
                            nextTile2.addCreature(this);
                            tile2.removeCreature(this);
                            this.setKoordinat(koorx, nextCol);
                            this.setSpeed(10);
                        } else if (nextCol == 0) {
                            Tile tile2 = gameMap.getTile(koorx, koory); // Get the current tile
                            Tile nextTile2 = gameMap.getTile(koorx, nextCol); // Get the next tile
                            nextTile2.addCreature(this);
                            tile2.removeCreature(this);
                            this.setKoordinat(koorx, nextCol);
                            this.setSpeed(10);
                            // Handle game end condition here if needed
                        } else {
                            // Zombie has reached the end of the map
                            // Handle this case (e.g., remove the zombie or trigger game over)
                        }
                    } else {
                        this.setSpeed(this.getSpeed() - 1);
                    }
                }
            }
        }
    }

    // Implement clone method
    @Override
    public Zombie clone() {
        try {
            return (Zombie) super.clone();
                } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}



