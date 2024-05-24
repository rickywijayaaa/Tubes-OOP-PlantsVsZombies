package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;
import java.util.List;
import java.util.ArrayList;

public class CherryBomb extends Plant {
    public CherryBomb(int x, int y) {
        super("Cherry Bomb", 150, 1000,0, false,x , y,true,150, 3, 20);
    }

    // Implementing abstract method dari Creature class
    @Override
    public void move() {
        // Cherry Bomb tidak moving, jadi method tidak melakukan apapun
    }

    // Implementing abstract method dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Cherry Bomb tidak memiliki cooldowns, jadi method tidak melakukan apapun
    }

    
    public void attack2(Peta peta) {
        int startRow = this.getKoordinat().getX();
        int startCol = this.getKoordinat().getY();
        System.out.println("debug");
    
        // Check the 3 tiles in front of CherryBomb
        for (int i = 1; i <= 3; i++) {
            int targetCol = startCol + i;
            if (targetCol >= 11) break; // Out of grid bounds
            Tile targetTile = peta.getTile(startRow, targetCol);
            
            // Attack all zombies in the target tile
            List<Creature> creaturesToAttack = new ArrayList<>();
            for (Creature targetCreature : targetTile.getEntities()) {
                if (targetCreature instanceof Zombie) {
                    creaturesToAttack.add(targetCreature);
                }
            }
    
            // Perform attack on all collected zombies
            for (Creature creature : creaturesToAttack) {
                this.attack((Zombie) creature);
            }
        }
    
        // Remove the CherryBomb itself
        Tile currentTile = peta.getTile(startRow, startCol);
        this.setIsAlive();
        this.die(peta);
        currentTile.removeCreature(this);
        
    }
}
