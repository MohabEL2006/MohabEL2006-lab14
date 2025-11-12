import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

// javac -classpath ".;junit-platform-console-standalone-1.7.0-M1.jar" *.java 
// java -classpath ".;junit-platform-console-standalone-1.7.0-M1.jar" org.junit.runner.JUnitCore Lab14_Tester
public class Client extends Socket {

    private String host;
    private int port;
    private Socket socket;
    private String key = "12345";

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handshake() {
        try {
            System.out.println("Client Connected!!");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);
            out.println("Hello Client, connection established!");
            in.close();
            out.close();
            socket.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String request(String str) {
        return null;
    }

    public void disconnect() {
    }

    public Socket getSocket() {
        return socket;
    }

    public static void main(String args[]) {

    }
}
