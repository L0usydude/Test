package buildings.interfaces;

public interface Space extends Comparable<Space> {
    double getSquare();

    int getRooms();

    void setRooms(int rooms);

    void setSquare(double square);
}
