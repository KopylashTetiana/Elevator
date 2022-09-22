import Building.Building;
import Elevator.Elevator;

public class Main {

    public static void main(String[] args) {

        Building b1 = new Building();
        System.out.println(b1);
        //for(int i = 0; i < 20; i++) {
            b1.elevator.go();
        //}
    }



}
