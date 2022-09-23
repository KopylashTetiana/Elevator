import Building.Building;

public class Main {

    public static void main(String[] args) {

        Building b1 = new Building();
        System.out.println(b1);
        for(int i = 1; i < 20; i++) {
            System.out.println("   *** Step " + i + " ***");
            b1.callElevator();
        }

    }



}
