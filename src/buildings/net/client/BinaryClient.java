package buildings.net.client;

import buildings.dwelling.Dwelling;
import buildings.dwelling.hotel.Hotel;
import buildings.interfaces.Building;
import buildings.utils.Buildings;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BinaryClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Type.txt"));
            Reader reader = new FileReader("C:\\Users\\Vanya\\IdeaProjects\\Test\\Info.txt")) {
            while (scanner.hasNext()){
                String type = scanner.nextLine();
                System.out.println(type);
                dos.writeUTF(type);
                Building sth = Buildings.readBuilding(reader);
                System.out.println("read");
                Buildings.outputBuilding(sth,dos);
                System.out.println("send");
            }


        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
