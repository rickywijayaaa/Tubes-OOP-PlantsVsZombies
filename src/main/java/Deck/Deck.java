package Deck;

import java.util.ArrayList;

import Plant.*;
import MapGame.*;

public class Deck {
    public static final int MAXCAPACITYDECK = 6; 
    private ArrayList<Plant> deck2;
    private Peta peta;

    public Deck(Peta peta) {
        this.deck2 = new ArrayList<Plant>();
        this.peta = peta;
    }

    public ArrayList<Plant> getDeck(){
        return deck2;
    }

    public boolean isCooldownOver () {
        return true;
    }

    public void addDeck(Plant pl){
        deck2.add(pl);
    }

    public void removeDeck(Plant pl){
        deck2.remove(pl);
    }

    public void addPlant(Plant plant, int[] position) {
        try {
            Tile tile = peta.getTile(position[0], position[1]);
            if (tile.hasPlanted()) {
                throw new ExceptionIsPlanted("This Tile Has Been Planted!");
            }
            else if (isCooldownOver()) {
                throw new ExceptionPlantStillCooldown("This Plant is On Cooldown!");
            }
            else {
                tile.addCreature(plant);
            }
        }
        catch (ExceptionIsPlanted e) {
            System.out.println(e.getMessage());
        }
        catch (ExceptionPlantStillCooldown e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePlant(int[] position) {
        try {
            Tile tile = peta.getTile(position[0], position[1]);
            if (!tile.hasPlanted()) {
                throw new ExceptionIsNotPlanted(null);
            }
            else {
                    tile.removeCreature(null);
            }
        }
        catch (ExceptionIsNotPlanted e) {
            System.out.println(e.getMessage());
        }
    }

}

class ExceptionIsPlanted extends Exception {
    public ExceptionIsPlanted(String message) {
        super(message);
    }
}

class ExceptionIsNotPlanted extends Exception {
    public ExceptionIsNotPlanted(String message) {
        super(message);
    }
}

class ExceptionPlantStillCooldown extends Exception {
    public ExceptionPlantStillCooldown(String message) {
        super(message);
    }
}

