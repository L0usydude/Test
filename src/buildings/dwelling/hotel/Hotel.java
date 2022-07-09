package buildings.dwelling.hotel;

import buildings.dwelling.Dwelling;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class Hotel extends Dwelling {

    private int maxStars;

    public Hotel(int floorsAmount, int... flatsAmount) {
        super(floorsAmount, flatsAmount);
    }

    public Hotel(int floorsAmount) {
        super(floorsAmount);
    }

    public Hotel(Floor[] floors) {
        super(floors);
    }

    public int getMaxStars() {
        maxStars = 1;
        for (int i = 0; i < getFloorsAmount(); i++){
            if (maxStars < ((HotelFloor) getFloor(i)).getStars() && getFloor(i).getClass() == HotelFloor.class){
                maxStars = ((HotelFloor) getFloor(i)).getStars();
            }
        }
        return maxStars;
    }
    public double getK(int counter){
        if (counter == 1){
            return 0.25;
        }
        else if (counter == 2){
            return 0.5;
        }
        else if (counter == 3){
            return 1;
        }
        else if (counter == 4){
            return 1.25;
        }
        else {
            return 1.5;
        }
    }

    @Override
    public Space getBestSpace() {
        int index = 0;
        double tmp = getFloor(0).getSquareAmount() * getK(((HotelFloor) getFloor(0)).getStars());
        for (int i = 1; i < getFloorsAmount(); i++) {
            if (tmp < getFloor(i).getSquareAmount() * getK(((HotelFloor) getFloor(i)).getStars())){
                tmp = getFloor(i).getSquareAmount() * getK(((HotelFloor) getFloor(i)).getStars());
                index = i;
            }
        }
        return getFloor(index).getBestSpace();
    }
}
