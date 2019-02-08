package network;

import message.Request;
import message.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {
    ObjectOutputStream os = null;
    ObjectInputStream is = null;

    @Override
    public void run() {
        ObjectInputStream is = null;
        ObjectOutputStream os = null;
        Socket socket = null;

        try {
            socket = new Socket(Server.HOST, Server.PORT);

            is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());

            os.writeObject(new Request("hello server"));

            Response response = (Response) is.readObject();

            Server.p("Client received response: " + response.getContent());

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } finally {
            Server.close(is, os, socket);
        }
    }
}
