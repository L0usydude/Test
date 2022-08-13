package buildings.office;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class OfficeBuilding implements Building, Serializable {
    private List<Floor> officeFloorList;

    public OfficeBuilding(List<Floor> floors) {
        officeFloorList = floors;
    }

    public OfficeBuilding(int floorsAmount, int[] officesAmount) {
        officeFloorList = new ArrayList<>();
        for (int i = 0; i < floorsAmount; i++) {
            officeFloorList.add(new OfficeFloor(officesAmount[i]));
        }
    }

    public OfficeBuilding(Floor[] officeFloors) {
        officeFloorList = new ArrayList<>();
        for (int i = 0; i < officeFloors.length; i++) {
            officeFloorList.add(officeFloors[i]);
        }
    }

    public OfficeBuilding(int floorsAmount){
        officeFloorList = new ArrayList<>();
        for (int i = 0; i < floorsAmount; i++){
            officeFloorList.add(new OfficeFloor());
        };
    }

    public int getFloorsAmount() {
        return officeFloorList.size();
    }

    public int getSpacesAmount() {
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getSpacesAmount();
        }
        return sum;
    }

    public int getRoomsAmount() {
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getRoomsAmount();
        }
        return sum;
    }

    public int getSquareAmount() {
        int sum = 0;
        for (int i = 0; i < officeFloorList.size(); i++) {
            sum += officeFloorList.get(i).getSquareAmount();
        }
        return sum;
    }

    public Floor[] getFloors() {
        Floor[] officeFloors = new OfficeFloor[officeFloorList.size()];
        for (int i = 0; i < officeFloors.length; i++) {
            officeFloors[i] = officeFloorList.get(i);
        }
        return officeFloors;
    }

    public Space getSpace(int num) {
        int i = 0;
        if (num > this.getSpacesAmount()) {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        return officeFloorList.get(i).getSpace(num);
    }

    public Floor getFloor(int num) {
        if (num > this.getSpacesAmount()) {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        return officeFloorList.get(num);
    }

    public void setSpace(int num, Space newone) {
        int i = 0;
        if (num > this.getSpacesAmount()) {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        officeFloorList.get(i).setSpace(num, newone);
    }

    public void setFloor(int num, Floor newone) {
        if (num > this.getSpacesAmount()) {
            throw new FloorIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        officeFloorList.set(num, newone);
    }

    public void deleteSpace(int num) {
        int i = 0;
        if (num > this.getSpacesAmount()) {
            throw new SpaceIndexOutOfBoundsException(num, this.getSpacesAmount());
        }
        for (i = 0; i < officeFloorList.size() && num > officeFloorList.get(i).getSpacesAmount(); i++) {
            num -= officeFloorList.get(i).getSpacesAmount();
        }
        officeFloorList.get(i).deleteSpace(num);
    }

    public Space getBestSpace() {
        Space Best = officeFloorList.get(0).getBestSpace();
        for (int i = 1; i < officeFloorList.size(); i++) {
            if (Best.getSquare() <= officeFloorList.get(i).getBestSpace().getSquare()) {
                Best = officeFloorList.get(i).getBestSpace();
            }
        }
        return Best;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeBuilding that = (OfficeBuilding) o;

        return officeFloorList != null ? officeFloorList.equals(that.officeFloorList) : that.officeFloorList == null;
    }

    @Override
    public int hashCode() {
        return officeFloorList != null ? officeFloorList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OfficeBuilding{" +
                "officeFloorList=" + officeFloorList +
                '}';
    }

    @Override
    public Object clone() {
        List<Floor> sth = new ArrayList<>();
        for (var i : officeFloorList) {
            sth.add((Floor) ((OfficeFloor) i).clone());
        }
        return new OfficeBuilding(sth);
    }
}
