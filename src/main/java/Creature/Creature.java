package Creature;

import Koordinat.*;
import java.util.concurrent.TimeUnit;
import MapGame.*;

public abstract class Creature {
    private String name;
    private int health;
    private int attackDamage;
    private double attackSpeed;
    private boolean isAquatic;
    private boolean isAlive;
    private Koordinat k;
    private long timeCreated;

    public Creature(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int x , int y, boolean isAlive) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
        this.k = new Koordinat(x,y);
        this.isAlive= isAlive;
        long timeCreated = TimeUnit.SECONDS.convert(System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }


    // Getter methods
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void setIsAlive(){
        isAlive = false;
    }

    // Setter method untuk mengurangi health akibat damage
    public void setHealth(int damage) {
        if(!isDead()){
            if(damage <  health){
                health -= damage;
            }
            else{
                health = 0;
                isAlive = false;
            }
        }
        else{
            isAlive =false;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double newspeed){
        attackSpeed = newspeed;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    // method untuk mengecheck apakah Creature sudah mati atau belum
    public boolean isDead() {
        return health <= 0;
    }

    public long getTimeCreated(){
        return timeCreated;
    }

    public void displayCreaturekoor(){
        k.displayKoordinat();
    }

    public Koordinat getKoordinat(){
        return k;
    }

    public void setKoordinat(int x2 , int y2){
        Koordinat newkoor = new Koordinat(x2,y2);
        k = newkoor;
    }

    public void die(Peta mapGame) {
        Koordinat koorZ = getKoordinat(); // Get zombie's current position
        int koorx = koorZ.getX();
        int koory = koorZ.getY();
        Tile tile = mapGame.getTile(koorx, koory);
        tile.removeCreature(this);
    }
    
    // Abstract method attack
    public abstract void resetCooldown(double newcooldown);

    // Abstract method for movement
    public abstract void move();




}
