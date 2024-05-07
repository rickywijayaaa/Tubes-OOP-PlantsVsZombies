package app.src.main.java.Plant;
import app.src.main.java.Creature.*;
import app.src.main.java.Zombies.*;

public class CabbagePult extends Plant {
    public CabbagePult() {
        super("Cabbage Pult", 100, 20, 1.5,false,100, 3, 5);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Cabbage Pult menyerang dengan memakan zombies (langsung mati)
        zom.setHealth(zom.getHealth());
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cabbage Pult tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Cabbage Pult tidak cooldowns, jadi method tidak melakukan apapun
    }
}

