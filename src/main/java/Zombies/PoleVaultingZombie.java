package Zombies;
import Plant.*;
import Creature.*;


public class PoleVaultingZombie extends Zombie {
    public PoleVaultingZombie(int x, int y) {
        super("Pole Vaulting Zombie", 175, 100, 1, false,x,y, 0, 5);
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
