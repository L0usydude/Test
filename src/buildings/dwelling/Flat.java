package buildings.dwelling;

import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Space;

public class Flat implements Space {
    private double square;
    private int rooms;

    private final double SQUARE_VALUE = 50;
    private final int ROOMS_VALUE = 2;

    public Flat() {
        square = SQUARE_VALUE;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square) {
        if (square > 200){
            throw new InvalidSpaceAreaException(square, 200);
        }
        this.square = square;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square, int rooms) {
        if (square > 200){
            throw new InvalidSpaceAreaException(square, 200);
        }
        if (rooms > 10){
            throw new InvalidRoomsCountException(rooms, 10);
        }
        this.rooms = rooms;
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        if (square > 200){
            throw new InvalidSpaceAreaException(square, 200);
        }
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms > 10){
            throw new InvalidRoomsCountException(rooms, 10);
        }
        this.rooms = rooms;
    }
}
