package Plant;
import Creature.*;
import Zombies.*;
import Sun.*;
import MapGame.*;
import Koordinat.*;


public class Sunflower extends Plant {
    public Sunflower(int x, int y) {
        super("Sunflower", 100, 0, 0, false,x,y,true,50, 0, 3);
    }


    // @Override
    // public void attack(Zombie zom,Peta peta){

    // }

    public void act() {
        if(getCooldown()== 0){
            Sun.addSun();
            resetCooldown(3);
            // Implementasi act untuk Sunflower
            System.out.println(getName() + " produces sun points.");
        }
        else{
            resetCooldown(getCooldown()-1);
        }

    }
}
