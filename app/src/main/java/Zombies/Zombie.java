package app.src.main.java.Zombies;
import app.src.main.java.Creature.*;

public abstract class Zombie extends Creature {
    private double slowed;
    private double speed;

    public Zombie(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, double slowed, double speed) {
        super(name, health, attackDamage, attackSpeed, isAquatic);
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

    public void setAquatics(boolean air){
        
    }
    
    // Abstract method attack plant
    public abstract void attack();

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
}
