import java.io.*;
import java.net.*;
import java.time.*;
import java.util.ArrayList;

public class Server {

    private int port;
    private ServerSocket serverSocket;
    private ArrayList<Socket> clients = new ArrayList<>();
    private ArrayList<LocalDateTime> connectedTimes = new ArrayList<>();

    public Server(int port) throws Exception {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void serve(int num) {
        try {
            int i = 0;
            while (i < num) {
                Socket s = serverSocket.accept();
                clients.add(s);
                Thread t = new Thread(() -> handleClient(s));
                t.start();
                i = i + 1;
            }
        }
        catch (Exception e) {
        }
    }

    private void handleClient(Socket s) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream());

            String handshake = in.readLine();
            boolean handshakeCorrect = "12345".equals(handshake);

            if (handshakeCorrect == false) {
                out.println("couldn't handshake");
                out.flush();
                s.close();
                return;
            }

            Thread.sleep(100);
            connectedTimes.add(LocalDateTime.now());

            String req = in.readLine();
            int n = 0;

            try {
                n = Integer.parseInt(req);
            }
            catch (Exception e) {
                out.println("There was an exception on the server");
                out.flush();
                return;
            }

            long f = countFactors(n);
            out.println("The number " + n + " has " + f + " factors");
            out.flush();
        }
        catch (Exception e) {
            try {
                PrintWriter out = new PrintWriter(s.getOutputStream());
                out.println("There was an exception on the server");
                out.flush();
            }
            catch (Exception ignore) {
            }
        }
    }

    private long countFactors(long n) {
        long count = 0;
        long limit = (long) Math.sqrt(n);

        long i = 1;
        while (i <= limit) {
            boolean divides = (n % i == 0);
            if (divides == true) {
                count = count + 2;
            }
            i = i + 1;
        }

        long square = limit * limit;
        boolean perfectSquare = (square == n);
        if (perfectSquare == true) {
            count = count - 1;
        }

        return count;
    }

    public ArrayList<LocalDateTime> getConnectedTimes() {
        return connectedTimes;
    }

    public void disconnect() {
        try {
            serverSocket.close();
        }
        catch (Exception e) {
        }

        int i = 0;
        while (i < clients.size()) {
            Socket s = clients.get(i);
            try {
                s.close();
            }
            catch (Exception e) {
            }
            i = i + 1;
        }
    }
}
