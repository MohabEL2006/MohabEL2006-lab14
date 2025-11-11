import java.net.*;

public class Client {

    private String host;
    private int port;
    private Socket socket;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
        } catch (Exception e) {
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public int getPort() {
        return this.port;
    }

    public void handshake() {

    }

    public String request(String str) {
        return null;
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {

    }
}