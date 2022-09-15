package Building;


import java.util.Locale;

public class Passenger {
    private int desiredFloor;
    private Premise currentPremise;


    public Passenger(Premise pr) {
        currentPremise = pr;
        generateDesiredFloor();
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void generateDesiredFloor() {
        do {
            desiredFloor = Building.generateN(1, currentPremise.build.getNumbOfFloors());
        }
        while (desiredFloor == currentPremise.getLevel());
    }


    public void changePremise(Premise p) {
        currentPremise = p;
        }

    @Override
    public String toString() {
        return "Passenger from " + currentPremise.getLevel() +
                " floor is going to " + desiredFloor +
                " floor.";
    }
}
