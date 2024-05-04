package app.src.main.java.Zombies;

import app.src.main.java.Creature.*;


public class NormalZombie extends Zombie {
    public NormalZombie(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, double slowed, double speed) {
        super(name, health, attackDamage, attackSpeed, isAquatic, slowed, speed);
    }



    // Implementing abstract method from Creature class
    @Override
    public void resetCooldown(){
        // Implementing the attack behavior for a NormalZombie
        // For example:
        System.out.println("nanti dioveerride");
    }

    // Implementing abstract method from Creature class
    @Override
    public void move() {
        // Implementing the movement behavior for a NormalZombie
        // For example:
        System.out.println(getName() + " moves slowly with speed " + getSpeed());
    }

    @Override
    public void attack() {
        // Implementing the movement behavior for a NormalZombie
        // For example:
        System.out.println(getName() + " attack with " + getAttackDamage());
    }
}

