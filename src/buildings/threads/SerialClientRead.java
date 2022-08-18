package buildings.threads;

import buildings.dwelling.DwellingFactory;
import buildings.dwelling.hotel.HotelFactory;
import buildings.interfaces.Building;
import buildings.office.OfficeFactory;
import buildings.utils.Buildings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SerialClientRead extends Thread{
    private Socket socket;

    public SerialClientRead(Socket newsocket){
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
                    System.out.println("type has been read");
                    Building sth = Buildings.deserializeBuilding(dis);
                    System.out.println("building has been read");
                    String res = result(sth, type);
                    dos.writeUTF(res);
                    dos.flush();
                    System.out.println("result has been send");
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                } catch (ClassNotFoundException e) {
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
