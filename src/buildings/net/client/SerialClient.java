package buildings.net.client;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import buildings.utils.Buildings;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SerialClient {
        public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Type.txt"));
            Reader reader = new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Info.txt");
            Writer writer = new FileWriter("C:\\Users\\Vanya\\IdeaProjects\\Test\\Result.txt")) {
            while (scanner.hasNext()){
                String type = scanner.nextLine();
                dos.writeUTF(type);
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
                Building sth = Buildings.readBuilding(reader, buildingClass, floorClass, spaceClass);
                Buildings.serializeBuilding(sth,dos);
                String res = dis.readUTF();
                writer.write(res);
                System.out.println(res);
            }


        } catch (IOException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        }
}
