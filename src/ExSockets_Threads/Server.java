package ExSockets_Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while(true) {
            Socket clSock;
            int client_id = 0;

            clSock = serverSocket.accept();

            Worker worker = new Worker(client_id++, clSock);
            Thread thread = new Thread(worker);

            thread.start();

            String s;
            //TODO OS WORKERS É QUE LEEM E MANDAM AS RESPOSTAS, O SERVER NAO VAI LER NADA!! CHANGE THIS SHIT
            while ((s = in.readLine()) != null) {
                System.out.println("Got a message (\"" + s + "\"). Sending reply...");
                out.println("Hello from the mighty server! I shall repeat your words! Behold! : \"" +s +"\"");
                out.flush();
            }

            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        }
    }
}
