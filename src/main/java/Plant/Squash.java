package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class Squash extends Plant {
    public Squash(int x, int y) {
        super("Squash", 100, 5000, 0, false,x,y,true,50,1, 20);
    }

    // Implementing abstract method dari Plant class
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

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Squash tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Squash tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }
}
