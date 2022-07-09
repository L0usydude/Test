package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import buildings.interfaces.Space;

public class HotelFloor extends DwellingFloor {

    private int stars;

    private static final int STARS = 5;

    public HotelFloor(Space[] flats) {
        super(flats);
    }

    public HotelFloor(int size, int stars) {
        super(size);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }


}
