import Building.Building;
import Elevator.Elevator;

public class Main {

    public static void main(String[] args) {

       Building b1 = new Building(5, 20, 0, 10);
        System.out.println(b1);
        System.out.println(b1.showFloors());
        Elevator el1 = new Elevator(b1);
        el1.go();


    }



}