package Views.BoatSetup.DragPanel;

import Helpers.ImageLibrary;
import Views.MainFrame;

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
                this.setImage(MainFrame.graphics.smallShip.getImage());
                break;
            case "m":
                this.setImage(MainFrame.graphics.mediumShip.getImage());
                break;
            case "l":
                this.setImage(MainFrame.graphics.largeShip.getImage());
                break;
            case "c":
                this.setImage(MainFrame.graphics.carrier.getImage());
                break;
        }
    }
}
