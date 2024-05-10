package Plant;
import Creature.*;
import Zombies.*;

public class TangleKelp extends Plant {
    public TangleKelp(int x, int y) {
        super("Tangle Kelp", 100, 5000, 0,true,x,y,25, 1, 5);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Tangle Kelp menyerang dengan entangling dan eliminating satu aquatic zombie
        System.out.println(getName() + " entangles and eliminates a single aquatic zombie!");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Tangle Kelp tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Tangle Kelp tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

