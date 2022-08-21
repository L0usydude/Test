package buildings.threads;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFactory;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFactory;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFactory;
import buildings.office.OfficeFloor;
import buildings.utils.Buildings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

public class ClientRead extends Thread{
    private Socket socket;

    public ClientRead(Socket newsocket){
        this.socket = newsocket;
    }

    @Override
    public void run() {
        try {

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                try {
                    String type = dis.readUTF();
                    if ("Dwelling".equals(type)) {
                        Buildings.setBuildingFactory(new DwellingFactory());
                    } else if ("Hotel".equals(type)) {
                        Buildings.setBuildingFactory(new HotelFactory());
                    } else if ("Office".equals(type)) {
                        Buildings.setBuildingFactory(new OfficeFactory());
                    }
                    Class buildingClass = null, floorClass = null, spaceClass = null;
                    switch (type){
                        case "Dwelling":
                            buildingClass = Dwelling.class;
                            floorClass = DwellingFloor.class;
                            spaceClass = Flat.class;
                            break;
                        case "OfficeBuilding":
                            buildingClass = OfficeBuilding.class;
                            floorClass = OfficeFloor.class;
                            spaceClass = Office.class;
                            break;
                        case "Hotel":
                            buildingClass = Hotel.class;
                            floorClass = HotelFloor.class;
                            spaceClass = Flat.class;
                    }
                    System.out.println("type has been read");
                    Building sth = Buildings.inputBuilding(dis, buildingClass, floorClass, spaceClass);
                    System.out.println("building has been read");
                    String res = result(sth, type);
                    dos.writeUTF(res);
                    dos.flush();
                    System.out.println("result has been send");
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            dis.close();
            dos.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String result(Building sth, String type){
        double square = sth.getSquareAmount();
        if ("Dwelling".equals(type))
        {
            square *= 1000;
        }
        else if ("Hotel".equals(type)){
            square *= 2000;
        }
        else if ("Office".equals(type)){
            square *= 3000;
        }
        return square + "";
    }
    }
