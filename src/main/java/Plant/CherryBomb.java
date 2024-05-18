package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class CherryBomb extends Plant {
    public CherryBomb(int x, int y) {
        super("Cherry Bomb", 150, 1000,0, false,x , y,true,150, 3, 30);
    }

    // Implementing abstract method dari Plant class
    // @Override
    // public void attack(Zombie zom,Peta peta) {
    //     // Cherry Bomb meledak, membunuh zombie di sekitarnya
    //     System.out.println(getName() + " explodes, damaging nearby zombies! DUARRR!!");
    // }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cherry Bomb tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Cherry Bomb tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

