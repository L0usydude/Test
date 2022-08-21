package buildings.net.client;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.interfaces.Space;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import buildings.utils.Buildings;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BinaryClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Type.txt"));
            Reader reader = new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Info.txt");
            Writer writer = new FileWriter("C:\\Users\\Vanya\\IdeaProjects\\Test\\Result.txt")) {
            while (scanner.hasNext()){
                String type = scanner.nextLine();
                System.out.println(type);
                dos.writeUTF(type);
                Class buildingClass = null, floorClass = null, spaceClass = null;
                switch (type) {
                    case "Dwelling" -> {
                        buildingClass = Dwelling.class;
                        floorClass = DwellingFloor.class;
                        spaceClass = Flat.class;
                    }
                    case "Office" -> {
                        buildingClass = OfficeBuilding.class;
                        floorClass = OfficeFloor.class;
                        spaceClass = Office.class;
                    }
                    case "Hotel" -> {
                        buildingClass = Hotel.class;
                        floorClass = HotelFloor.class;
                        spaceClass = Flat.class;
                    }
                }

                Building sth = Buildings.readBuilding(reader, buildingClass, floorClass, spaceClass);
                System.out.println("read");
                Buildings.outputBuilding(sth,dos);
                System.out.println("send");
                String result = dis.readUTF();
                writer.write(result);

            }


        } catch (InvocationTargetException | IOException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
