package app.src.main.java.Plant;

public class Peashooter extends Plant {
    public Peashooter() {
        super("Peashooter", 100, 25, 4, false, 100, -1, 10);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Implementing attack behavior untuk Peashooter
        System.out.println(getName() + " shoots peas with " + getAttackDamage() + " damage!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Peashooter tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Peashooter tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

