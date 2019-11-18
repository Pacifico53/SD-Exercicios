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

            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            PrintWriter out = new PrintWriter(clSock.getOutputStream());

            String s;
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
