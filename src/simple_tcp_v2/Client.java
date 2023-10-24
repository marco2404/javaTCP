package simple_tcp_v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception {

        Socket socket = new Socket("127.0.0.1",2020);
        System.out.println("Successful connection to the server");

        // I/O buffers:
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); // from the server
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); // from the client to the server

        Scanner keyboard = new Scanner(System.in);
        String user_number;

        while((in_socket.readLine()).startsWith("Guess")){
            System.out.println("Server says: Guess a number [1-10].");
            user_number = keyboard.nextLine();
            out_socket.println(user_number);
        }

        System.out.println("You got it !!! [Client]");


        /*
        String message = in_socket.readLine();
        System.out.println("Server says: " + message); // display Server's message in the console
        System.out.print("Say something to the server: ");
        message = keyboard.nextLine();
        out_socket.println(message); // send "Welcome" to the Server
        */


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
