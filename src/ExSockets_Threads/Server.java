package ExSockets_Threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while(true) {
            Socket clSock;

            clSock = serverSocket.accept();

            Worker worker = new Worker(clSock);
            Thread thread = new Thread(worker);

            thread.start();
        }
    }
}
