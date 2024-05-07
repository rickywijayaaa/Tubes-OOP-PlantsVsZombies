package app.src.main.java.Plant;

public class SnowPea extends Plant {
    public SnowPea() {
        super("Snow Pea", 100, 25, 4, false, 175,-1, 10);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Snow Pea menyerang dengan menembakkan frozen peas ke zombies untuk memperlambat zombies
        System.out.println(getName() + " shoots frozen peas at zombies, slowing them down!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Snow Pea tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Snow Pea tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
