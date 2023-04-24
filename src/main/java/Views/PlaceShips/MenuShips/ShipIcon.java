package Views.PlaceShips.MenuShips;

import Model.Ship.Ship_Type;
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

    public ShipIcon(Ship_Type shipType, int i){
        this(i);
        switch (shipType) {
            case SUBMARINE:
                this.setImage(GameView.graphics.smallShip.getImage());
                break;
            case DESTROYER:
                this.setImage(GameView.graphics.mediumShip.getImage());
                break;
            case BATTLESHIP:
                this.setImage(GameView.graphics.largeShip.getImage());
                break;
            case CARRIER:
                this.setImage(GameView.graphics.carrier.getImage());
                break;
        }
    }
}
