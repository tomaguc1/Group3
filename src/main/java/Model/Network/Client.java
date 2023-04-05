package Model.Network;

import io.cucumber.java.sl.In;
import javafx.scene.Scene;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
    import java.net.Socket;
    import java.util.Scanner;


    public class Client implements Runnable{
        Scanner s = new Scanner(System.in);
        private Socket server_socket;
        private boolean done = false;
        private ObjectOutputStream oos;
        private ObjectInputStream ois;
        public Object clientReceivedObj;

    public Client() {
        try {
            server_socket = new Socket("127.0.0.1", Server.PORT);
        } catch (IOException e) {
            shutdown(server_socket, ois, oos);
        }
    }
    public Client(String IP)  {
        try {
            server_socket = new Socket(IP, Server.PORT);
        } catch (IOException e) {
            shutdown(server_socket, ois, oos);
        }
    }
    @Override
    public void run() {
        try{
            //Below  Server -> Client :: Inputs
            System.out.println("=> Client.run() entered");
            ois = new ObjectInputStream(server_socket.getInputStream());
            Object inObj;
            while((inObj = ois.readObject()) != null) {
                System.out.println("=> Object received by client");
            }
        }catch (Exception e){ // Exception caught when deserializing an object at .readObject()
            shutdown(server_socket, ois, oos);
        }
    }
        public void shutdown(Socket server_socket, ObjectInputStream ois, ObjectOutputStream oos){
            done = true;
            try{
                ois.close();
                oos.close();
                if(!server_socket.isClosed()){
                    server_socket.close();
                }
            }catch (IOException e){
                //ignore handling
            }
        }


}