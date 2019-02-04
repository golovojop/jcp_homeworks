package hw_callbacks;

import hw_callbacks.client.Client;
import hw_callbacks.server.Server;

public class StartClass {
    public static void main(String[] args) {
        Client client = new Client();
        Server server = new Server();

        client.interract(server);
    }
}
