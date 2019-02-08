package network;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        Client client = new Client();

        server.start();
        client.start();
        server.join();
        client.join();
    }
}
