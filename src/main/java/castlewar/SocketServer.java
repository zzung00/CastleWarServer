package castlewar;

import java.io.*;
import java.net.ServerSocket;

public class SocketServer implements Runnable{
    private ServerSocket serverSocket;
    private int port;

    public SocketServer(int port) {
        this.port = port;
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("waiting...");
                Player player = new Player(serverSocket.accept(), this);
                player.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
