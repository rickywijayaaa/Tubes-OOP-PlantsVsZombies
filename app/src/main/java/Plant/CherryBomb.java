package app.src.main.java.Plant;
import app.src.main.java.Creature.*;

public class CherryBomb extends Plant {
    public CherryBomb(String name, int cost, int health, int attackDamage, double attackSpeed, int range, double cooldown, boolean isAquatic) {
        super("Cherry Bomb", 150, 0, 1000, 0, 3, 30, false);
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

