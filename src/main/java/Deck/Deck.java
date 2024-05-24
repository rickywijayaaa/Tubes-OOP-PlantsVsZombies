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
}
