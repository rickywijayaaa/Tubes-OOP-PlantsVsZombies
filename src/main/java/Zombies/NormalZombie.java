package Zombies;
import Plant.*;
import Creature.*;


public class NormalZombie extends Zombie {
    public NormalZombie(int x, int y) {
        super("Normal Zombie", 125, 100, 1, false,x,y, true,0, 10);
    }

    @Override
    public void attack(Plant pl) {
        // Implementasi attack untuk zombie
        pl.setHealth(getAttackDamage());
    }
}

