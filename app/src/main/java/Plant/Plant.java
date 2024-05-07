package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public abstract class Plant extends Creature {
    private int cost;
    private int range;
    private double cooldown;

    public Plant(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
        super(name, cost, health, attackDamage, attackSpeed, range, cooldown, isAquatic);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
    }

    // Getter methods untuk atribut tambahan
    public int getCost() {
        return cost;
    }

    public int getRange() {
        return range;
    }

    public double getCooldown() {
        return cooldown;
    }

    // Abstract method attack zombie
    public abstract void attack();

    
    // Implementing abstract methods dari Creature class
    @Override
    public void resetCooldown() {
        // Implementing attack behavior untuk Plant
        // Methodnya akan beragam sesuai dengan Plant
    }

    @Override
    public void move() {
        // Implementing move behavior untuk Plant
        // Plants biasanya tidak melakukan "move"
    }

    public void displayPlant(){
        System.out.println("nama: " + getName() + " memiliki cost : " + getCost() + " memiliki health : " + getHealth() + " attack damage : " + getAttackDamage() + " attack speed : " + getAttackSpeed() + " range : " + getRange() + " cooldown : " + getCooldown());
    }
}

