package Building;

import java.util.LinkedList;
import java.util.List;

public class Floor {
    public final byte level;
    public int numberOfPas;
    private boolean upButton;
    private boolean downButton;
    public final Building build;
    public final List<Passenger> passengers = new LinkedList<>();

    public Floor(Building b, byte floorNum, byte numbOfPas) {
        build = b;
        level = floorNum;
        numberOfPas = numbOfPas;
        for (int i = 0; i < numbOfPas; i++) {
            passengers.add(new Passenger(level, generateDesiredFloor()));
        }
    }
    public boolean isUpButton() {
        return upButton;
    }

    public void setUpButton(boolean upButton) {
        this.upButton = upButton;
    }

    public boolean isDownButton() {
        return downButton;
    }

    public void setDownButton(boolean downButton) {
        this.downButton = downButton;
    }

    public void addPassenger(Passenger passenger) {
        if(passenger != null) {
        passengers.add(passenger);
        passenger.changeCurrentFloor(level);
        passenger.changeDesiredFloor(generateDesiredFloor());
        numberOfPas++;}
    }

    private byte generateDesiredFloor() {
        byte dF;
        do {
            dF = (byte)(Math.random()*build.floors.length+1);
        }
        while (dF == level);
        return dF;
    }

    public String showPassengers() {
        StringBuilder sP = new StringBuilder();
        for(Passenger passenger : passengers) {
            sP.append(passenger.toString()).append("\n");
        }
        return sP.toString();
    }


    @Override
    public String toString() {
        switch(numberOfPas) {
            case 0: return "The " + level + " floor has no passengers.";
            case 1: return "The " + level + " floor has 1 passenger.";
            default:
                return "The " + level +
                        " floor has " + numberOfPas +
                        " passengers.";
        }


    }
}
