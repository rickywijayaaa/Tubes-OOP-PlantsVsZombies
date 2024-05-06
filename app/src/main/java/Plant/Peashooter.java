package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Peashooter extends Plant {
    public Peashooter(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Implementing attack behavior untuk Peashooter
        System.out.println(getName() + " shoots peas with " + getAttackDamage() + " damage!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Peashooter tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Peashooter tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

