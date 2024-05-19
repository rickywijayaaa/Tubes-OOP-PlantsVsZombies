package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class Squash extends Plant {
    public Squash(int x, int y) {
        super("Squash", 100, 5000, 0, false,x,y,true,50,1, 20);
    }

    // Implementing abstract method dari Plant class
    // @Override
    // public void attack(Zombie zom,Peta peta) {
    //     // Implementing attack behavior untuk Peashooter
    //     if(zom.getIsAlive()){
    //         zom.setHealth(getAttackDamage());
    //     }
    // }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Squash tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Squash tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
