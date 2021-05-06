package mx.ucol.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        Socket socket;
        int port = 3000;

        try {
            socket = new Socket("localhost", port);
            new Thread(new Input(socket)).start();
            new Thread(new Output(socket)).start();
            System.out.println("Connection was accepted by the server.");

        } catch (Exception e) {
            System.err.print(e);
        }
    }
}