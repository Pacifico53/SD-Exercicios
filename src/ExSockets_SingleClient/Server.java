package ExSockets_SingleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    void serve() throws IOException {
        while(true){
            Socket clSock = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            PrintWriter out = new PrintWriter(clSock.getOutputStream());
            String s;

            while((s = in.readLine()) !=null){
                System.out.println("Got a message (\""+s+"\"). Sending reply...");
                out.println("Hello from the mighty server! I shall repeat your words! Behold! : \"" +s +"\"");
                out.flush();
            }

            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        }
    }
}
