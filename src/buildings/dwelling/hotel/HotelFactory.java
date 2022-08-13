package buildings.dwelling.hotel;

import buildings.dwelling.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class HotelFactory implements BuildingFactory {
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
        return new HotelFloor(count);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }

    @Override
    public Building createBuilding(int floorsAmount, int[] officesAmount) {
        return new Hotel(floorsAmount,officesAmount);
    }

    @Override
    public Building createBuilding(int floorsamount) {
        return new Hotel(floorsamount);
    }
}