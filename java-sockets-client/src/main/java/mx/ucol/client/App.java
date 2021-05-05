package mx.ucol.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        Socket socket;
        DataOutputStream outputStream;
        DataInputStream inputStream;
        String inputMessage = "";
        int port = 3000;

        try {
            System.out.println("Stablishing a connection to Mars...");
            socket = new Socket("localhost", port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Connection accepted. If you want to leave, just write \"exit\"");
            do {
                System.out.println("Write a message");
                Scanner scanner = new Scanner(System.in);
                outputStream.writeUTF(scanner.nextLine());
                inputMessage = inputStream.readUTF();
                if(!inputMessage.equals("exit")){
                    System.out.println("Answer received: " + inputMessage);
                }
            } while (!inputMessage.equals("exit"));

            socket.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}