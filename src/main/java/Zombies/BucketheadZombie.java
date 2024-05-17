package Zombies;
import Plant.*;
import Creature.*;


public class BucketheadZombie extends Zombie {
    public BucketheadZombie(int x, int y) {
        super("Buckethead Zombie", 300,100, 1, false,x,y, 0, 5);
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

