package Building;


public class Passenger {
    private int desiredFloor;
    private int currentFloor;

    public Passenger(int currentFl, int desiredFl) {
        currentFloor = currentFl;
        desiredFloor = desiredFl;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void changeCurrentFloor(int floor) {
        currentFloor = floor;
        }

    public void changeDesiredFloor(int floor) {
        desiredFloor = floor;
    }

    @Override
    public String toString() {
        return "Passenger from " + currentFloor +
                " floor is going to " + desiredFloor +
                " floor.";
    }
}
