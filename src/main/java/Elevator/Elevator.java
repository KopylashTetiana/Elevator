package Elevator;

import Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Elevator implements Transport {
    private int requiredFloor;
    private static final int capacity = 5;

    private boolean liftingUp = true;
    List<Passenger> passengers = new ArrayList<>();
    private int level;
    public final Building build;

    public Elevator(Building b, int level) {
        build = b;
        this.level = level;
    }

    private void callElevator(Floor fl) {
        if (!fl.isUpButton() || !fl.isDownButton()) {
            for (Passenger passenger : fl.getPassengers()) {
                if ((passenger.getDesiredFloor() > fl.getLevel())) {
                    fl.setUpButton(true);
                } else {
                    fl.setDownButton(true);
                }
                if (fl.isUpButton() && fl.isDownButton()) {
                    break;
                }
                if(liftingUp == (requiredFloor - level) > 0) {///////////////////////////
                    }
            }
        }
    }

    public void go() {
        System.out.println("The elevator is on.");
        callElevator(build.getFloors()[level]);
        System.out.println(this);
        if (liftingUp) {
            for (; level < requiredFloor; level++) {
                letOffPass();
                letInPass();
                callElevator(build.getFloors()[level]);
                System.out.println(this);
            }
            liftingUp = false;
        } else {
            for (; level > requiredFloor; level--) {
                letOffPass();
                letInPass();
                callElevator(build.getFloors()[level]);
                System.out.println(this);
            }
            liftingUp = true;
        }
    }

    public void letOffPass() {
        for (int i = 0; i < passengers.size(); ) {
            if (passengers.get(i).getDesiredFloor() == level) {
                build.getFloors()[level].addPassenger(passengers.remove(i));
            } else i++;
        }
    }

    public void letInPass() {
        if ((capacity > passengers.size()) && (liftingUp && build.getFloors()[level].isUpButton()) || build.getFloors()[level].isDownButton()) {
            ListIterator<Passenger> passengersLT = build.getFloors()[level].getPassengers().listIterator();
            Passenger p;
            while(passengersLT.hasNext() && capacity > passengers.size()) {
                p = passengersLT.next();
                if(liftingUp == ((p.getDesiredFloor() - level) > 0)) {
                passengersLT.remove();
                build.getFloors()[level].changeNumberOfPas(-1);
                //p.changeCurrentFloor(level);
                passengers.add(p);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Elevator is going from " + level +
                " floor to " + requiredFloor +
                " floor, liftingUp=" + liftingUp;
    }
}
