package Zombies;
import Plant.*;
import Creature.*;


public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie() {
        super("Dolphin Rider Zombie", 175, 100, 1, true, 0, 500);
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

