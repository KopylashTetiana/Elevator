import Building.Building;

public class Main {

    public static void main(String[] args) {

        Building b1 = new Building();
        System.out.println(b1);
        b1.callElevator();
        b1.callElevator(20);

    }


}
