package hw_callbacks.server;

import hw_callbacks.client.ClientCallback;

public interface ServerApi {
    void getData(ClientCallback cc, String request);
}
