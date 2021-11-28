package castleWar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Player extends Thread{
    private SocketServer socketServer;

    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public Player(Socket socket, SocketServer socketServer) {
        this.socket = socket;
        this.socketServer = socketServer;

        try {
            input = socket.getInputStream();
            output = socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(byte[] data) {
        try {
            output.write(data);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
