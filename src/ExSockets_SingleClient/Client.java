package ExSockets_SingleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket;

        //establish socket connection to server
        socket = new Socket(host.getHostName(), 12345);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        System.out.println("Connected...\nSend messages:");

        String string_in, string_out;
        System.out.print("> ");
        while((string_in = in.readLine()) !=null){
            System.out.println("Message sent: \"" +string_in+"\".");

            out.println(string_in);
            out.flush();
            string_out = in_socket.readLine();

            System.out.println("Message received: \"" + string_out + "\"");
            System.out.print("> ");
        }
    }
}
