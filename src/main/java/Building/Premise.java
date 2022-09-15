package Building;

import java.util.List;

public abstract class Premise {
    private int level;
    public List<Passenger> passengers;
    public Building build;

    public int getLevel() {
        return level;
    }

}
