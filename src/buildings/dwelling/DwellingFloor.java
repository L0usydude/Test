package buildings.dwelling;

import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class DwellingFloor implements Floor, Serializable {
    private Space[] flats;

    public DwellingFloor(Space[] flats) {
        this.flats = flats;
    }

    public DwellingFloor(int size) {
        flats = new Flat[size];
        for (int i = 0; i < size; i++) {
            flats[i] = new Flat();
        }
    }

    public int getSpacesAmount() {
        return flats.length;
    }

    public double getSquareAmount() {
        double sum = 0;
        for (Space flat : flats) {
            sum += flat.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount() {
        int sum = 0;
        for (Space flat : flats) {
            sum += flat.getRooms();
        }
        return sum;
    }

    public Space[] getSpaces() {
        return flats;
    }

    public Space getSpace(int num) {
        if (num > flats.length) {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        return flats[num];
    }

    public void setSpace(int num, Space newFlat) {
        if (num > flats.length) {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        this.flats[num] = newFlat;
    }

    public void addSpace(int num, Space newFlat) {
        if (num > flats.length) {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        Space[] newFlats = new Flat[flats.length + 1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        newFlats[num] = newFlat;
        for (int i = num + 1; i < newFlats.length; i++) {
            newFlats[i] = flats[i - 1];
        }
        flats = newFlats;
    }

    public void deleteSpace(int num) {
        if (num > flats.length) {
            throw new SpaceIndexOutOfBoundsException(num, flats.length);
        }
        Space[] newFlats = new Flat[flats.length - 1];
        for (int i = 0; i < num; i++) {
            newFlats[i] = flats[i];
        }
        for (int i = num; i < newFlats.length; i++) {
            newFlats[i] = flats[i + 1];
        }
        flats = newFlats;
    }

    public Space getBestSpace() {
        Space flat = flats[0];
        for (int i = 1; i < flats.length; i++) {
            if (flat.getSquare() < flats[i].getSquare()) {
                flat = flats[i];
            }
        }
        return flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DwellingFloor that = (DwellingFloor) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(flats, that.flats);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(flats);
    }

    @Override
    public String toString() {
        return "DwellingFloor{" +
                "flats=" + Arrays.toString(flats) +
                '}';
    }

    @Override
    public Object clone() {
        Space[] sth = new Space[flats.length];
        for (int i = 0; i < flats.length; i++) {
            sth[i] = (Space) ((Flat) flats[i]).clone();
        }
        return new DwellingFloor(sth);
    }

    @Override
    public Iterator<Space> iterator() {
        return new Iterator<Space>() {
            int index1 = 0;
            @Override
            public boolean hasNext() {
                return index1 < flats.length;
            }

            @Override
            public Space next() {
                return flats[index1++];
            }
        };
    }


    @Override
    public int compareTo(Floor o) {
        if (this.getSquareAmount() == o.getSquareAmount())
        {
            return 0;
        }
        else if (this.getSquareAmount() < o.getSquareAmount())
        {
            return -1;
        }
        else {
            return 1;
        }
    }
}
