package app.src.main.java.Zombies;

import app.src.main.java.Creature.*;


public class SnorkelZombie extends Zombie {
    public SnorkelZombie() {
        super("Snorkel Zombie",200,150,1,true,0,1);
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
    public void attack() {
        // Implementasi attack untuk zombie
        System.out.println(getName() + " attack with " + getAttackDamage());
    }
}

