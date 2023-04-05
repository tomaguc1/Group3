package Model.Network;

import java.io.Serializable;

public class Packet implements Serializable {
    String message;
    Packet(String msg){
        this.message = msg;
    }
}
