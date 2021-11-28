package castlewar;

import network.PacketWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

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

    @Override
    public void run() {

    }

    public void sendPacket(byte[] data) {
        try {
            output.write(data);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PacketWriter packetWriter(int i) {
        PacketWriter packet = new PacketWriter();
        return packet;
    }
}
