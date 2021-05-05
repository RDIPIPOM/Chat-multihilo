package mx.ucol.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int port = 3000;
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inputStream;
        DataOutputStream outputStream;
        String inputMessage = "";

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            outputStream = new DataOutputStream(socket.getOutputStream());
            while (!inputMessage.equals("exit")) {
                inputStream = new DataInputStream(socket.getInputStream());
                inputMessage = inputStream.readUTF();
                System.out.println("Client says: " + inputMessage);
                if(!inputMessage.equals("exit")){
                    System.out.println("Write an answer");
                    Scanner scanner = new Scanner(System.in);
                    outputStream.writeUTF(scanner.nextLine());
                }
            }
            outputStream.writeUTF("exit");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
