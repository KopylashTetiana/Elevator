package Building;


public class Passenger {
    byte desiredFloor;
    int currentFloor;

    public Passenger(int currentFl, byte desiredFl) {
        currentFloor = currentFl;
        desiredFloor = desiredFl;
    }

    public byte getDesiredFloor() {
        return desiredFloor;
    }

    @Override
    public String toString() {
        return "Passenger from " + currentFloor +
                " floor is going to " + desiredFloor +
                " floor.";
    }
}
