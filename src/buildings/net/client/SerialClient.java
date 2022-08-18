package buildings.net.client;

import buildings.interfaces.Building;
import buildings.utils.Buildings;

import java.io.*;
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
                Building sth = Buildings.readBuilding(reader);
                Buildings.serializeBuilding(sth,dos);
                String res = dis.readUTF();
                writer.write(res);
                System.out.println(res);
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
