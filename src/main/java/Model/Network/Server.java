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
    @Override
    public void run() {
        try{
            server = new ServerSocket(9999);
            pool = Executors.newCachedThreadPool();

            /*
            Client internal_client = new Client();
            Thread internal_client_thread = new Thread(internal_client);
            internal_client_thread.start();
             */

            while (!done){              //TODO:Handle multiple client connections
                Socket client = server.accept();
                System.out.println(" client connection accepted !");
                // TODO: Remove the temp lines  [ 31 - 36 ]
                Object accept_obj;
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream()); // Server <- Client :: Stream
                while((accept_obj = ois.readObject()) != null) {
                    if (((String) accept_obj).equals("Connected")) {
                        System.out.println(" Client Connected ! ");
                    }
                }

                ConnectionHandler handler = new ConnectionHandler(client);
                connections_list.add(handler);
                System.out.println("Handler added !");
                pool.execute(handler);
            }

        }catch (IOException e){
            //TODO:Shutdown server

        }// TODO : REMOVE THIS SHIT BELOW 3 lines
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


//===== Connection Handler inner class================================================
    class ConnectionHandler implements Runnable{
        private Socket client;
        private String nickname;
        public ConnectionHandler(Socket client_sock){
            this.client = client_sock;
        }
        @Override
        public void run() {
            try{
                System.out.println(" ois from client created !");
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream()); // Server <- Client :: Stream
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

                Object accept_obj;
                while((accept_obj = ois.readObject()) != null) {
                    if (((String) accept_obj).equals("Connected")) {
                        System.out.println(" Client Connected ! ");
                    }
                }
            }catch (IOException | ClassNotFoundException e){
                //TODO:Shutdown handler

            }

        }
    }






}
