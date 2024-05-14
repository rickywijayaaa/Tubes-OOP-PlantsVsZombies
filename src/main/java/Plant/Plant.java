package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public abstract class Plant extends Creature {
    private int cost;
    private int range;
    private double cooldown;

    
    static HashMap<Class<? extends Plant> , Boolean> coolDownMap = new HashMap<>();
   

    public Plant(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic,int x , int y,int cost,int range, double cooldown) {
        super(name,health, attackDamage, attackSpeed, isAquatic,x,y);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;

    
        coolDownMap.putIfAbsent(this.getClass(),false);
   
    }

    public boolean isInCooldown() {
        return coolDownMap.get(this.getClass());
    }
    public void setCooldown(boolean isInCooldown) {
        coolDownMap.put(this.getClass(), isInCooldown);
    }


  
    // Getter methods untuk atribut tambahan
    public int getCost() {
        return cost;
    }

    public int getRange() {
        return range;
    }

    public double getCooldown() {
        return cooldown;
    }

    // Abstract method attack zombie
    public abstract void attack(Zombie zom);

    //display plant
    public void displayPlant(){
        System.out.println("nama: " + getName() + " memiliki health : " + getHealth() + " attack damage : " + getAttackDamage() + " attack speed : " + getAttackSpeed());
    }

    public void die(Peta mapGame) {
        Koordinat koorZ = getKoordinat(); // Get zombie's current position
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        Tile tile = mapGame.getTile(koorx, koory);
        koorZ.displayKoordinat();
        tile.removeCreature(this);
    }
    
    // Implementing abstract methods dari Creature class
    @Override
    public void resetCooldown() {
        // Implementing attack behavior untuk Plant
        // Methodnya akan beragam sesuai dengan Plant
    }

    @Override
    public void move() {
        // Implementing move behavior untuk Plant
        // Plants biasanya tidak melakukan "move"
    }
}




