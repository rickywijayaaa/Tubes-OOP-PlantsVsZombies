package Zombies;
import Plant.*;
import Creature.*;


public class ConeheadZombie extends Zombie {
    public ConeheadZombie(int x, int y) {
        super("Conehead Zombie", 250, 100, 1, false,x,y,true, 0, 10);
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
        //System.out.println(this.getName() + " attacked " + pl.getName() + " reducing its health to " + pl.getHealth());
    }
}

