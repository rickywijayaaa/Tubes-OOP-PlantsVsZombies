package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Squash extends Plant {
    public Squash(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Squash menyerang dengan squashing zombies di lane-nya
        System.out.println(getName() + " squashes zombies in its lane! *nyek*");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Squash tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Squash tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
