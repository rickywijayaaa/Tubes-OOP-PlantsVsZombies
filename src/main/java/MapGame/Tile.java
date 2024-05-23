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
        return this.
        area;
    }
    public void addCreature(Creature creature) {
        if (creature instanceof Plant) {
            if (this.hasPlanted() && !(this instanceof PoolTile)) {
                System.out.println("Tile already has a plant.");
                return;
            }
            if (this instanceof PoolTile && !this.hasLilypad() && !(creature instanceof Lilypad || creature instanceof TangleKelp)) {
                System.out.println("Can only plant on top of a Lilypad or TangleKelp in PoolTile.");
                return;
            }
        }
        entity.add(creature);
        this.updatePlantStatus();
    }


    public void removeCreature(Creature creature) {
        entity.remove(creature);
        this.updatePlantStatus();
    }

    public ArrayList<Creature> getEntities() {
        return this.entity;
    }

    public void isPlanted() {
        for (Creature creatures : entity) { 
            if (creatures instanceof Plant) {
                hasPlant = true;
                return;
            }
        }
        hasPlant = false;
    }

    public void updatePlantStatus() {
        for (Creature creatures : entity) {
            if (creatures instanceof Plant) {
                hasPlant = true;
                return;
            }
        }
        hasPlant = false;
    }

    // mengembalikan apakah ada zombie 
    public boolean hasZombie() {
        boolean check = false;
        for (Creature creatures : entity) { 
            if (creatures instanceof Zombie) {
                check = true;
            }
        }
        return check;
        
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

    public void removePlant() {
        entity.clear();
        // for (Creature creatures : entity) { 
        //     if (creatures instanceof Plant) {
        //         entity.clear();
        //     }
        // }
    }

    public boolean hasLilypad() {
        for (Creature creatures : entity) {
            if (creatures instanceof Lilypad) {
                return true;
            }
        }
        return false;
    }
    
}