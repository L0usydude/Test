package buildings.office;

import buildings.dwelling.Flat;

import java.util.ArrayList;
import java.util.List;

public class OfficeFloor {
    private List<Office> officeList;

    public OfficeFloor(List<Office> officeList) {
        this.officeList = officeList;
    }

    public OfficeFloor(int count){
        officeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            officeList.add(new Office());
        }
    }

    public OfficeFloor(Office[] offices){
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
        for (Office office : officeList) {
            sum += office.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount(){
        int sum = 0;
        for (Office office : officeList) {
            sum += office.getRooms();
        }
        return sum;
    }

    public Office[] getSpaces(){
        Office[] offices = new Office[officeList.size()];
        for (int i = 0; i < offices.length; i++) {
            offices[i] = officeList.get(i);
        }
        return offices;
    }

    public Office getSpace(int num){
        return officeList.get(num);
    }

    public void setSpace(int num, Office newOffice){
        this.officeList.set(num, newOffice);
    }

    public void addSpace(int num, Office newOffice){
        if (num > officeList.size())
        {
            System.out.println("Error");
        }
        List<Office> offices = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            offices.add(officeList.get(i));
        }
        offices.add(newOffice);
        for (int i = num; i < officeList.size(); i++) {
            offices.add(officeList.get(i));
        }
    }

    public void deleteSpace(int num){
        officeList.remove(num);
    }

    public Office getBestSpace(){
        Office Office = officeList.get(0);
        for (Office i: officeList) {
            if (i.getSquare() > Office.getSquare()){
                Office = i;
            }
        }
        return Office;
    }
}

