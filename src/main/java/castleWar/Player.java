package castleWar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Player extends Thread{
    private InputStream input = null;
    private OutputStream output = null;
    private Socket socket = null;

    public Player() {
        try {
            socket = new Socket("localhost", 9090);
            input = socket.getInputStream();
            output = socket.getOutputStream();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
