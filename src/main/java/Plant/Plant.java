package Plant;
import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class Plant extends Creature {
    private int cost;
    private int range;
    private double cooldown;

    
    static HashMap<Class<? extends Plant> , Double> cooldownMap = new HashMap<>();
   

    public Plant(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic,int x , int y,boolean isAlive,int cost,int range, double cooldown) {
        super(name,health, attackDamage, attackSpeed, isAquatic,x,y,isAlive);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
    
        cooldownMap.putIfAbsent(this.getClass(),0.0);
   
    }

    public boolean isInCooldown() {
        // if (timemilis - this.getTimeCreated()% cooldown == 0){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        // return false;
        double remainingCooldown = cooldownMap.get(this.getClass());
        boolean inCooldown = remainingCooldown > 0;

        System.out.println("Checking cooldown for " + this.getClass().getSimpleName() + ": " + inCooldown);
        System.out.println("Cooldown remaining: " + remainingCooldown + " seconds");

        return inCooldown;
    }

    public void setCooldown() {
        cooldownMap.put(this.getClass(), this.cooldown);
        System.out.println(this.getClass().getSimpleName() + " is set to cooldown for " + this.cooldown + " seconds");
    }

    public void decrementCooldown() {
        double remainingCooldown = cooldownMap.get(this.getClass());
        if (remainingCooldown > 0) {
            remainingCooldown -= 1.0; // Decrement by 1 second
            if (remainingCooldown < 0) {
                remainingCooldown = 0; // Ensure it doesn't go negative
            }
        cooldownMap.put(this.getClass(), remainingCooldown);
        }
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
    public void attack(Zombie zombie){
        if(zombie.isAlive()){
            zombie.setHealth(getAttackDamage());
        }
        if(!(this instanceof SnowPea)){
            zombie.setSlowed(0);
        }
    }

    //display plant
    public void displayPlant(){
        System.out.println("nama: " + getName() + " memiliki health : " + getHealth() + " attack damage : " + getAttackDamage() + " attack speed : " + getAttackSpeed());
    }
    
    // Implementing abstract methods dari Creature class
    @Override
    public void resetCooldown(double newcooldown) {
        // Implementing attack behavior untuk Plant
        // Methodnya akan beragam sesuai dengan Plant
        cooldown = (int) newcooldown;
    }

    @Override
    public void move() {
        // Implementing move behavior untuk Plant
        // Plants biasanya tidak melakukan "move"
    }

    public List<Zombie> getRange(List<Zombie> listofZombies){
        List<Zombie> zombiesInRange = new ArrayList<>();
        for (Zombie z : listofZombies) {
            if (Math.abs(z.getKoordinat().getX() - this.getKoordinat().getX()) <= range
                && Math.abs(z.getKoordinat().getY() - this.getKoordinat().getY()) <= range) {
                zombiesInRange.add(z);
            }
        }
    return zombiesInRange;
    }


    // Get Tile buat attack

    public Tile getTileAttack(Plant plant, Peta peta){
        int col = plant.getKoordinat().getX();
        int row = plant.getKoordinat().getY();
        if(plant.getRange()==-1){
            for(int j = row+1;j<10;j++){
                Tile check = peta.getTile(col,j);
                if(check.hasZombie()){
                    return check;
                }
            }
        }
        else if (plant.getRange()==1){
            Tile check2 = peta.getTile(col,row+1);
            if(check2.hasZombie()){
                return check2;
            }
        }
        else{
            for(int j = row+1;j<row+4;j++){
                Tile check3 = peta.getTile(col,j);
                if(check3.hasZombie()){
                    return check3;
                }
            }
        }
        return null;
    }

    // public void attackZom(Zombie zom,Peta peta) {
    //     // Implementing attack behavior untuk Peashooter
    //     if(zom.getIsAlive()){
    //         zom.setHealth(getAttackDamage());
    //     }
    // }
}




