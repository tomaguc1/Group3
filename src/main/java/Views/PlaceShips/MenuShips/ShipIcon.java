package Views.PlaceShips.MenuShips;

import Views.GameView;

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
                this.setImage(GameView.graphics.smallShip.getImage());
                break;
            case "m":
                this.setImage(GameView.graphics.mediumShip.getImage());
                break;
            case "l":
                this.setImage(GameView.graphics.largeShip.getImage());
                break;
            case "c":
                this.setImage(GameView.graphics.carrier.getImage());
                break;
        }
    }
}
