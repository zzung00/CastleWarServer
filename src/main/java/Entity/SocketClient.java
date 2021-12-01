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
    private int clientId;
    private SocketServer socketServer;
    private Socket socket;
    private InputStream input;
    private OutputStream output;
    private long x, y;
    private boolean horizontally;

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

    public boolean isHorizontally() {
        return horizontally;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setY(long y) {
        this.y = y;
    }

    public long getY() {
        return y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                if (socket.isClosed()) {
                    break;
                }
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
                    }break;

                    case 1: {
                        int id = reader.readInt();
                        byte horizon = reader.readByte();
                        if (horizon == 0) {
                            horizontally = false;
                        }else {
                            horizontally = true;
                        }
                        x = reader.readInt();
                        y = reader.readInt();

                        if (id == 0) {
                            socketServer.getMap().getPlayerById(1).sendPacket(PacketCreator.movePlayers(this));
                        }else if (id == 1) {
                            socketServer.getMap().getPlayerById(0).sendPacket(PacketCreator.movePlayers(this));
                        }

                    }break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendPacket(byte[] data) {
        System.out.println(Arrays.toString(data));
        try {
            output.write(data);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
