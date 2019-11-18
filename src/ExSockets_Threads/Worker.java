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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String string_in, string_out;
        System.out.print("> ");
        while(true){
            try {
                string_in = in.readLine();

                if (string_in == null || string_in.equals("exit")) break;

                System.out.println("Message sent: \"" +string_in+"\".");
                out.println(id+"_"+string_in);
                out.flush();
                string_out = in_socket.readLine();

                System.out.println("Message received: \"" + string_out + "\"");
                System.out.print("> ");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
