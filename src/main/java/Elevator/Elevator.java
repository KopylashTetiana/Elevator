package Elevator;

import Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Elevator {
    private byte requiredFloor = 1;
    public static final byte capacity = 5;

    private boolean liftingUp = true;
    List<Passenger> passengers = new ArrayList<>();
    public byte level = 1;
    public final Building build;

    public Elevator(Building b) {
        build = b;
        System.out.println("The elevator is on.");
    }

    private void callElevator(Floor fl) {
        if (!fl.isUpButton() || !fl.isDownButton()) {
            for (Passenger passenger : fl.passengers) {
                if ((passenger.getDesiredFloor() > fl.level)) {
                    fl.setUpButton(true);
                } else {
                    fl.setDownButton(true);
                }
                if (fl.isUpButton() && fl.isDownButton()) {
                    break;
                }
            }
            if((liftingUp && fl.isUpButton()) || (!liftingUp && fl.isDownButton())) {
                letOffPass();
                letInPass();
                byte d;
                for (byte i = 0; i < passengers.size(); i++) {
                        d = passengers.get(i).getDesiredFloor();
                        if (liftingUp == d > requiredFloor) {
                            requiredFloor = d;
                    }
                }
            }
        }
    }

    public void go() {
        callElevator(build.floors[level-1]);
        if (liftingUp) {
            for (; level < requiredFloor; level++) {
//                callElevator(build.floors[level]);
                letOffPass();
                letInPass();
                System.out.println(this);
            }
            liftingUp = false;
        } else {
            for (; level > requiredFloor; level--) {
//                callElevator(build.floors[level]);
                letOffPass();
                letInPass();
                System.out.println(this);
            }
            liftingUp = true;
        }
    }

    public void letOffPass() {
        for (byte i = 0; i < passengers.size(); ) {
            if (passengers.get(i).getDesiredFloor() == level) {
                build.floors[level-1].addPassenger(passengers.remove(i));
            } else i++;
        }
    }

    public void letInPass() {
        if (capacity > passengers.size()) {
            ListIterator<Passenger> passLT = build.floors[level-1].passengers.listIterator();
            Passenger p;
            while(passLT.hasNext() && capacity > passengers.size()) {
                p = passLT.next();
                if(liftingUp == (p.getDesiredFloor() > level)) {
                passLT.remove();
                build.floors[level-1].numberOfPas -= 1;
                passengers.add(p);
                if((liftingUp) == p.getDesiredFloor() > requiredFloor) {
                    requiredFloor = p.getDesiredFloor();
                    }
                }
            }
        }
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
