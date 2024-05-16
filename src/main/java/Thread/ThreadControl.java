package Thread;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ThreadControl {
    private static ArrayList<Runnable> ThreadList = new  ArrayList<Runnable>();

    public synchronized static ArrayList<Runnable> getList(){
        return ThreadList;
    }

    public static void addThread(Runnable thread) {
        ThreadList.add(thread);
    }

    public static void removeThread(int i) {
        ThreadList.remove(i);
    }

    public synchronized static void startAllThreads() {
        for (Runnable run : ThreadList) {
            Thread t = new Thread(run);
            t.start();
        }
    }

    public synchronized static void stopAllThreads(){
        for(Runnable run : ThreadList){
            if(run instanceof GameTimerThread){
                ((GameTimerThread)run).endCurrentGameTime();
            } else if(run instanceof GenerateSunThread){
                ((GenerateSunThread)run).endCurrentSundrop();
            }
        }
        for(int i = 0; i < ThreadList.size(); i++){
            ThreadControl.removeThread(i);
        }
    }

    public static GameTimerThread getGameTimerThread() {
        GameTimerThread r = null;
        for (Runnable run : ThreadControl.getList()) {
            {
                if(run instanceof GameTimerThread){
                    r = (GameTimerThread) run;
                }
            }
        }
        return r;
    }
}