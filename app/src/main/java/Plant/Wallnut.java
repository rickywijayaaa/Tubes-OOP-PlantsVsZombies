package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Wallnut extends Plant {
    public Wallnut(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
        super("Wallnut", 50, 1000, 0, 0, 0, 20, false);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Wall-nut tidak memiliki attack action karena merupakan defensive plant
        System.out.println(getName() + " is a defensive plant and doesn't attack!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Wall-nut tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Wall-nut tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

