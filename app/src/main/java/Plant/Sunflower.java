package app.src.main.java.Plants;

public class Sunflower extends Plant {
    public Sunflower() {
        super("Sunflower", 50, 100, 0, 0, 0, 10, false);
    }

    @Override
    public void resetCooldown() {
        // Implementasi resetCooldown dari Plant
        System.out.println("Reset cooldown for Sunflower");
    }

    @Override
    public void act() {
        // Implementasi act untuk Sunflower
        System.out.println(getName() + " produces sun points.");
    }
}
