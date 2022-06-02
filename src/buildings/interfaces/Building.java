package buildings.interfaces;

public interface Building {
    int getFloorsAmount();

    int getSpacesAmount();

    int getRoomsAmount();

    int getSquareAmount();

    Floor[] getFloors();

    Floor getFloor(int num);

    void setFloor(int num, Floor newFloor);

    Space getSpace(int num);

    void setSpace(int num, Space newSpace);

    void deleteSpace(int num);

    Space getBestSpace();
}
