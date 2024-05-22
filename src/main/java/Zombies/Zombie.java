package Zombies;
import Plant.*;
import Creature.*;
import MapGame.*;
import Koordinat.*;

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


    //the object decrease plant health in the same tile based on its atkdmg
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



