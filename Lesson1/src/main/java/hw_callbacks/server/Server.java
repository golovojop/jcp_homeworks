package hw_callbacks.server;

import hw_callbacks.client.ClientCallback;

import java.util.ArrayList;

public class Server implements ServerApi {

    @Override
    public void getData(ClientCallback cc, String request) {
        cc.callback(request + ": " + "Hello from Server");
    }

}
