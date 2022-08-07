package buildings.interfaces;

public interface Floor extends Iterable<Space>, Comparable<Floor>{
    int getSpacesAmount();

    double getSquareAmount();

    int getRoomsAmount();

    Space[] getSpaces();

    Space getSpace(int num);

    void setSpace(int num, Space space);

    void addSpace(int num, Space newSpace);

    void deleteSpace(int num);

    Space getBestSpace();


}
