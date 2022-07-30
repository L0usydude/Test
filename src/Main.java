import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.threads.*;

public class Main {
    public static void main(String[] args) {
        Flat f1 = new Flat(40,2);
        Flat f2 = new Flat(41,2);
        Flat f3 = new Flat(42,2);
        Flat[] arr = new Flat[2];
        arr[0] = f1;
        arr[1] = f3;
        Flat[] arr2 = new Flat[1];
        arr2[0] = f2;
        HotelFloor fl1 = new HotelFloor(arr);
        HotelFloor fl2 = new HotelFloor(arr2);
        HotelFloor[] arrhl = new HotelFloor[2];
        arrhl[0] = fl1;
        arrhl[1] = fl2;
        Hotel h1 = new Hotel(arrhl);
        Space sth = h1.getBestSpace();
        int aaaaa = h1.getMaxStars();
        int y = 0;
        Floor floor = new DwellingFloor(10);
        Thread thr1 = new Repairer(fl1);
        Thread thr2 = new Cleaner(fl1);
        Semophore sem = new Semophore(true,false);
        Thread thr3 = new Thread(new SequentalRepairer(floor, sem));
        Thread thr4 = new Thread(new SequentalCleaner(floor, sem));

        thr3.start();
        thr4.start();
    }
}
