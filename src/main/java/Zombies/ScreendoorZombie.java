package Zombies;
import Plant.*;
import Creature.*;


public class ScreendoorZombie extends Zombie {
    public ScreendoorZombie(int x, int y) {
        super("Screendoor Zombie",500,75,1,false,x,y,true,0,10);
    }

    // Implementasi abstract method 
    @Override
    public void resetCooldown(double newcooldown){
        // Implementasi resetCooldown dari Creature
        System.out.println("nanti dioveerride");
    }

    // Implementasi abstract method 
    @Override
    public void move() {
        // Implementasi move untuk zombie
        System.out.println(getName() + " moves slowly with speed " + getSpeed());
    }

    @Override
    public void attack(Plant pl) {
        // Implementasi attack untuk zombie
        pl.setHealth(getAttackDamage());
    }
}

