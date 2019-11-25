package ExSockets_Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker implements Runnable {
    private int id;
    private Socket clSock;

    public Worker(int id, Socket clSock) {
        this.id = id;
        this.clSock = clSock;
    }

    public void run() {
        String s;

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            PrintWriter out = new PrintWriter(clSock.getOutputStream());

            while((s = in.readLine()) !=null){
                System.out.println("Got a message (\""+s+"\"). Sending reply...");
                out.println("Hello from the mighty server! I shall repeat your words! Behold! : \"" +s +"\"");
                out.flush();
            }

            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
