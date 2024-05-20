package Zombies;
import Plant.*;
import Creature.*;

public class FootballZombie extends Zombie {
    public FootballZombie(int x, int y) {
        super("Football Zombie" ,300,100,7,false,x,y,true,0,2);
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

