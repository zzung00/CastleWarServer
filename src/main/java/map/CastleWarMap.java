package map;

import Entity.Castle;
import Entity.SocketClient;
import network.PacketWriter;

import java.util.ArrayList;

public class CastleWarMap {
    private SocketClient leftPlayer;
    private SocketClient rightPlayer;
    private Castle leftCastle;
    private Castle rightCastle;

    public CastleWarMap(SocketClient leftPlayer, SocketClient rightPlayer) {
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }
}
