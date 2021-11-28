package castleWar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable{
    private Socket socket;
    private ServerSocket serverSocket;
    private int port;

    public SocketServer(int port) {
        this.port = port;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Player player = new Player(serverSocket.accept(), this);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

    }
}
