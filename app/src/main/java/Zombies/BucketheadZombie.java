package app.src.main.java.Zombies;

import app.src.main.java.Creature.*;


public class BucketheadZombie extends Zombie {
    public BucketheadZombie(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, double slowed, double speed) {
        super(name, health, attackDamage, attackSpeed, isAquatic, slowed, speed);
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

