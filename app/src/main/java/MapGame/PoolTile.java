package app.src.main.java.MapGame;

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
}
