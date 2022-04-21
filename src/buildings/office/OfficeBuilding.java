package buildings.office;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;

import java.util.ArrayList;
import java.util.List;

public class OfficeBuilding {
    private List<OfficeFloor> officeFloorList;

    public OfficeBuilding(List<OfficeFloor> floors) {
        officeFloorList = floors;
    }

    public OfficeBuilding(int floorsAmount, int[] officesAmount)
    {
        officeFloorList = new ArrayList<>();
        for (int i = 0; i < floorsAmount; i++) {
            officeFloorList.add(new OfficeFloor(officesAmount[i]));
        }
    }

    public OfficeBuilding(OfficeFloor[] officeFloors){
        officeFloorList = new ArrayList<>();
        for (int i = 0; i < officeFloors.length; i++) {
            officeFloorList.add(officeFloors[i]);
        }
    }
    public int getFloorsAmount(){
        return officeFloorList.size();
    }

    public int getSpacesAmount(){
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getSpacesAmount();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getRoomsAmount();
        }
        return sum;
    }

    public int getSquareAmount(){
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getSquareAmount();
        }
        return sum;
    }

    public OfficeFloor[] getFloors(){
        OfficeFloor[] officeFloors = new OfficeFloor[officeFloorList.size()];
        for (int i = 0; i < officeFloors.length ; i++) {
            officeFloors[i] = officeFloorList.get(i);
        }
        return officeFloors;
    }

    public Office getSpace(int num){
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        return officeFloorList.get(i).getSpace(num);
    }

    public OfficeFloor getFloor(int num){
        if (num > this.getSpacesAmount())
        {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        return officeFloorList.get(num);
    }

    public void setSpace(int num, Office newone){
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        officeFloorList.get(i).setSpace(num, newone);
    }

    public void setFloor(int num, OfficeFloor newone){
        if (num > this.getSpacesAmount())
        {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        officeFloorList.set(num, newone);
    }

    public void deleteSpace(int num){
        int i = 0;
        if (num > this.getSpacesAmount())
        {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        officeFloorList.get(i).deleteSpace(num);
    }

    public Office getBestSpace(){
        Office Best = officeFloorList.get(0).getBestSpace();
        for (int i = 1; i < officeFloorList.size(); i++) {
                if (Best.getSquare() <= officeFloorList.get(i).getBestSpace().getSquare())
                {
                    Best = officeFloorList.get(i).getBestSpace();
                }
        }
        return Best;
    }


}
