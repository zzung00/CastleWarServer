package network;

import Entity.SocketClient;

public class PacketCreator {

    public static byte[] enterGame(int id) {
        PacketWriter writer = new PacketWriter();
        writer.writeShort(0);
        writer.writeInt(id);
        return writer.getPacket();
    }

    public static byte[] movePlayers(SocketClient client) {
        PacketWriter writer = new PacketWriter();
        writer.writeShort(1);
        writer.writeInt(client.getClientId());
        writer.writeByte(client.isHorizontally() ? 1 : 0);
        writer.writeInt((int) client.getX());
        writer.writeInt((int) client.getY());
        return writer.getPacket();
    }
}
