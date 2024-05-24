package MapGame;
import Creature.*;
import Zombies.*;
import Plant.*;
import java.util.ArrayList;
import Sun.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Peta {
    private Tile[][] grid;
    private Timer timer;

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
        startCooldownTimer();
    }

    private void startCooldownTimer() {
        timer = new Timer(true); 
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                decrementAllCooldowns();
            }
        }, 0, 1000); // Execute every second
    }

    public void stopCooldownTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }



    public Tile getTile(int row, int col) {
        if (row < 0 || row >= 6 || col < 0 || col >= 11) {
            throw new IllegalArgumentException("Indeks di luar batas matriks");
        }
        return this.grid[row][col];
    }

    public synchronized void plant(Plant toBePlanted,int row, int col) throws Exception {
        Tile tile = this.getTile(row, col);
        if (col <= 0 || col >= 10) {
            throw new Exception("Tile belum ada lilypad sehingga tidak bisa ditanam");
        }
        if (Sun.getSun() < toBePlanted.getCost()) {
            throw new Exception("Tidak cukup matahari untuk membeli tanaman");
        }
        if (toBePlanted.isInCooldown()) {
            throw new Exception("Tanaman " + toBePlanted.getName() + " masih dalam cooldown");
        }

        if (tile.hasPlanted() && !(tile instanceof PoolTile && toBePlanted instanceof Lilypad)) {
            System.out.println("Tile already has a plant.");
            return; // Prevent adding the plant
        }

        if (tile instanceof PoolTile && !tile.hasLilypad() && !(toBePlanted instanceof Lilypad)) {
            System.out.println("Can only plant on top of a Lilypad in PoolTile.");
            return; // Prevent adding the plant
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
        tile.addCreature(toBePlanted);
        toBePlanted.setCooldown();
        Sun.reduceSun(toBePlanted.getCost());
        System.out.println("Planted " + toBePlanted.getName() + " at (" + row + ", " + col + ")");
    }

    public void decrementAllCooldowns() {
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                for (Creature creature : tile.getEntities()) {
                    if (creature instanceof Plant) {
                        ((Plant) creature).decrementCooldown();
                    }
                }
            }
        }
    }

    public List<Plant> getAllPlants() {
        List<Plant> allPlants = new ArrayList<>();
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                for (Creature creature : tile.getEntities()) {
                    if (creature instanceof Plant) {
                        allPlants.add((Plant) creature);
                    }
                }
            }
        }
        return allPlants;
    }

    public void displayMap(boolean command) {
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
                if(command){
                    System.out.print(sb.toString());
                }else{
                    System.out.flush();
                    System.out.print(sb.toString());
                }

            }
            System.out.println(white); // Reset to white at the end of each row
        }
    }
    
    public void removePlant(int row, int col) throws Exception {
        Tile tile = this.getTile(row, col);

        // Find and remove the plant
        Plant plantToRemove = null;
        for (Creature creature : tile.getEntities()) {
            if (creature instanceof Plant) {
                plantToRemove = (Plant) creature;
                break;
            }
        }

        if (plantToRemove != null) {
            tile.removeCreature(plantToRemove);
            System.out.println("Removed " + plantToRemove.getName() + " from (" + row + ", " + col + ")");
        } else {
            throw new Exception("No plant found at the specified location");
        }
    }
}