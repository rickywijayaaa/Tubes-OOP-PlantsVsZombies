package app.src.main.java.Plant;
import app.src.main.java.Creature.*;
import app.src.main.java.Zombies.*;

public class SnowPea extends Plant {
    public SnowPea() {
<<<<<<< HEAD
        super("Snow Pea", 100, 25, 4, false, 175,-1, 10);
=======
        super("Snow Pea", 175, 100, 25, 4, -1, 10, false);
>>>>>>> d0a5937 (update blm bener)
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Snow Pea menyerang dengan menembakkan frozen peas ke zombies untuk memperlambat zombies
        zom.setHealth(getAttackDamage());
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
