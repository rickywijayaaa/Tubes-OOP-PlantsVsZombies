package app.src.main.java.Plant;
import app.src.main.java.Creature.*;
import app.src.main.java.Zombies.*;

public class Squash extends Plant {
    public Squash() {
<<<<<<< HEAD
        super("Squash", 100, 5000, 0, false,50,1, 20);
=======
        super("Squash", 50, 100, 5000, 0, 1, 20, false);
>>>>>>> d0a5937 (update blm bener)
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Squash menyerang dengan squashing zombies di lane-nya
        zom.setHealth(getAttackDamage());
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
