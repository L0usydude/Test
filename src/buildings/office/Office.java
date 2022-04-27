package buildings.office;

import buildings.interfaces.Space;

public class Office implements Space {
    private double square;
    private int rooms;

    private final double SQUARE_VALUE = 250;
    private final int ROOMS_VALUE = 1;

    public Office() {
        square = SQUARE_VALUE;
        rooms = ROOMS_VALUE;
    }

    public Office(double square) {
        this.square = square;
        rooms = ROOMS_VALUE;
    }

    public Office(double square, int rooms) {
        this.rooms = rooms;
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
