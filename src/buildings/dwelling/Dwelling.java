package buildings.dwelling;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.OfficeFloor;

public class Dwelling implements Building {
    private Floor[] floors;

    public Dwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }

    public Dwelling(int floorsAmount, int... flatsAmount)
    {
        if (flatsAmount.length != floorsAmount)
        {
            System.out.println("Error");
        }
        floors = new DwellingFloor[floorsAmount];
        for (int i = 0; i < floorsAmount; i++) {
            floors[i] = new DwellingFloor(flatsAmount[i]);
        }
    }

    public Dwelling(int floorsAmount)
    {
        floors = new DwellingFloor[floorsAmount];
        for (int i = 0; i < floorsAmount; i++) {
            floors[i] = new DwellingFloor(0);
        }
    }

    public int getFloorsAmount(){
        return floors.length;
    }

    public int getSpacesAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getSpacesAmount();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getRoomsAmount();
        }
        return sum;
    }

    public int getSquareAmount(){
        int sum = 0;
        for (int i = 0; i < floors.length; i++) {
            sum += floors[i].getSquareAmount();
        }
        return sum;
    }

    public Floor[] getFloors() {
        Floor[] officeFloors = new OfficeFloor[floors.length];
        for (int i = 0; i < floors.length ; i++) {
            officeFloors[i] = floors[i];
        }
        return officeFloors;
    }

    public Floor getFloor(int num) {
        if (num > this.getSpacesAmount())
        {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        return floors[num];
    }

    public void setFloor(int num, Floor newFloor) {
        if (num > this.getSpacesAmount())
        {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        floors[num] = newFloor;
    }

    public Space getSpace(int num) {
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < floors.length && num > floors[i].getSpacesAmount(); i++) {
            num -= floors[i].getSpacesAmount();
        }
        return floors[i].getSpace(num);
    }

    public void setSpace(int num, Space newSpace) {
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < floors.length && num > floors[i].getSpacesAmount(); i++) {
            num -= floors[i].getSpacesAmount();
        }
        floors[i].setSpace(num, newSpace);
    }

    public void deleteSpace(int num) {
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < floors.length && num > floors[i].getSpacesAmount(); i++) {
            num -= floors[i].getSpacesAmount();
        }
        floors[i].deleteSpace(num);
    }

    public Space getBestSpace() {
        Space Best = floors[0].getBestSpace();
        for (int i = 1; i < floors.length; i++) {
            if (Best.getSquare() <= floors[i].getBestSpace().getSquare())
            {
                Best = floors[i].getBestSpace();
            }
        }
        return Best;
    }


}
