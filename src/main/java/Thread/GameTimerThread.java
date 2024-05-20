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
    public static int gametimer;
    private AtomicBoolean waitingForInput;
    private AtomicBoolean suppressDisplayMap;

    public GameTimerThread(int gametime, AtomicBoolean waitingForInput, AtomicBoolean suppressDisplayMap) {
        gametimer = gametime;
        this.waitingForInput = waitingForInput;
        this.suppressDisplayMap = suppressDisplayMap;
    }

    @Override
    public void run() {
        while (gametimer < 200) {
            try {
                Thread.sleep(1000);
                if (!waitingForInput.get()) {
                    System.out.print("\r(Time right now: " + gametimer +
                            " | Sun: " + GenerateSunThread.getMessage() +
                            " | Zombies: " + ZombieSpawnThread.getMessage() +
                            "), Input Pilihan Tanaman: ");
                }
                gametimer++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printMessage() {
        System.out.println("Time right now: " + gametimer +
                " | Sun: " + GenerateSunThread.getMessage() +
                " | Zombies: " + ZombieSpawnThread.getMessage());
    }

    public int getCurrentGameTime() {
        return gametimer;
    }

    public void endCurrentGameTime() {
        gametimer = 0;
    }
}
