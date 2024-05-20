package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;

public class CabbagePult extends Plant {
    public CabbagePult(int x, int y) {
        super("Cabbage Pult", 100, 20, 1,false,x,y,true,100, 3, 5);
    }

    //Implementing abstract method dari Plant class

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cabbage Pult tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Cabbage Pult tidak cooldowns, jadi method tidak melakukan apapun
    }

    public void attack2(Peta peta){
        int startRow = this.getKoordinat().getX();
        int startCol = this.getKoordinat().getY();
        
        for (int i = 1; i <= 3; i++) {
            int targetCol = startCol + i;
            if (targetCol >= 11) break; // Out of grid bounds
            Tile targetTile = peta.getTile(startRow, targetCol);
            for (Creature targetCreature : targetTile.getEntities()) {
                if (targetCreature instanceof Zombie) {
                    this.attack((Zombie) targetCreature);
                    return; // Attack the first zombie encountered
                }
            }
        }
    
    }
}

