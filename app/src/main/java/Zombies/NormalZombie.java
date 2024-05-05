package app.src.main.java.Zombies;

import app.src.main.java.Creature.*;


public class NormalZombie extends Zombie {
    public NormalZombie() {
        super("NormalZombie", 125, 100, 1, false, 0, 0);
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

