public class Flat {
    private double square;
    private int rooms;

    private final double SQUARE_VALUE = 50;
    private final int ROOMS_VALUE = 2;

    public Flat() {
        square = SQUARE_VALUE;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square) {
        this.square = square;
        rooms = ROOMS_VALUE;
    }

    public Flat(double square, int rooms) {
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
