package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception {

        Socket socket = new Socket("localhost",2020);
        System.out.println("Successful connection to the server");

        // I/O buffers:
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // from the server
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); // from the client to the server

        String message = in_socket.readLine();
        System.out.println("Server says: " + message); // display Server's message in the console

        out_socket.println("Thanks !"); // send "Welcome" to the Server

        // Close the socket
        socket.close();
        System.out.println("Socket is closed");
    }

    public static void main(String[] args) {
        try {
            new Client();
        }catch (Exception e){
            // handle exception
            e.printStackTrace();
        }
    }
}
