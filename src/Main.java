import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.threads.*;
import buildings.utils.Buildings;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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
        HotelFloor[] arrhl2 = new HotelFloor[2];
        arrhl2[0] = fl2;
        arrhl2[1] = fl1;
        HotelFloor[] arrhl3 = new HotelFloor[1];
        arrhl3[0] = fl1;
        HotelFloor[] arrhl4 = new HotelFloor[1];
        arrhl4[0] = fl2;
        for (Space obj: fl1){
            System.out.println(1);
        }
        Hotel h4 = new Hotel(arrhl3);
        Hotel h3 = new Hotel(arrhl4);
        Hotel h1 = new Hotel(arrhl);
        Hotel h2 = new Hotel(arrhl2);
        Space sth = h1.getBestSpace();
        Floor floor = new DwellingFloor(10);
        try (Writer sth1 = new FileWriter("C:\\Users\\Vanya\\IdeaProjects\\Test\\Info.txt")) {
            Buildings.writeBuilding(h1, sth1);
            Buildings.writeBuilding(h2, sth1);
            Buildings.writeBuilding(h3, sth1);
            Buildings.writeBuilding(h4, sth1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
