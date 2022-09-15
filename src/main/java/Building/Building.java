package Building;

public class Building {
    private final int numbOfFloors;
    private final Floor[] floors;

    public Building(int n) {
        numbOfFloors = n;
        floors = new Floor[n];
        for(int i = 0; i < n; i++) {
            floors[i] = new Floor(this, i+1, n);
        }
    }
    public Building(int n, int k) {
        numbOfFloors = n;
        floors = new Floor[n];
        for(int i = 0; i < n; i++) {
            floors[i] = new Floor(this, i+1, k);
        }
    }
    public Building(int fromFloors, int toFloors, int fromPassengers, int toPassengers) {
        numbOfFloors = generateN(fromFloors, toFloors);
        floors = new Floor[numbOfFloors];
        for(int i = 0; i < numbOfFloors; i++) {
            floors[i] = new Floor(this, i+1, generateN(fromPassengers, toPassengers));
            //floors[i].createPassengers();
        }
    }

    public static int generateN(int fromNumber, int toNumber) {
        return (int)(Math.random()*(toNumber - fromNumber)+fromNumber);
    }

    public int getNumbOfFloors() {
        return numbOfFloors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public String showFloors() {
        String sF = "";
        for(Floor floor : floors) {
            sF += floor.toString() + "\n" +
            floor.showPassengers() + "\n";
        }
        return sF;
    }

//    public void setFloors(Floor[] floors) {
//        this.floors = floors;
//    }

    @Override
    public String toString() {
        return "The building has " + numbOfFloors + " floors.";
    }
}
