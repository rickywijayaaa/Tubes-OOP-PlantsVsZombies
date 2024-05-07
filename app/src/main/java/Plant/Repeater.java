package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class Repeater extends Plant {
    public Repeater() {
        super("Repeater", 300, 20, 1.5,false,200, 3, 0.5);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Repeater menyerang shooting more peas ke zombies
        System.out.println(getName() + " shoots more peas at zombies!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Repeatertidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Repeater tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
