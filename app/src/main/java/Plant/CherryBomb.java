package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class CherryBomb extends Plant {
    public CherryBomb(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int cost, int range, double cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic, cost, range, cooldown);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack() {
        // Cherry Bomb meledak, membunuh zombie di sekitarnya
        System.out.println(getName() + " explodes, damaging nearby zombies! DUARRR");
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cherry Bomb tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown() {
        // Cherry Bomb tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}

