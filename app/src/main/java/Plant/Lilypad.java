package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Lilypad extends Plant {
    public Lilypad(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Lilypad tidak memiliki attack karena merupakan support plant
        System.out.println(getName() + " is a support plant and doesn't attack! <3");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Lilypad tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Lilypad tidak memiliki cooldowns, jadi method tidak melakukan apapun
        // coba
    }
}
