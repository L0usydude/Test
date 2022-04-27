import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        List<Office> offices = new ArrayList<>();
        Office abc1 = new Office(70, 4);
        Office abc2 = new Office(65, 3);
        Office abc3 = new Office(20, 1);
        Office abc4 = new Office(40, 2);
        Office abc5 = new Office(50, 7);
        offices.add(abc1);
        offices.add(abc2);
        offices.add(abc3);
        offices.add(abc4);
        offices.add(abc5);
        OfficeFloor Floor = new OfficeFloor(offices);

    }



}
