import java.net.*;
import java.time.*;
import java.util.ArrayList;;

public class Server {

    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Socket> clients = new ArrayList<>();
    private ArrayList<LocalDateTime> connectedTimes = new ArrayList<>();

    public Server(int port) {
        // create or store socket
    }

    public void serve(int num) {
        // accept num connections, check handshake, process request
    }

    public ArrayList<LocalDateTime> getConnectedTimes() {
        return connectedTimes;
    }

    public void disconnect() {
        // close serverSocket
    }

    public static void main() {

    }
} 

