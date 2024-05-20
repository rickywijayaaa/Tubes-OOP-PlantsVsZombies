import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;
import Thread.*;
import java.util.concurrent.*;
import java.util.Scanner;



public class  App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunningGame = true;
        long mulaigame = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Sun.getInstance();
        Sun.setSun(0);
        Peta peta = new Peta();
        Inventory inven = new Inventory(peta);
        MenuGame.Menu();

    }       
}



