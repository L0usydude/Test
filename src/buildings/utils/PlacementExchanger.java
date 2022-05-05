package buildings.utils;

import buildings.exceptions.InexchangeableFloorsException;
import buildings.exceptions.InexchangeableSpacesException;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class PlacementExchanger{
    public static boolean SpaceExchangeChecker(Space f1, Space f2){
        return f1.getSquare() == f2.getSquare() && f1.getRooms() == f2.getRooms();
    }
    public static boolean FloorExchangeChecker(Floor f1, Floor f2){
        return f1.getSquareAmount() == f2.getSquareAmount() && f1.getRoomsAmount() == f2.getRoomsAmount();
    }
    public static void SpaceExchanger(Floor f1, Floor f2, int i1, int i2){
        if (FloorExchangeChecker(f1, f2)){
            Space tmp1 = f1.getSpace(i1);
            Space tmp2 = f2.getSpace(i2);
            f2.setSpace(i2, tmp1);
            f1.setSpace(i1, tmp2);
        }
        else {
            throw new InexchangeableFloorsException(f1,f2);
        }
    }
    public static void FloorExchanger(Building f1, Building f2, int i1, int i2){
        if (FloorExchangeChecker(f1.getFloor(i1), f2.getFloor(i2))){
            Floor tmp1 = f1.getFloor(i1);
            Floor tmp2 = f2.getFloor(i2);
            f2.setFloor(i2,tmp1);
            f1.setFloor(i1,tmp2);
        }
        else {
            throw new InexchangeableFloorsException(f1.getFloor(i1),f2.getFloor(i2));
        }
    }

}
