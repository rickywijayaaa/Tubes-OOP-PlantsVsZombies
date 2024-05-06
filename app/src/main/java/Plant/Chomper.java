package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Chomper extends Plant {
    public Chomper(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
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

