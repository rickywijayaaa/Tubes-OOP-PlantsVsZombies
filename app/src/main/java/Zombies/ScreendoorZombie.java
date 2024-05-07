package app.src.main.java.Zombies;

import app.src.main.java.Creature.*;
import app.src.main.java.Plant.*;


public class ScreendoorZombie extends Zombie {
    public ScreendoorZombie() {
        super("Screendoor Zombie",500,75,1,false,0,1);
    }



    // Implementasi abstract method 
    @Override
    public void resetCooldown(){
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

