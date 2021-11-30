package network;

public class PacketCreator {

    public static byte[] enterGame(byte position) {
        PacketWriter writer = new PacketWriter();
        writer.writeShort(0);
        writer.writeByte(position);
        return writer.getPacket();
    }
}
