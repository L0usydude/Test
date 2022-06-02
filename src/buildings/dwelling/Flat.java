package buildings.dwelling;

import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;
import buildings.interfaces.Space;

import java.io.Serializable;

public class Flat implements Space, Serializable {
    private double square;
    private int rooms;

    private final double SQUARE_VALUE = 50;
    private final int ROOMS_VALUE = 2;

    public Flat() {
        square = SQUARE_VALUE;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square) {
        if (square > 200) {
            throw new InvalidSpaceAreaException(square, 200);
        }
        this.square = square;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square, int rooms) {
        if (square > 200) {
            throw new InvalidSpaceAreaException(square, 200);
        }
        if (rooms > 10) {
            throw new InvalidRoomsCountException(rooms, 10);
        }
        this.rooms = rooms;
        this.square = square;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        if (square > 200) {
            throw new InvalidSpaceAreaException(square, 200);
        }
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms > 10) {
            throw new InvalidRoomsCountException(rooms, 10);
        }
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flat flat = (Flat) o;

        if (Double.compare(flat.square, square) != 0) return false;
        return rooms == flat.rooms;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(square);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + rooms;
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "square=" + square +
                ", rooms=" + rooms +
                '}';
    }

    public Object clone() {
        return new Flat(this.getSquare(), this.getRooms());
    }
}
