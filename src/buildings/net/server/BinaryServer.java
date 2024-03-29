package buildings.net.server;

import buildings.interfaces.Building;
import buildings.utils.Buildings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BinaryServer {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("server start");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream dis = new DataInputStream(socket.getInputStream());
                     DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
                    String type = dis.readUTF();
                    System.out.println("type has been read");;
                    Building sth = Buildings.inputBuilding(dis);
                    System.out.println("building has been read");
                    String res = result(sth, type);
                    dos.writeUTF(res);
                    System.out.println("result has been send");
                }
            }

        } catch (IOException e) {
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
