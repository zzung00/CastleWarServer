package castlewar;

import Entity.SocketClient;
import map.CastleWarMap;
import network.PacketCreator;

import java.io.*;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;

public class SocketServer implements Runnable{
    private ServerSocket serverSocket;
    private int port;
    private Queue<SocketClient> waiting = new LinkedList<>();
    private CastleWarMap map;

    public SocketServer(int port) {
        this.port = port;
    }

    public void enqueue(SocketClient player) {
        System.out.println(waiting.size());
        if (waiting.isEmpty()) {
            waiting.add(player);
        }else {
            SocketClient leftPlayer = waiting.poll();
            SocketClient rightPlayer = player;
            leftPlayer.sendPacket(PacketCreator.enterGame((byte) 0));
            rightPlayer.sendPacket(PacketCreator.enterGame((byte) 1));
            map = new CastleWarMap(leftPlayer, rightPlayer);
        }
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("waiting...");
                SocketClient player = new SocketClient(serverSocket.accept(), this);
                player.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
