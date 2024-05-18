package MapGame;
import Creature.*;
import Zombies.*;
import Plant.*;
import java.util.ArrayList;
import Sun.*;

public class Peta {
    private Tile[][] grid;

    public Peta() {
        this.grid = new Tile[6][11];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 11; col++) {
                if (col == 0) {
                    grid[row][col] = new BaseTile();
                } else if (col == 10) {
                    grid[row][col] = new ZombieSpawnTile();
                } else if (row >= 2 && row <= 3 && col != 0 && col!=10) {
                    grid[row][col] = new PoolTile(false);
                } else {
                    grid[row][col] = new GrassTile();
                }
            }
        }
    }



    public Tile getTile(int row, int col) {
        if (row < 0 || row >= 6 || col < 0 || col >= 11) {
            throw new IllegalArgumentException("Indeks di luar batas matriks");
        }
        return this.grid[row][col];
    }

    public void plant(Plant toBePlanted,int row, int col) throws Exception {
        if (col <= 0 || col >= 10) {
            throw new Exception("Tile belum ada lilypad sehingga tidak bisa ditanam");
        }
        if (Sun.getSun() < toBePlanted.getCost()) {
            throw new Exception("Tidak cukup matahari untuk membeli tanaman");
        }
        if (toBePlanted.isInCooldown()) {
            throw new Exception("Tanaman " + toBePlanted.getName() + " masih dalam cooldown");
        }

        boolean pool = row >= 2 && row <= 3 && col!= 0 && col!=10;
        if (toBePlanted instanceof Lilypad && !pool) {
            throw new Exception("Tile bertanam invalid");
        }
        boolean base = col==0;
        if (base){
            throw new Exception("Tanaman tidak bisa ditanam di base !");
        }

        boolean spawn = col==10;
        if (spawn){
            throw new Exception("Tanaman tidak bisa ditanam di spawn zombie !");
        }

        boolean lilyPlanted = false;
        boolean plantOnTop = false;
        for (Creature creature : grid[row][col].getEntities()) {
            if (creature instanceof Lilypad) {
                lilyPlanted = true;
            } else if (creature.getClass().isAssignableFrom(Plant.class)) {
                plantOnTop = true;
            }
        }

        if (pool && !lilyPlanted && !(toBePlanted instanceof Lilypad)) {
            throw new Exception("Tile bertanam invalid");
        }

        if (plantOnTop) {
            throw new Exception("Tile bertanam invalid");
        }

        //toBePlanted.setCooldown(true);
        this.grid[row][col].addCreature(toBePlanted);
    }

    public void displayMap() {
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        String grey = "\u001B[37m";
        String white = "\u001B[37m";

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 11; col++) {
                Tile tile = getTile(row, col);
                ArrayList<Creature> entities = tile.getEntities();

                StringBuilder sb = new StringBuilder();

                if (tile instanceof PoolTile) {
                    sb.append(blue).append("{");
                } else if (tile instanceof BaseTile) {
                    sb.append(red).append("[");
                } else if (tile instanceof ZombieSpawnTile) {
                    sb.append(grey).append("[");
                } else if (tile instanceof GrassTile) {
                    sb.append(green).append("[");
                }

                if (entities.isEmpty()) {
                    sb.append(".");
                } else {
                    for (Creature entity : entities) {
                        sb.append(entity.getName())
                          .append("-")
                          .append(entity.getHealth())
                          .append(", ");
                    }
                    if (sb.length() > 1) {
                        sb.setLength(sb.length() - 2); // Remove trailing ", "
                    }
                }

                if (tile instanceof PoolTile) {
                    sb.append("}");
                } else {
                    sb.append("]");
                }

                System.out.print(sb.toString());
            }
            System.out.println(white); // Reset to white at the end of each row
        }
    }
}