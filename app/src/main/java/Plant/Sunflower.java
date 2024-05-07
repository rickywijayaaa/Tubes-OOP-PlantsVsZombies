package app.src.main.java.Plants;

public class Sunflower extends Plant {
    public Sunflower(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
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
