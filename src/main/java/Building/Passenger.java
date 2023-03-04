package Building;


public class Passenger {
    byte desiredFloor;
    int currentFloor;

    public Passenger(int currentFloor, byte desiredFloor) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
    }

    public byte getDesiredFloor() {
        return desiredFloor;
    }

    @Override
    public String toString() {
        if (desiredFloor < 10)
            return "__" + desiredFloor;
        else
            return "_" + desiredFloor;
    }
}
