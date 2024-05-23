package MapGame;

import Creature.*;
import Plant.*;

public class PoolTile extends Tile {    
    
    private boolean lilyPad_Plant;

    public PoolTile(boolean lilyPad_Plant) {
        super("Pool", false, false);
        this.lilyPad_Plant = lilyPad_Plant;
    }

    public boolean getLilyPad_Plant() {
        return this.lilyPad_Plant;
    }

    public void Plant_LilyPad() {
        this.lilyPad_Plant = true;
    }

    public void UnPlant_LilyPad() {
        this.lilyPad_Plant = false;
    }

    //Butuh Exception kalau belum ada lilipad
    public void checkLilyPadBeforePlanting(Creature creature) {
        if (!(creature instanceof Lilypad) && !this.hasLilypad()) {
            System.out.println("Can only plant on top of a Lilypad in PoolTile.");
        }
    }

    // @Override
    // public void addCreature(Creature creature) {
    //     if (creature instanceof Plant) {
    //         this.checkLilyPadBeforePlanting(creature);
    //         if (!(creature instanceof Lilypad) && !this.hasLilypad() || !(creature instanceof TangleKelp) ) {
    //             System.out.println("Can only plant on top of a Lilypad in PoolTile.");
    //             return; // Prevent adding the plant
    //         }
    //     }
    //     super.addCreature(creature);
    // }
}
