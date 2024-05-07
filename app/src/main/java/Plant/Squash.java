package app.src.main.java.Plant;

public class Squash extends Plant {
    public Squash() {
        super("Squash", 100, 5000, 0, false,50,1, 20);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Squash menyerang dengan squashing zombies di lane-nya
        System.out.println(getName() + " squashes zombies in its lane! *nyek*");
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
