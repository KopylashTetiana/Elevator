package Elevator;

import Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Elevator {
    static final byte PASSENGER_CAPACITY = 5;
    private boolean liftingUp = true;
    List<Passenger> passengers = new ArrayList<>();
    boolean [] stops;
    private byte currentFloor = 1;
    static int counter;

    public Elevator(int levels) {
        System.out.println("The elevator is on.");
        stops = new boolean[levels];
    }

    private void checkFloor(Building b) {
        if(passengers.size() < PASSENGER_CAPACITY) {
            if (!stops[currentFloor - 1]) {
                for (Passenger passenger : b.floors[currentFloor - 1].passengers) {
                    if (liftingUp == passenger.getDesiredFloor() > currentFloor) {
                        stops[currentFloor - 1] = true;
                        break;
                    }
                }
            }
        }
    }

    public void letOffPass(Building b) {
        for (byte i = 0; i < passengers.size(); ) {
            if (passengers.get(i).getDesiredFloor() == currentFloor) {
                b.floors[currentFloor -1].addPassenger(passengers.remove(i));
            } else i++;
        }
    }

    public void letInPass(Building b) {
        if (b.floors[currentFloor -1].numberOfPas > 0) {
            ListIterator<Passenger> passLT = b.floors[currentFloor -1].passengers.listIterator();
            Passenger p;
            while(passLT.hasNext() && PASSENGER_CAPACITY > passengers.size()) {
                p = passLT.next();
                if(liftingUp == (p.getDesiredFloor() > currentFloor)) {
                    passLT.remove();
                    b.floors[currentFloor -1].numberOfPas -= 1;
                    passengers.add(p);
                    stops[p.getDesiredFloor()-1] = true;
                }
            }
        }
    }

    public void elCycle(Building b) {
        checkFloor(b);
        if(stops[currentFloor - 1]) {
            letOffPass(b);
            letInPass(b);
            System.out.println("   *** Step " + (++counter) + " ***");
            System.out.println(b);
        }
        stops[currentFloor -1] = false;
    }

    public void go(Building b) {
        if(liftingUp) {
                for (; currentFloor < stops.length; currentFloor++) {
                    elCycle(b);
                }
                liftingUp = false;
            }
        for (; currentFloor > 1; currentFloor--) {
            elCycle(b);
        }
        liftingUp = true;
    }

    public byte getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public String toString() {
        char c = (liftingUp)? '^' : 'v';
        StringBuilder sB = new StringBuilder();
        sB.append(c);
        for (byte i = 0; i < PASSENGER_CAPACITY; i++) {
            if (i < passengers.size()) {
                sB.append(passengers.get(i));
            } else {
                sB.append("___");
            }
        }
        sB.append(c);
        return sB.toString();
    }
}
