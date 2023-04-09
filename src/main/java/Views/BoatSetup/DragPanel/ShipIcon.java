package Views.BoatSetup.DragPanel;

import Views.MainView;

import javax.swing.*;
import java.awt.*;

public class ShipIcon extends ImageIcon {

    Point corner;
        public Point getCorner(){return this.corner; }
        public void setCorner(Point p){this.corner = p; }
    Point lastPoint;
        public Point getLastPoint(){return this.lastPoint; }
        public void setLastPoint(Point p){this.lastPoint = p; }


    public ShipIcon(int i){
        this.corner = new Point(530 , 50*i);
    }

    public ShipIcon(String shipType, int i){
        this(i);
        switch (shipType) {
            case "s":
                this.setImage(MainView.graphics.smallShip.getImage());
                break;
            case "m":
                this.setImage(MainView.graphics.mediumShip.getImage());
                break;
            case "l":
                this.setImage(MainView.graphics.largeShip.getImage());
                break;
            case "c":
                this.setImage(MainView.graphics.carrier.getImage());
                break;
        }
    }
}
