package Inventory;
import java.util.ArrayList;
import Plant.*;
import Deck.*;
import MapGame.*;
import Zombies.*;

public class ZombieDeck {
    private ArrayList<Zombie> deckZombie;

    public ZombieDeck(){
        this.deckZombie = new ArrayList<Zombie>();
        NormalZombie zom1 = new NormalZombie(0,10);
        ConeheadZombie zom2 = new ConeheadZombie(0,10);
        PoleVaultingZombie zom3 = new PoleVaultingZombie(0,10);
        BucketheadZombie zom4 = new BucketheadZombie(0,10);
        DuckyTubeZombie zom5 = new DuckyTubeZombie(0,10);
        DolphinRiderZombie zom6 = new DolphinRiderZombie(0,10);
        SnorkelZombie zom7 = new SnorkelZombie(0,10);
        FlagZombie zom8 = new FlagZombie(0,10);
        ScreendoorZombie zom9 = new ScreendoorZombie(0,10);
        FootballZombie zom10 = new FootballZombie(0,10);
        deckZombie.add(zom1);
        deckZombie.add(zom2);
        deckZombie.add(zom3);
        deckZombie.add(zom4);
        deckZombie.add(zom5);
        deckZombie.add(zom6);
        deckZombie.add(zom7);
        deckZombie.add(zom8);
        deckZombie.add(zom9);
        deckZombie.add(zom10);
    }

    public ArrayList<Zombie> getZombieDeck(){
        return deckZombie;
    }


    public void displayZombieDeck() {
        System.out.println("Deck Zombie:");
        for (int i = 0; i < deckZombie.size(); i++) {
            System.out.println((i + 1) + ". " + deckZombie.get(i).getName()) ;
        }
    }
}
