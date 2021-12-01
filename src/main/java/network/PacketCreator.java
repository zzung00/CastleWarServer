package network;

public class PacketCreator {

    public static byte[] enterGame(int id) {
        PacketWriter writer = new PacketWriter();
        writer.writeShort(0);
        writer.writeInt(id);
        return writer.getPacket();
    }
}
