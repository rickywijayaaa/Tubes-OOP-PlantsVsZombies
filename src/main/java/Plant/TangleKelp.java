package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class TangleKelp extends Plant {
    public TangleKelp(int x, int y) {
        super("Tangle Kelp", 100, 5000, 0,true,x,y,true,25, 1, 5);
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Tangle Kelp tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Tangle Kelp tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }

    public void attack2(Peta peta){
        int startRow = this.getKoordinat().getX();
        int startCol = this.getKoordinat().getY();
        int targetCol = startCol + 1;

        Tile tiletarget = peta.getTile(startRow,targetCol);

        if(tiletarget.hasZombie()){
            for (Creature creature : tiletarget.getEntities()) {
                if (creature instanceof Zombie) {
                    this.attack((Zombie) creature); // Attack the plant
                    this.setIsAlive();
                    this.die(peta);
                    return; // Stop walking since the zombie attacks
                }
            }
        }
    }
}

