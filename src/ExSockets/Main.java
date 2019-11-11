package ExSockets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        //Socket socket = new Socket();
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Server server = new Server(serverSocket);
            //Client client = new Client(socket);

            server.serve();
            //client.doStuff();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
