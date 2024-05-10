package Plant;
import Creature.*;
import Zombies.*;

public class CherryBomb extends Plant {
    public CherryBomb() {
        super("Cherry Bomb", 150, 1000,0, false,150, 3, 30);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Cherry Bomb meledak, membunuh zombie di sekitarnya
        System.out.println(getName() + " explodes, damaging nearby zombies! DUARRR");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cherry Bomb tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Cherry Bomb tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

