package Inventory;
import java.util.ArrayList;
import Plant.*;
import Deck.*;
import MapGame.*;

public class Inventory<T extends Plant> {
    private ArrayList<Plant> inven;
    private ArrayList<T> deck;
    private Peta peta;

    public Inventory(Peta peta){
        this.inven = new ArrayList<Plant>();
        this.peta = peta;
        Sunflower pla1 = new Sunflower(0,0);
        Peashooter pla2 = new Peashooter(0,0);
        Wallnut pla3 = new Wallnut(0,0);
        SnowPea pla4 = new SnowPea(0,0);
        Squash pla5 = new Squash(0,0);
        Lilypad pla6 = new Lilypad(0,0);
        CherryBomb pla7 = new CherryBomb(0,0);
        Repeater pla8 = new Repeater(0,0);
        CabbagePult pla9 = new CabbagePult(0,0);
        TangleKelp pla10 = new TangleKelp(0,0);
        inven.add(pla1);
        inven.add(pla2);
        inven.add(pla3);
        inven.add(pla4);
        inven.add(pla5);
        inven.add(pla6);
        inven.add(pla7);
        inven.add(pla8);
        inven.add(pla9);
        inven.add(pla10);
        deck = new ArrayList<>();
    }

    public ArrayList<Plant> getInven(){
        return inven;
    }

    public ArrayList<T> getDeckInven(){
        return deck;
    }

    public boolean isCooldownOver () {
        return false;
    }

    public void choosePlant(int index){
        Plant plant = inven.remove(index);
        deck.add((T)plant);
    }

    public void swapPlant(int index1, int index2){
        Plant temPlant = inven.get(index1);
        inven.set(index1, inven.get(index2));
        inven.set(index2, temPlant);
    }

    public void deletePlant(int index){
        if (index >= 0 && index < deck.size()){
            T plant = deck.remove(index);
            inven.add((Plant)plant);
        }
    }

    public void displayInventory() {
        System.out.println("Inventory tanaman beserta costnya:");
        for (int i = 0; i < inven.size(); i++) {
            System.out.println((i + 1) + ". " + inven.get(i).getName() + " - " + inven.get(i).getCost()) ;
        }
    }

    public void displayDeck() {
        if(deck.size()>0){
            System.out.println("Deck tanaman beserta costnya:");
            for (int i = 0; i < deck.size(); i++) {
                System.out.println((i + 1) + ". " + deck.get(i).getName()+ " - " + deck.get(i).getCost());
            }
        }  
        else{
            System.out.println("Deck kosong!!!");
        }
    }

    public void addPlant(Plant plant, int koorx, int koory){
            Tile tile = peta.getTile(koorx,koory);
            tile.addCreature(plant);
    }
}