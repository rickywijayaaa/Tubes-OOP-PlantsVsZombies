package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class TangleKelp extends Plant {
    public TangleKelp(int x, int y) {
        super("Tangle Kelp", 100, 5000, 0,true,x,y,true,25, 1, 5);
    }

    // Implementing abstract method dari Plant class
    // @Override
    // public void attack(Zombie zom,Peta peta) {
    //     // Tangle Kelp menyerang dengan entangling dan eliminating satu aquatic zombie
    //     System.out.println(getName() + " entangles and eliminates a single aquatic zombie!");
    // }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Tangle Kelp tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Tangle Kelp tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

