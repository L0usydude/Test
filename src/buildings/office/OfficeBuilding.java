package buildings.office;

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
}
