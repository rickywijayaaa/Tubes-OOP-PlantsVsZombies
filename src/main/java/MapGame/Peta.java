package MapGame;
import Creature.*;
import Sun.Sun;
import Zombies.*;
import Plant.*;
import java.util.ArrayList;


public class Peta {
    private Tile[][] grid;

    public Peta() {
        this.grid = new Tile[6][9];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 9; col++) {
                if (col == 0) {
                    grid[row][col] = new BaseTile();
                }
                else if (col == 8) {
                    grid[row][col] = new ZombieSpawnTile();
                }
                else if (row >= 2 && row <= 3) {
                    grid[row][col] = new PoolTile(false);
                }
                else {
                    grid[row][col] = new ZombieSpawnTile();
                }
            }
        }
    }

    //winata 12/5
    void plant(int row,int col,Plant toBePlanted) throws Exception {
        if(col <= 0 || col == 8){
            throw new Exception("Tile bertanam invalid");
        }
        if(Sun.getSun() < toBePlanted.getCost() ){
            throw new Exception("Tidak cukup matahari untuk membeli tanaman");
        }
        if(toBePlanted.isInCooldown()){
            throw new Exception("Tanaman " + toBePlanted.getName() + " masih dalam cooldown");
        }

        boolean pool = row >= 2 && row <= 3;
        if(toBePlanted instanceof Lilypad && !pool){
            throw new Exception("Tile bertanam invalid");
        }

        boolean lilyPlanted = false;
        boolean plantOnTop = false;
        for(Creature creature : grid[row][col].getEntities()){
            if(creature instanceof  Lilypad){
                lilyPlanted = true;
            } else if(creature.getClass().isAssignableFrom(Plant.class)){
                plantOnTop = true;
            }
        }

        if(pool && !lilyPlanted  && !(toBePlanted instanceof Lilypad)){
            throw new Exception("Tile bertanam invalid");
        }

        if(plantOnTop){
            throw  new Exception("Tile bertanam invalid");
        }

        toBePlanted.setCooldown(true);
        this.grid[row][col].addCreature(toBePlanted);
    }
    //winata 12/5

public Tile getTile(int row, int col) {
    if (row < 0 || row > 6 || col < 0 || col > 9) {
        //throw exception
    }
    return this.grid[row][col];
    }

public void displayMap() {
    for (int row = 0; row < 6; row++) {
        for (int col = 0; col < 9; col++) {
            Tile tile = getTile(row, col);
            ArrayList<Creature> entities = tile.getEntities();
                
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Creature entity : entities) {
                sb.append(entity.getName()).append(", ");
            }

            if (sb.length() > 1) { 
                sb.setLength(sb.length() - 2); 
            }

            sb.append("]");
            System.out.print(sb.toString());
        }
        System.out.println();
    }
}

    
}