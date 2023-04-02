package Model.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{
    private ServerSocket server;
    private ArrayList<ConnectionHandler> connections_list;
    private ExecutorService pool;
    private boolean done;

    public Server(){
        connections_list = new ArrayList<>();
        done = false;
    }
    public void shutdown_serv(){
        try {
            done = true;
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections_list) {
                ch.shutdown_handler();
            }
        }catch (IOException e){
            //ignore
        }
    }
    @Override
    public void run() {
        try {
            server = new ServerSocket(9999);
            pool = Executors.newCachedThreadPool();


            Client internal_client = new Client();
            Thread internal_client_thread = new Thread(internal_client);
            System.out.println("-> Internal Client Started !");
            internal_client_thread.start();


            while (!done) {              //TODO:Handle multiple client connections
                Socket client = server.accept();
                    System.out.println("-> server.accept() executed ");


                ConnectionHandler handler = new ConnectionHandler(client);
                connections_list.add(handler);
                    System.out.println("-> handler created and added");
                pool.execute(handler);
            }

        } catch (IOException e) {
            shutdown_serv();
        }
    }

//===== Connection Handler inner class================================================
    class ConnectionHandler implements Runnable{
        ObjectInputStream ois;
        ObjectOutputStream oos;
        private Socket client;
        private String nickname;
        public ConnectionHandler(Socket client_sock){
            this.client = client_sock;
        }
        public void shutdown_handler(){
            try {
                ois.close();
                oos.close();
                if(!client.isClosed()){
                    client.close();
                }
            } catch (IOException e) {
                // Ignore exception handling
            }
        }
        @Override
        public void run() {
            try{
                ois = new ObjectInputStream(client.getInputStream()); // Server <- Client :: Stream
                oos = new ObjectOutputStream(client.getOutputStream());

                Object accept_obj;
                while((accept_obj = ois.readObject()) != null) {
                    if (((String) accept_obj).equals("Connected")) {
                        System.out.println(" Client Connected ! ");
                    }
                }
            }catch (IOException | ClassNotFoundException e){
                shutdown_handler();

            }

        }
    }
}
