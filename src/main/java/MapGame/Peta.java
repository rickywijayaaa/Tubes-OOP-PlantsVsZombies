package MapGame;
import Creature.*;
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