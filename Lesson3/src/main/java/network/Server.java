package network;

import message.Request;
import message.Response;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    public static final int PORT = 11200;
    public static final String HOST = "127.0.0.1";

    ObjectOutputStream os = null;
    ObjectInputStream is = null;
    ServerSocket server = null;
    Socket client = null;

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            client = server.accept();
            p("Client connected");

            os = new ObjectOutputStream(client.getOutputStream());
            is = new ObjectInputStream(client.getInputStream());

            Request request = (Request) is.readObject();
            p("Server received message: " + request.getContent());
            os.writeObject(new Response("hello client"));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } finally {
            Server.close(os, is, client, server);
        }
    }

    /**
     * @param s - message
     */
    public static void p(String s) {
        System.out.println(s);
    }

    /**
     * Close resources
     * @param res Resource array
     */
    public static void close(Closeable... res) {
        for(Closeable r : res) {
            if(res != null) {
                try {
                    r.close();
                } catch (Exception e) {e.printStackTrace();}
            }
        }
    }
}
