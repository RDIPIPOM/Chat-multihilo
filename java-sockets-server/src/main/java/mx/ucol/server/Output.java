package mx.ucol.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Output implements Runnable {
    private DataOutputStream outputStream;
    private String outputMessage = "";

    public Output(Socket socket) throws IOException {
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run(){
        try {
            while (true){
                Scanner scanner = new Scanner(System.in);
                outputMessage = scanner.nextLine();
                outputStream.writeUTF(outputMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
