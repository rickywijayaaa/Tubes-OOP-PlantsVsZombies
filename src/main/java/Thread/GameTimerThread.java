package Thread;

import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;
import java.util.Random;
import java.util.Timer;

public class GameTimerThread implements Runnable{
    public int gametimer;
   

    public GameTimerThread(int gametime){
        gametimer = gametime;
    }
    
    @Override
    public void run() {
            while(gametimer < 200){
                try {
                Thread.sleep(1000);
                System.out.println("Time right now : " +ThreadControl.getGameTimerThread().getCurrentGameTime());
                gametimer ++;
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                } 
        }
    }
    public int getCurrentGameTime(){
        return gametimer;
    }

    public void endCurrentGameTime() {
        gametimer = 0;
    }
    
}
