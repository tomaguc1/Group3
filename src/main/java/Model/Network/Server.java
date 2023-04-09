package Model.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    public static final int PORT = 9999;
    private ServerSocket server;
    private static ArrayList<ConnectionHandler> client_list;
    private ExecutorService pool;

    public Server() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            shutdown_serv();
        }
        client_list = new ArrayList<>();
        new Thread(this);
    }

    public void shutdown_serv() {
        try {
            if (server != null)
                if (!server.isClosed()) {
                    server.close();
                }
        } catch (IOException e) {
            //ignore
        }
    }

    @Override
    public void run() {
        try {

            pool = Executors.newCachedThreadPool();

            Client internal_client = new Client();
            Thread internal_client_thread = new Thread(internal_client);
            System.out.println("-> Internal Client Started !");
            internal_client_thread.start();
            boolean done = false;
            while (done != true) {
                System.out.println("-> run() While Loop Enter");
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                client_list.add(handler);
                System.out.println("->There are " + queryTwoClients()
                        + "connected !");

            }
            System.out.println("EXIT While loop");


        } catch (IOException e) {
            shutdown_serv();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean queryTwoClients() throws InterruptedException {
        long waitTime = 1000;
//        Thread.sleep(waitTime);
        if (client_list == null) {
            return false;
        } else return client_list.size() == 2;
    }

    //===== Connection Handler inner class================================================
    class ConnectionHandler implements Runnable {
        private Socket client;
        ObjectInputStream ois;

        public ConnectionHandler(Socket client_sock) {
            this.client = client_sock;
        }

        @Override
        public void run() {
            try {
                ois = new ObjectInputStream(client.getInputStream()); // Server <- Client :: Stream
                Object accept_obj;
                while ((accept_obj = ois.readObject()) != null) {
                    if (((String) accept_obj).equals("Connected")) {
                        System.out.println("--> Client Object received! ");
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                shutdown_handler(client, ois);
            }

        }

        //SHUTDOWN
        public void shutdown_handler(Socket cl, ObjectInputStream oi) {
            try {
                oi.close();
                if (!cl.isClosed()) {
                    cl.close();
                }
            } catch (IOException e) {
                // Ignore exception handling
            }
        }
    }
}
