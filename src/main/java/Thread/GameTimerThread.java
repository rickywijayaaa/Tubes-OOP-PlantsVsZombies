package Thread;

import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameTimerThread implements Runnable {
    public int gametimer;
    private AtomicBoolean waitingForInput;

    public GameTimerThread(int gametime, AtomicBoolean waitingForInput) {
        gametimer = gametime;
        this.waitingForInput = waitingForInput;
    }

    @Override
    public void run() {
        while (gametimer < 200) {
            try {
                Thread.sleep(1000);
                if (!waitingForInput.get()) {
                    System.out.print("\rTime right now: " + gametimer +
                            " | Sun: " + GenerateSunThread.getMessage() +
                            " | Zombies: " + ZombieSpawnThread.getMessage()+
                            " | Input: ");
                }
                gametimer++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentGameTime() {
        return gametimer;
    }

    public void endCurrentGameTime() {
        gametimer = 0;
    }
}
