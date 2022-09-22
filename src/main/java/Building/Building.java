package Building;

import Elevator.Elevator;

public class Building {
    public final Floor[] floors = new Floor[(byte)(Math.random()*16+5)];
    public Elevator elevator;

    public Building() {
        for(byte i = 0; i < floors.length; i++) {
            floors[i] = new Floor(this, (byte) (i+1), (byte)(Math.random()*11));
        }
        elevator = new Elevator(this);
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("_____________________________________________________\n");
        for (int i = floors.length; i > 0; i--) {
            sB.append("|");
            if (i > 9) {
                sB.append(i);
            } else {
                sB.append(' ').append(i);
            }
            sB.append('|');
            if(i == elevator.level) {
                sB.append(elevator).append('|');
            } else {
                sB.append("                 |");
            }
            for (Passenger p : floors[i - 1].passengers) {
                sB.append((p.getDesiredFloor() > 9) ? ' ' : "  ");
                sB.append(p.getDesiredFloor());
            }
            sB.append("   ".repeat(Math.max(0, 10 - floors[i - 1].numberOfPas)));
            sB.append("|\n");
        }
        sB.append("_____________________________________________________\n");
        return sB.toString();
    }
}
