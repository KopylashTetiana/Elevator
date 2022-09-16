package Building;

public class Building {
    public final Floor[] floors = new Floor[(int)(Math.random()*16+5)];

    public Building() {
        for(int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(this, i+1, (int)(Math.random()*11));
        }
    }

    public static int generateN(int fromNumber, int toNumber) {
        return (int)(Math.random()*(toNumber - fromNumber)+fromNumber);
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

    @Override
    public String toString() {
        return "The building has " + floors.length + " floors.";
    }
}
