package Plant;

import Creature.*;
import Zombies.*;
import MapGame.*;
import Koordinat.*;

public class PlantFactory {
    public static Plant createPlant(String plantName, int x, int y) {
        switch (plantName) {
            case "Sunflower":
                return new Sunflower(x, y);
            case "Repeater":
                return new Repeater(x, y);
            case "Snow Pea":
                return new SnowPea(x, y);
            case "Lilypad":
                return new Lilypad(x, y);
            case "Wallnut":
                return new Wallnut(x, y);
            case "Peashooter":
                return new Peashooter(x, y);
            case "Squash":
                return new Squash(x, y);
            case "Cherry Bomb":
                return new CherryBomb(x, y);
            case "Cabbage Pult":
                return new CabbagePult(x, y);
            case "Tangle Kelp":
                return new TangleKelp(x, y);
            default:
                throw new IllegalArgumentException("Invalid plant name: " + plantName);
        }
    }
}
