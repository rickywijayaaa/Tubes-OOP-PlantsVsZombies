package Plant;
import Creature.*;
import Zombies.*;

public class Peashooter extends Plant {
    public Peashooter(int x, int y) {
        super("Peashooter", 100, 25, 4, false, x,y,100, -1, 10);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Implementing attack behavior untuk Peashooter
        zom.setHealth(getAttackDamage());
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

