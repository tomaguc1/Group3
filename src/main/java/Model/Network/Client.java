package Model.Network;

import io.cucumber.java.sl.In;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable{

    private Socket server_socket;
    private boolean done = false;

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client() {
        try {
            server_socket = new Socket("127.0.0.1",9999);
        } catch (IOException e) {
            shutdown(server_socket, ois, oos);
        }
    }
    public Client(String IP)  {
        try {
            server_socket = new Socket(IP,9999);
        } catch (IOException e) {
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

    @Override
    public void run() {
        try{
//            server_socket = new Socket("127.0.0.1",9999); // Localhost TODO: Handle remote host connection

            InputHandler inputHandler = new InputHandler();
            Thread t = new Thread(inputHandler);
                System.out.println("=> client.run() InputHandler created");
            t.start();

                //Below  Server -> Client :: Inputs
            ois = new ObjectInputStream(server_socket.getInputStream());
            Object inObj;
            while((inObj = ois.readObject()) != null){
                if(inObj instanceof String){
                    System.out.println((String) inObj);
                }
            }
        }catch (Exception e){
            shutdown(server_socket, ois, oos);
        }
    }

    class InputHandler implements Runnable {    //Handler for sending client inputs

        @Override
        public void run() {
            try{    //TODO : Check execution flow
                oos = new ObjectOutputStream(server_socket.getOutputStream());
                Object outObj = "Connected";
                while(!done){

                        System.out.println("Connected object client -> server sent !");
                    oos.writeObject(outObj);
                    done = true;
                        System.out.println(" Client.run() executed !");
                }
            }catch ( IOException e){
                shutdown(server_socket, ois, oos);

            }

        }
    }
}
