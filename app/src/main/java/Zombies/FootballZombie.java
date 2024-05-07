package app.src.main.java.Zombies;


import app.src.main.java.Creature.*;
import app.src.main.java.Plant.*;

public class FootballZombie extends Zombie {
    public FootballZombie() {
        super("Football Zombie" ,300,100,7,false,0,5 );
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

