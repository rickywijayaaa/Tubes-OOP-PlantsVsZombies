package Plant;
import Creature.*;
import Zombies.*;

public class Lilypad extends Plant {
    public Lilypad(int x, int y) {
        super("Lilypad", 100, 0, 0, true,x,y,25,0, 10);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Lilypad tidak memiliki attack karena merupakan support plant
        System.out.println("Lilypad can't attack");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Lilypad tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Lilypad tidak memiliki cooldowns, jadi method tidak melakukan apapun
        // coba
    }
}
