package Building;

import Elevator.Elevator;

import java.util.Random;

public class Building {
    final Random random = new Random();
    public final Floor[] floors = new Floor[(byte) (random.nextInt(16) + 5)];
    public Elevator elevator;

    public Building() {
        for (byte i = 0; i < floors.length; i++) {
            floors[i] = new Floor(this, (byte) (i + 1), (byte) random.nextInt(11));
        }
        elevator = new Elevator(floors.length);
    }

    public void callElevator() {
        elevator.go(this);
        System.out.println("The elevator stopped on the first floor:");
        System.out.println(this);
    }

    public void callElevator(int iterations) {
        for (int i = 0; i < iterations; i++) {
            callElevator();
        }
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("_".repeat(83)).append("\n");
        for (int i = floors.length; i > 0; i--) {
            sB.append('|');
            if (i < 10) {
                sB.append(' ');
            }
            sB.append(i).append('|').append((i == elevator.getLevel()) ? (elevator) : (" ".repeat(17))).append('|');
            for (Passenger p : floors[i - 1].passengers) {
                sB.append((p.getDesiredFloor() < 10) ? "  " : " ").append(p.getDesiredFloor());
            }
            sB.append("   ".repeat(Math.max(0, 20 - floors[i - 1].numberOfPas))).append("|\n");
        }
        sB.append("_".repeat(83)).append("\n");
        return sB.toString();
    }
}
