package Building;

import java.util.LinkedList;
import java.util.List;

public class Floor {
    final byte level;
    public int numberOfPas;
    final Building build;
    public final List<Passenger> passengers = new LinkedList<>();

    public Floor(Building b, byte floorNum, byte numbOfPas) {
        build = b;
        level = floorNum;
        numberOfPas = numbOfPas;
        for (int i = 0; i < numbOfPas; i++) {
            passengers.add(new Passenger(level, generateDesiredFloor()));
        }
    }

    public void addPassenger(Passenger passenger) {
        if (passenger != null) {
            passengers.add(passenger);
            passenger.currentFloor = level;
            passenger.desiredFloor = generateDesiredFloor();
            numberOfPas++;
        }
    }

    private byte generateDesiredFloor() {
        byte dF;
        do {
            dF = (byte) (build.random.nextInt(build.floors.length)+1);
        }
        while (dF == level);
        return dF;
    }

    @Override
    public String toString() {
        switch (numberOfPas) {
            case 0:
                return "The " + level + " floor has no passengers.";
            case 1:
                return "The " + level + " floor has 1 passenger.";
            default:
                return "The " + level +
                        " floor has " + numberOfPas +
                        " passengers.";
        }
    }
}
