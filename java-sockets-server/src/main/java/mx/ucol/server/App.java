package mx.ucol.server;

import java.io.*;
import java.lang.annotation.Retention;
import java.net.*;

public class App {
    public static void main(String[] args) {
        int port = 3000;
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inputStream;
        DataOutputStream outputStream;
        String inputMessage = "";
        String outputMessage = "";

        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            outputStream = new DataOutputStream(socket.getOutputStream());
            while (!inputMessage.equals("exit")) {
                inputStream = new DataInputStream(socket.getInputStream());
                inputMessage = inputStream.readUTF();
                System.out.println("Received message: " + inputMessage);
                if(!inputMessage.equals("exit")){
                    outputMessage = getRandomPhrase();
                    System.out.println("Answering: " + outputMessage);
                    outputStream.writeUTF(outputMessage);
                }
            }
            outputStream.writeUTF("exit");
            socket.close();
            serverSocket.close();
        } catch (IOException | InterruptedException e) {
            System.err.print(e);
        }
    }

    private static String getRandomPhrase() throws InterruptedException {
        String phrase = "";
        int randomNumber = (int) (Math.random()*10+1);

        switch (randomNumber){
            case 1:
                phrase = "Do you know I'm an Alien?";
                break;
            case 2:
                phrase = "My name is ADKC64-9";
                break;
            case 3:
                phrase = "I'll invade the Earth some day";
                break;
            case 4:
                phrase = "Crazy, isn't it?";
                break;
            case 5:
                phrase = "How's your day going?";
                break;
            case 6:
                phrase = "Have you got any plans for the weekend?";
                break;
            case 7:
                phrase = "So, what have you been up to lately?";
                break;
            case 8:
                phrase = "Are you from New York?";
                break;
            case 9:
                phrase = "It looks like it's going to rain";
                break;
            case 10:
                phrase = "It's a beautiful day, isn't it?";
                break;
        }

        return phrase;
    }
}
