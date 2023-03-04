package Building;


public class Passenger {
    private int desiredFloor;

    public Passenger(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void setDesiredFloor(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    @Override
    public String toString() {
        if (desiredFloor < 10)
            return "__" + desiredFloor;
        else
            return "_" + desiredFloor;
    }
}
