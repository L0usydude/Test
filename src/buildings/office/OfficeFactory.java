package buildings.office;

import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class OfficeFactory implements BuildingFactory {
    @Override
    public Space createSpace(double square) {
        return new Office(square);
    }

    @Override
    public Space createSpace(double square, int rooms) {
        return new Office(square,rooms);
    }

    @Override
    public Floor createFloor(int count) {
        return new OfficeFloor(count);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new OfficeFloor(spaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new OfficeBuilding(floors);
    }

    @Override
    public Building createBuilding(int floorsAmount, int[] officesAmount) {
        return new OfficeBuilding(floorsAmount,officesAmount);
    }

    @Override
    public Building createBuilding(int floorsamount) {
        return new OfficeBuilding(floorsamount);
    }
}
