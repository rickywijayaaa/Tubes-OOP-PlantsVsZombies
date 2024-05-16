
package Thread;

import java.util.Random;
import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;

public class GenerateSunThread implements Runnable {
    private int sundrop;
    
    public GenerateSunThread(int sundrop){
        this.sundrop = sundrop;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
            while(sundrop > 0){
                try {
                Random rand = new Random();
                int berkurang = rand.nextInt(5000, 10000);
                Thread.sleep(berkurang);
                Sun.addSun();
                System.out.println("jumlah matahari : "+ Sun.getSun());
                sundrop -= (berkurang/1000);
                
            }
            
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }  }  

    public int getCurrentSundrop(){
        return sundrop;
    }

    public void endCurrentSundrop() {
        sundrop = 0;
    }
}
