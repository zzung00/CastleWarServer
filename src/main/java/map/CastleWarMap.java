package map;

import Entity.Castle;
import Entity.SocketClient;
import network.PacketWriter;

import java.util.ArrayList;
import java.util.HashMap;

public class CastleWarMap {
    private HashMap<Integer, SocketClient> players = new HashMap<>();
    private Castle leftCastle;
    private Castle rightCastle;

    public CastleWarMap(SocketClient leftPlayer, SocketClient rightPlayer) {
        players.put(0, leftPlayer);
        players.put(1, rightPlayer);
    }

    public HashMap<Integer, SocketClient> getPlayers() {
        return players;
    }

    public void sendAll() {

    }

    public SocketClient getPlayerById(int id) {
        return players.get(id);
    }
}
