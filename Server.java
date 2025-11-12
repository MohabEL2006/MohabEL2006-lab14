import java.net.Socket;
import java.time.*;
import java.util.ArrayList;

public class Server extends Socket{

    private int port;
    private ArrayList<Client> clients;

    public Server (int port) {
        this.port = port;
    }

    public void serve(int num) {

    }

    public void disconnect() {

    }

    public void addClient(ArrayList clientList) {
        
    }

    public ArrayList<LocalDateTime> getConnectedTimes() {
        return null;
    }

     public static void main(String args[]){
    }
}