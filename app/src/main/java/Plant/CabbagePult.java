package app.src.main.java.Plant;
import app.src.main.jav!a.Creature.*;

public class CabbagePult extends Plant {
    public CabbagePult() {
        super("Cabbage Pult", 100, 100, 20, 1.5, 3, 5, false);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Cabbage Pult menyerang dengan memakan zombies
        System.out.println(getName() + " chomps down on zombies! nyam!");
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

