package simple_tcp_v2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws IOException {

        // Server socket
        ServerSocket server_socket = new ServerSocket(2020); //opening a new port
        System.out.println("Port 2020 is open");

        // Socket
        Socket socket = server_socket.accept(); // waiting for incoming connection
        System.out.println("Client " + socket.getInetAddress() + " has connected."); // ip address of the client

        // I/O buffers:
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // from the client
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); // from the server to the client

        String message;
        int secret_number = (int)(Math.random()*10+1);

        do {
            out_socket.println("Guess the number [1-10]: ");
            message = in_socket.readLine();
        } while ( Integer.parseInt(message) != secret_number);

        out_socket.println("You got it !!! [Server]");
        System.out.println("Secret number is: " + secret_number);

        /*
        out_socket.println("Welcome !!!"); // send "Welcome" to the Client
        String message = in_socket.readLine();
        System.out.println("Client says: " + message); // display Client's message in the console
         */

        // Close the socket
        socket.close();
        System.out.println("Socket is closed");

    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
