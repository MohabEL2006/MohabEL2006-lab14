import java.io.*;
import java.net.*;

public class Client {

    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String key = "12345";

    public Client(String host, int port) throws Exception {
        this.host = host;
        this.port = port;

        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void handshake() {
        out.println(key);
        out.flush();
    }

    public String request(String msg) {
        try {
            out.println(msg);
            out.flush();
            String line = in.readLine();
            return line;
        }
        catch (Exception e) {
            return "An exception happened.";
        }
    }

    public void disconnect() {
        try {
            in.close();
        }
        catch (Exception e) {
        }

        try {
            out.close();
        }
        catch (Exception e) {
        }

        try {
            socket.close();
        }
        catch (Exception e) {
        }
    }
}
