package buildings.dwelling;

import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class DwellingFactory implements BuildingFactory {


    @Override
    public Space createSpace(double square) {
        return new Flat(square);
    }

    @Override
    public Space createSpace(double square, int rooms) {
        return new Flat(square,rooms);
    }

    @Override
    public Floor createFloor(int count) {
        return new DwellingFloor(count);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }

    @Override
    public Building createBuilding(int floorsAmount, int[] officesAmount) {
        return new Dwelling(floorsAmount, officesAmount);
    }

    @Override
    public Building createBuilding(int floorsamount) {
        return new Dwelling(floorsamount);
    }
}
