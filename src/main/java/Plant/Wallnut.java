package Plant;
import Creature.*;
import Zombies.*;

public class Wallnut extends Plant {
    public Wallnut(int x, int y) {
        super("Wallnut", 1000, 0, 0, false,x,y, 50, 0, 20);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Wall-nut tidak memiliki attack action karena merupakan defensive plant
        System.out.println(getName() + " can't attack");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Wall-nut tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Wall-nut tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

