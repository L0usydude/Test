package buildings.office;

import buildings.dwelling.Flat;
import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.util.ArrayList;
import java.util.List;

public class OfficeFloor implements Floor {
    private List<Space> officeList;

    public OfficeFloor(List<Space> officeList) {
        this.officeList = officeList;
    }

    public OfficeFloor(int count){
        officeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            officeList.add(new Office());
        }
    }

    public OfficeFloor(Space[] offices){
        officeList = new ArrayList<>();
        for (int i = 0; i < offices.length; i++) {
            officeList.add(offices[i]);
        }
    }

    public int getSpacesAmount(){
        return officeList.size();
    }

    public double getSquareAmount(){
        double sum = 0;
        for (Space office : officeList) {
            sum += office.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (Space office : officeList) {
            sum += office.getRooms();
        }
        return sum;
    }

    public Space[] getSpaces(){
        Space[] offices = new Space[officeList.size()];
        for (int i = 0; i < offices.length; i++) {
            offices[i] = officeList.get(i);
        }
        return offices;
    }

    public Space getSpace(int num){
        if (num > officeList.size())
        {
            throw new SpaceIndexOutOfBoundsException(num,officeList.size());
        }
        return officeList.get(num);
    }

    public void setSpace(int num, Space newOffice){
        if (num > officeList.size())
        {
            throw new SpaceIndexOutOfBoundsException(num,officeList.size());
        }
        this.officeList.set(num, newOffice);
    }

    public void addSpace(int num, Space newOffice){
        if (num > officeList.size())
        {
            throw new SpaceIndexOutOfBoundsException(num,officeList.size());
        }
        List<Space> offices = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            offices.add(officeList.get(i));
        }
        offices.add(newOffice);
        for (int i = num; i < officeList.size(); i++) {
            offices.add(officeList.get(i));
        }
    }

    public void deleteSpace(int num){
        if (num > officeList.size())
        {
            throw new SpaceIndexOutOfBoundsException(num,officeList.size());
        }
        officeList.remove(num);
    }

    public Space getBestSpace(){
        Space Office = officeList.get(0);
        for (Space i: officeList) {
            if (i.getSquare() > Office.getSquare()){
                Office = i;
            }
        }
        return Office;
    }
}

