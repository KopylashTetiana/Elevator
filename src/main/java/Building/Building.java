package Building;

import Elevator.Elevator;

public class Building {
    public final Floor[] floors = new Floor[(byte)(Math.random()*16+5)];
    public Elevator elevator;

    public Building() {
        for(byte i = 0; i < floors.length; i++) {
            floors[i] = new Floor(this, (byte) (i+1), (byte)(Math.random()*11));
        }
        elevator = new Elevator(floors.length);
    }
    public void callElevator() {
        elevator.go(this);
        System.out.println("The elevator stopped on the first floor:");
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("_".repeat(83)).append("\n");
        for (int i = floors.length; i > 0; i--) {
            sB.append("|");
            if (i > 9) {
                sB.append(i);
            } else {
                sB.append(' ').append(i);
            }
            sB.append('|');
            if(i == elevator.getLevel()) {
                sB.append(elevator).append('|');
            } else {
                sB.append("                 |");
            }
            for (Passenger p : floors[i - 1].passengers) {
                sB.append((p.getDesiredFloor() > 9) ? ' ' : "  ");
                sB.append(p.getDesiredFloor());
            }
            sB.append("   ".repeat(Math.max(0, 20 - floors[i - 1].numberOfPas)));
            sB.append("|\n");
        }
        sB.append("_".repeat(83)).append("\n");
        return sB.toString();
    }
}
