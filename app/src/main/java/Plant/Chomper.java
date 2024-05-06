package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Chomper extends Plant {
    public Chomper(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
        super("Chomper", 150, 300, 100, 2, 1, 10, false);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Chomper menyerang dengan memakan zombies
        System.out.println(getName() + " nyam! chomps down on zombies!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Chomper tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Chomper tidak cooldowns, jadi method tidak melakukan apapun
    }
}

