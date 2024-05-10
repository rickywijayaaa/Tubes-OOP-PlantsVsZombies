package Plant;
import Creature.*;
import Zombies.*;

public class SnowPea extends Plant {
    public SnowPea(int x, int y) {
        super("Snow Pea", 100, 25, 4, false, x,y,175,-1, 10);
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
