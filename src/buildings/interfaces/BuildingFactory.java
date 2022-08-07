package buildings.interfaces;

public interface BuildingFactory {
    Space createSpace(double square);
    Space createSpace(double square, int rooms);
    Floor createFloor(int count);
    Floor createFloor(Space[] spaces);
    Building createBuilding(Floor[] floors);
    Building createBuilding(int floorsAmount, int officesAmount);
}
