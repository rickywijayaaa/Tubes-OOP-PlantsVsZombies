package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Wallnut extends Plant {
    public Wallnut(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
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
