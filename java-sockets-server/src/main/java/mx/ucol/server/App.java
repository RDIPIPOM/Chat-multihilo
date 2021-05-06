package mx.ucol.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int port = 3000;
        ServerSocket serverSocket;
        Socket socket;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a connection...");
            socket = serverSocket.accept();
            System.out.println("Connection accepted");
            new Thread(new Input(socket)).start();
            new Thread(new Output(socket)).start();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}
