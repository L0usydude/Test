package buildings.office;

import buildings.exceptions.SpaceIndexOutOfBoundsException;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfficeFloor implements Floor, Serializable {
    private List<Space> officeList;

    public OfficeFloor(List<Space> officeList) {
        this.officeList = officeList;
    }

    public OfficeFloor(int count) {
        officeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            officeList.add(new Office());
        }
    }

    public OfficeFloor(Space[] offices) {
        officeList = new ArrayList<>();
        for (int i = 0; i < offices.length; i++) {
            officeList.add(offices[i]);
        }
    }

    public int getSpacesAmount() {
        return officeList.size();
    }

    public double getSquareAmount() {
        double sum = 0;
        for (Space office : officeList) {
            sum += office.getSquare();
        }
        return sum;
    }

    public int getRoomsAmount() {
        int sum = 0;
        for (Space office : officeList) {
            sum += office.getRooms();
        }
        return sum;
    }

    public Space[] getSpaces() {
        Space[] offices = new Space[officeList.size()];
        for (int i = 0; i < offices.length; i++) {
            offices[i] = officeList.get(i);
        }
        return offices;
    }

    public Space getSpace(int num) {
        if (num > officeList.size()) {
            throw new SpaceIndexOutOfBoundsException(num, officeList.size());
        }
        return officeList.get(num);
    }

    public void setSpace(int num, Space newOffice) {
        if (num > officeList.size()) {
            throw new SpaceIndexOutOfBoundsException(num, officeList.size());
        }
        this.officeList.set(num, newOffice);
    }

    public void addSpace(int num, Space newOffice) {
        if (num > officeList.size()) {
            throw new SpaceIndexOutOfBoundsException(num, officeList.size());
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

    public void deleteSpace(int num) {
        if (num > officeList.size()) {
            throw new SpaceIndexOutOfBoundsException(num, officeList.size());
        }
        officeList.remove(num);
    }

    public Space getBestSpace() {
        Space Office = officeList.get(0);
        for (Space i : officeList) {
            if (i.getSquare() > Office.getSquare()) {
                Office = i;
            }
        }
        return Office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeFloor that = (OfficeFloor) o;

        return officeList != null ? officeList.equals(that.officeList) : that.officeList == null;
    }

    @Override
    public int hashCode() {
        return officeList != null ? officeList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OfficeFloor{" +
                "officeList=" + officeList +
                '}';
    }

    @Override
    public Object clone() {
        List<Space> sth = new ArrayList<>();
        for (var i : officeList) {
            sth.add((Space) ((Office) i).clone());
        }
        return new OfficeFloor(sth);
    }
    @Override
    public Iterator<Space> iterator() {
        return new Iterator<Space>() {
            int index1 = 0;
            @Override
            public boolean hasNext() {
                return index1 < officeList.size();
            }

            @Override
            public Space next() {
                return officeList.get(index1++);
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

