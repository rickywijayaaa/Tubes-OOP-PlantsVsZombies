package app.src.main.java.Creature;

public abstract class Creature {
    private String name;
    private int health;
    private int attackDamage;
    private double attackSpeed;
    private boolean isAquatic;

    public Creature(String name, int health, int attackDamage, double attackSpeed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
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
            health -= damage;
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
    
    // Abstract method attack
    public abstract void resetCooldown();

    // Abstract method for movement
    public abstract void move();
}
