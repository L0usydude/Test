package buildings.dwelling;

import buildings.exceptions.SpaceIndexOutOfBoundsException;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
    }

    public DwellingFloor(int size) {
        flats = new Flat[size];
        for (int i = 0; i < size; i++) {
            flats[i] = new Flat();
        }
    }

    public int getSpacesAmount(){
        return flats.length;
    }

    public double getSquareAmount(){
        double sum = 0;
        for (Flat flat : flats) {
            sum += flat.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (Flat flat : flats) {
            sum += flat.getRooms();
        }
        return sum;
    }

    public Flat[] getSpaces() {
        return flats;
    }

    public Flat getSpace(int num){
        if (num > flats.length)
        {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        return flats[num];
    }

    public void setSpace(int num, Flat newFlat){
        if (num > flats.length)
        {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        this.flats[num] = newFlat;
    }

    public void addSpace(int num, Flat newFlat){
        if (num > flats.length)
        {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        Flat[] newFlats = new Flat[flats.length+1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        newFlats[num] = newFlat;
        for (int i = num+1; i <newFlats.length; i++) {
            newFlats[i] = flats[i-1];
        }
        flats = newFlats;
    }

    public void deleteSpace(int num){
        if (num > flats.length)
        {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        Flat[] newFlats = new Flat[flats.length-1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        for (int i = num; i < newFlats.length ; i++) {
            newFlats[i] = flats[i+1];
        }
        flats = newFlats;
    }

    public Flat getBestSpace()
    {
        Flat flat = flats[0];
        for (int i = 1; i <flats.length; i++) {
            if (flat.getSquare() < flats[i].getSquare())
            {
                flat = flats[i];
            }
        }
        return flat;
    }
}
