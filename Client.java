import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.*;

// javac -classpath ".;junit-platform-console-standalone-1.7.0-M1.jar" *.java 
// java -classpath ".;junit-platform-console-standalone-1.7.0-M1.jar" org.junit.runner.JUnitCore Lab14_Tester
public class Client {

    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String key = "12345";

    public Client(String host, int port) {
        // connect socket, create reader/writer
        this.host = host;
        this.port = port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void handshake() {
        // send key
    }

    public String request(String msg) {
        return null;    // send/receive one message
    }

    public void disconnect() {
        // close streams + socket
    }

    public static void main () {

    }
}
