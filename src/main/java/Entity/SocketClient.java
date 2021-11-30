package Entity;

import castlewar.SocketServer;
import network.PacketCreator;
import network.PacketReader;
import network.PacketWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class SocketClient extends Thread{
    private SocketServer socketServer;
    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public SocketClient(Socket socket, SocketServer socketServer) {
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
        try {
            while (!socket.isClosed()) {
                byte[] data = new byte[1024];
                int count = input.read(data);
                if (count <= 0) {
                    continue;
                }

                PacketReader reader = new PacketReader(data);
                short packetId = reader.readShort();

                switch (packetId) {
                    case 0: {
                        System.out.println("enter player...");
                        socketServer.enqueue(this);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(byte[] data) {
        System.out.println(Arrays.toString(data));
        try {
            output.write(data);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
