package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Peashooter extends Plant {
    public Peashooter(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
        super("Peashooter", 100, 100, 25, 4, -1, 10, false);
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

