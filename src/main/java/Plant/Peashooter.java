package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;

public class Peashooter extends Plant {
    public Peashooter(int x, int y) {
        super("Peashooter", 100, 25, 4, false, x,y,true,100, 6, 10);
    }

    // Implementing abstract method dari Plant class
    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Peashooter tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Peashooter tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }

    public void attack2(Peta peta){
        if(this.getAttackSpeed()==4){
            int startRow = this.getKoordinat().getX();
            int startCol = this.getKoordinat().getY();
            this.setAttackSpeed(0);
            for (int i = 0; i <= 11- startCol; i++) {
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
        else{
            this.setAttackSpeed(getAttackSpeed()+1);
        }
     }
}

