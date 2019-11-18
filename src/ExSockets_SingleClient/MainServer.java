package ExSockets_SingleClient;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Server server = new Server(serverSocket);

            server.serve();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
