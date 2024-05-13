package MapGame;


import Creature.*;
import Zombies.*;
import Plant.*;
import java.util.ArrayList;

public class Tile {
    private String area;
    private boolean canPlant;
    private boolean hasPlant;
    private ArrayList<Creature> entity;

    public Tile(String area, boolean canPlant, boolean hasPlant) {
        this.area = area;
        this.canPlant = canPlant;
        this.entity = new ArrayList<>();
        this.hasPlant = hasPlant;
    }

    public String getType() {
        return this.area;
    }

    public void addCreature(Creature creature) {
        entity.add(creature);
    }

    public void removeCreature(Creature creature) {
        entity.remove(creature);
    }

    public ArrayList<Creature> getEntities() {
        return this.entity;
    }

    public void isPlanted() {
        for (Creature creatures : entity) { 
            if (creatures instanceof Plant) {
                hasPlant = true;
            }
        }
        hasPlant = false;
    }

    public boolean hasPlanted() {
        this.isPlanted();
        return hasPlant;
    }

    public boolean getCanPlant() {
        return canPlant;
    }

    // fungsi untuk menghapus semua creature pada suatu petak
    public void removeAllCreatures() {
        entity.clear();
    }


    
}