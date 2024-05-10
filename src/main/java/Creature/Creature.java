package Creature;

import Koordinat.*;
import java.util.concurrent.TimeUnit;

public abstract class Creature {
    private String name;
    private int health;
    private int attackDamage;
    private double attackSpeed;
    private boolean isAquatic;
    private Koordinat k;
    private long startTime;

    public Creature(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic, int x , int y) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
        this.k = new Koordinat(x,y);
        startTime = TimeUnit.SECONDS.convert(System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // Setter method untuk mengurangi health akibat damage
    public void setHealth(int damage) {
        if(!isDead()){
            if(damage <  health){
                health -= damage;
            }
            else{
                health = 0;
            }
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    // method untuk mengecheck apakah Creature sudah mati atau belum
    public boolean isDead() {
        return health <= 0;
    }

    public long getStartTime(){
        return startTime;
    }

    public void displayCreaturekoor(){
        k.displayKoordinat();
    }

    public Koordinat getKoordinat(){
        return k;
    }
    
    // Abstract method attack
    public abstract void resetCooldown();

    // Abstract method for movement
    public abstract void move();




}
