package app.src.main.java.Plant;
import app.src.main.java.Creature.*;
import app.src.main.java.Zombies.*;

public class Wallnut extends Plant {
    public Wallnut() {
<<<<<<< HEAD
        super("Wallnut", 1000, 0, 0, false, 50, 0, 20);
=======
        super("Wallnut", 50, 1000, 0, 0, 0, 20, false);
>>>>>>> d0a5937 (update blm bener)
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Wall-nut tidak memiliki attack action karena merupakan defensive plant
        System.out.println(getName() + " can't attack");
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

