package Building;


public class Passenger {
    private byte desiredFloor;
    private int currentFloor;

    public Passenger(int currentFl, byte desiredFl) {
        currentFloor = currentFl;
        desiredFloor = desiredFl;
    }

    public byte getDesiredFloor() {
        return desiredFloor;
    }

    public void changeCurrentFloor(byte floor) {
        currentFloor = floor;
        }

    public void changeDesiredFloor(byte floor) {
        desiredFloor = floor;
    }

    @Override
    public String toString() {
        return "Passenger from " + currentFloor +
                " floor is going to " + desiredFloor +
                " floor.";
    }
}
