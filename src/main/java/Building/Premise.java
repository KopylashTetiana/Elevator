package Building;

import java.util.List;

public abstract class Premise {
    private int level;
    public List<Passenger> passengers;
    public Building build;

    public Premise(Building b, int level) {
        build = b;
        this.level = level;
    }


    public int getLevel() {
        return level;
    }


}
