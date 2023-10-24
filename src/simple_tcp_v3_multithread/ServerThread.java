package simple_tcp_v3_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            System.out.println("New Client has connected.");

            // I/O buffers:
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // from the client
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); // from the server to the client

            out_socket.println("Welcome! What's your name ? "); // send "Welcome" to the Client
            String message = in_socket.readLine();
            System.out.println("Client says: " + message); // display Client's message in the console

            // Close the socket
            socket.close();
            System.out.println("Socket is closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
