package castleWar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable{
    private Socket socket;
    public SocketServer() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9090);
            while (true) {
                socket = server.accept();
                System.out.println("서버 대기");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

    }
}
