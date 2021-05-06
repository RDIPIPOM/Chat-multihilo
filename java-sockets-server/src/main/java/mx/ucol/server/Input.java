package mx.ucol.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Input implements Runnable {
    private DataInputStream inputStream;
    private String inputMessage = "";

    public Input(Socket socket) throws IOException {
        inputStream = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run(){
        try {
            while (true){
                inputMessage = inputStream.readUTF();
                System.out.println("Client says: " + inputMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
