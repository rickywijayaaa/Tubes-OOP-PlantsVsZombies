package Plant;
import Creature.*;
import Zombies.*;

public class Repeater extends Plant {
    public Repeater(int x, int y) {
        super("Repeater", 300, 20, 1.5,false,x,y,200, 3, 0.5);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Repeater menyerang shooting more peas ke zombies
        zom.setHealth(getAttackDamage());
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Repeatertidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Repeater tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
