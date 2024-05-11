package app.src.main.java.Plant;
import app.src.main.java.Zombies.*;
import app.src.main.java.Creature.*;


public class Sunflower extends Plant {
    public Sunflower() {
        super("Sunflower", 100, 0, 0, false,50, 0, 10);
    }

    @Override
    public void resetCooldown() {
        // Implementasi resetCooldown dari Plant
        System.out.println("Reset cooldown for Sunflower");
    }

    @Override
    public void attack(Zombie zom){

    }

    public void act() {
        // Implementasi act untuk Sunflower
        System.out.println(getName() + " produces sun points.");
    }
}
