package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Inventory.*;
import Koordinat.*;

public class SnowPea extends Plant {
    public SnowPea(int x, int y) {
        super("Snow Pea", 100, 25, 4, false, x,y,true,175,-1, 10);
    }

    // Implementing abstract method dari Plant class
    @Override
    public void attack(Zombie zom) {
        // Implementing attack behavior untuk Peashooter
        if(zom.getIsAlive()){
            zom.setHealth(getAttackDamage());
        }
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Snow Pea tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Snow Pea tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }

    public void attack2(Peta peta){
        int startRow = this.getKoordinat().getX();
        int startCol = this.getKoordinat().getY();
        
        for (int i = 1; i <= 11- startCol; i++) {
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
