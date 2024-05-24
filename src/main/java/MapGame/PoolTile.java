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
    public void setLilypad(boolean hasLilypad) {
        this.lilyPad_Plant = hasLilypad;
    }

    // //Butuh Exception kalau belum ada lilipad
    // public void checkLilyPadBeforePlanting(Creature creature) throws Exception {
    //     if (!(creature instanceof Lilypad) && !(creature instanceof TangleKelp) && !this.hasLilypad()) {
    //         throw new Exception("Can only plant on top of a Lilypad in PoolTile, except for TangleKelp.");
    //     }
    // }

    @Override
    public void addCreature(Creature creature) {
        super.addCreature(creature);
        if (creature instanceof Lilypad) {
            this.setLilypad(true);
        }
    }

    @Override
    public void removeCreature(Creature creature) {
        super.removeCreature(creature);
        if (creature instanceof Lilypad) {
            this.setLilypad(false);
        }
    }
}
