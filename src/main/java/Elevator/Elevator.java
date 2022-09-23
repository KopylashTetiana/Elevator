package Elevator;

import Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Elevator {
    public static final byte capacity = 5;
    private boolean liftingUp = true;
    List<Passenger> passengers = new ArrayList<>();
    boolean [] stops;
    private byte level = 1;
    static int counter;

    public Elevator(int levels) {
        System.out.println("The elevator is on.");
        stops = new boolean[levels];
    }

    private void checkFloor(Floor fl) {
        if (!stops[fl.level - 1]) {
            for (Passenger passenger : fl.passengers) {
                if (liftingUp == passenger.getDesiredFloor() > fl.level) {
                    stops[fl.level - 1] = true;
                    break;
                }
            }
        }
    }

    public void go(Building b) {
        if(liftingUp) {
                for (; level < stops.length; level++) {
                    if(passengers.size() < capacity) {
                        checkFloor(b.floors[level - 1]);
                    }
                    if(stops[level-1]) {
                        letOffPass(b);
                        letInPass(b);
                        System.out.println("   *** Step " + (++counter) + " ***");
                        System.out.println(b);
                    }
                    stops[level-1] = false;
                }
                liftingUp = false;
            }
        for (; level > 1; level--) {
            if(passengers.size() < capacity) {
                checkFloor(b.floors[level - 1]);
            }
            if(stops[level-1]) {
            letOffPass(b);
            letInPass(b);
            System.out.println("   *** Step " + (++counter) + " ***");
            System.out.println(b);
            }
            stops[level-1] = false;
        }
        liftingUp = true;
    }

    public void letOffPass(Building b) {
        for (byte i = 0; i < passengers.size(); ) {
            if (passengers.get(i).getDesiredFloor() == level) {
                b.floors[level-1].addPassenger(passengers.remove(i));
            } else i++;
        }
    }

    public void letInPass(Building b) {
        if (b.floors[level-1].numberOfPas > 0) {
            ListIterator<Passenger> passLT = b.floors[level-1].passengers.listIterator();
            Passenger p;
            while(passLT.hasNext() && capacity > passengers.size()) {
                p = passLT.next();
                if(liftingUp == (p.getDesiredFloor() > level)) {
                passLT.remove();
                b.floors[level-1].numberOfPas -= 1;
                passengers.add(p);
                stops[p.getDesiredFloor()-1] = true;
                }
            }
        }
    }
    public byte getLevel() {
        return level;
    }

    @Override
    public String toString() {
        char c = (liftingUp)? '^' : 'v';
        StringBuilder sB = new StringBuilder();
        sB.append(c);
        for (byte i = 0; i < capacity; i++) {
            if (i < passengers.size()) {
                sB.append((passengers.get(i).getDesiredFloor() > 9) ? '_' : "__");
                sB.append(passengers.get(i).getDesiredFloor());
            } else {
                sB.append("___");
            }
        }
        sB.append(c);
        return sB.toString();
    }
}
