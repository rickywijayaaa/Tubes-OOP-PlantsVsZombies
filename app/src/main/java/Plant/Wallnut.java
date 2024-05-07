package app.src.main.java.Plant;

public class Wallnut extends Plant {
    public Wallnut() {
        super("Wallnut", 1000, 0, 0, false, 50, 0, 20);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Wall-nut tidak memiliki attack action karena merupakan defensive plant
        System.out.println(getName() + " is a defensive plant and doesn't attack!");
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

