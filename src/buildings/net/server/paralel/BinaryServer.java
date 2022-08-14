package buildings.net.server.paralel;

import buildings.threads.ClientRead;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinaryServer {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("server start");
            while (true){
                Socket socket = serverSocket.accept();
                Thread thread = new ClientRead(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
