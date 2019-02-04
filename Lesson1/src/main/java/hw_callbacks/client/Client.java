package hw_callbacks.client;

import hw_callbacks.server.ServerApi;

public class Client implements ClientCallback {

    @Override
    public void callback(Object data) {
        System.out.println(data.toString());
    }

    public void interract(ServerApi server) {
        server.getData(this, "Hello from Client");
    }
}
