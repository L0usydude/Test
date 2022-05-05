import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.exceptions.InvalidSpaceAreaException;
import buildings.interfaces.Floor;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import buildings.utils.PlacementExchanger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        try{
//            List<Office> offices = new ArrayList<>();
//            Office abc1 = new Office(70, 4);
//            Office abc2 = new Office(65, 3);
//            Office abc3 = new Office(20, 1);
//            Office abc4 = new Office(40, 2);
//            Office abc5 = new Office(50, 7);
//            offices.add(abc1);
//            offices.add(abc2);
//            offices.add(abc3);
//            offices.add(abc4);
//            offices.add(abc5);
//            OfficeFloor Floor = new OfficeFloor(offices);
            Flat a2 = new Flat(20);
            Flat a1 = new Flat(15);
            Flat[] a = new Flat[2];
            a[0] = a2;
            a[1] = a1;
            //            OfficeFloor Floor = new OfficeFloor(offices);
            Flat a4 = new Flat(20);
            Flat a3 = new Flat(15);
            Flat[] aa = new Flat[2];
            aa[0] = a3;
            aa[1] = a4;
            DwellingFloor f1 = new DwellingFloor(a);
            DwellingFloor f2 = new DwellingFloor(aa);
            DwellingFloor[] ff1 = new DwellingFloor[1];
            ff1[0] = f1;

            DwellingFloor[] ff2 = new DwellingFloor[1];
            ff2[0] = f2;
            Dwelling d1 = new Dwelling(ff1);
            Dwelling d2 = new Dwelling(ff2);
            PlacementExchanger.FloorExchanger(d1,d2,0,0);
            PlacementExchanger.SpaceExchanger(f1,f2, 0,0);
            int tmppp = 2;
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }


    }



}
