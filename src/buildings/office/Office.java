package buildings.office;

import buildings.interfaces.Space;

import java.io.Serializable;

public class Office implements Space, Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office office = (Office) o;

        if (Double.compare(office.square, square) != 0) return false;
        return rooms == office.rooms;
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
        return "Office{" +
                "square=" + square +
                ", rooms=" + rooms +
                '}';
    }

    @Override
    public Object clone() {
        return new Office(this.getSquare(), this.getRooms());
    }

    @Override
    public int compareTo(Space o) {
        return Double.compare(o.getSquare(), this.getSquare());
    }
}
