package castlewar;

public class CastleWar {
    public static void main(String[] args) {
        SocketServer server = new SocketServer(8888);
        server.run();
    }
}
