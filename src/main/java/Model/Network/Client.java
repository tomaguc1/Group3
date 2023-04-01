package Model.Network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable{

    private Socket server_socket;
    private boolean done = false;
    ObjectOutputStream oos;
    public void shutdown(){
        done = true;
        try{
            oos.close();
            if(!server_socket.isClosed()){
                server_socket.close();
            }
        }catch (IOException e){
            //ignore handling
        }
    }


    @Override
    public void run() {
        try{
            server_socket = new Socket("127.0.0.1",9999); // Localhost TODO: Handle remote host connection
            oos = new ObjectOutputStream(server_socket.getOutputStream());
            System.out.println("Sending request to server_socket !");
            oos.writeObject("Connected");
        }catch (Exception e){
            shutdown();
        }
    }

    class InputHandler implements Runnable {

        @Override
        public void run() {
            //TODO : Implement input/output streams with the server
        }
    }
}
