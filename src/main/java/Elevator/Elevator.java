package Elevator;

import Building.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Elevator extends Premise implements Transport {
    private int requiredFloor;
    private static final int capacity = 5;

    private boolean liftingUp = true;
    List<Passenger> passengers = new ArrayList<>();
    private int level;
    public final Building build;

    public Elevator(Building b, int level) {
        super(b, level);
        build = b;
        this.level = level;
    }

    public void callElevator(Floor fl) {
        if (!fl.isUpButton()) {
            for (int i = 0; i < fl.getPassengers().size(); i++) {
                if ((fl.getPassengers().get(i).getDesiredFloor() > fl.getLevel())) {
                    fl.setUpButton(true);
                    break;
                }
            }
        }
        if (!fl.isDownButton()) {
            for (int i = 0; i < fl.getPassengers().size(); i++) {
                if ((fl.getPassengers().get(i).getDesiredFloor() < fl.getLevel())) {
                    fl.setDownButton(true);
                    break;
                }
            }
        }
    }

    public void go() {
        System.out.println("The elevator is on.");
        callElevator(build.getFloors()[level]);
        if (liftingUp) {
            for (; level < requiredFloor; level++) {
                letOffPass();
                letInPass();
            }
            liftingUp = false;
        } else {
            for (; level > requiredFloor; level--) {
                letOffPass();
                letInPass();
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
            Passenger p;
            ListIterator<Passenger> passengersLT = build.getFloors()[level].getPassengers().listIterator();
            while(passengersLT.hasNext() && capacity > passengers.size()) {
                p = passengersLT.next();
                if(liftingUp == ((p.getDesiredFloor() - level) > 0)) {
                passengersLT.remove();
                build.getFloors()[level].changeNumberOfPas(-1);
                p.changePremise(this);
                passengers.add(p);
                }
            }
        }
    }

    public int getLevel() {
        return level;
    }
}
