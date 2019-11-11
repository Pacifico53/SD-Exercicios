package ExSockets;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
    }

    void doStuff() throws IOException {
        String s = "a";
        while(!s.isEmpty()){
            out.println(s);
            out.flush();
            s = in.readLine();
        }
    }

    void close() throws IOException {
        socket.shutdownOutput();
        socket.shutdownInput();
        socket.close();
    }

}
