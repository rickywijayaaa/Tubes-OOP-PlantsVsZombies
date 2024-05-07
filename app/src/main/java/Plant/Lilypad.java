package app.src.main.java.Plant;

public class Lilypad extends Plant {
    public Lilypad() {
        super("Lilypad", 100, 0, 0, true,25,0, 10);
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
