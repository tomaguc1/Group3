package Views.PlaceShips.GridShip;

import Controller.PlaceShipsController;
import Helpers.DebugListener;
import Helpers.ImageLibrary;
import Model.Position;
import Model.Ship.Ship_Type;
import Views.PlaceShips.MenuShips.ShipBox_Label;
import Views.PlaceShips.PlaceShipsView;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.util.ArrayList;

public class boardGrid_Panel extends JPanel  {
    ImageLibrary graphics = new ImageLibrary();

    JButton[][] buttonArray = new JButton[10][10];
    Tile[][] tiles = new Tile[10][10];

    public boardGrid_Panel(PlaceShipsController controller){
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(10, 10, 1, 1));
        this.setBounds(50, 0, 500, 500);

        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                Tile tile = new Tile(x, y);
                this.add(tile);
                tiles[y][x] = tile;
                tile.addMouseListener(controller.actionHoverOverTile(new Position(x,y)));
                tile.addMouseListener(controller.actionRotateShip());
                tile.addMouseListener(controller.actionPlaceShip());
                //TODO : add action listener from controller
                // buttonArray[i][j].addActionListener(controller.getButtonClickListener(i, j));
            }
        }

    }

    public void clearShips() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Tile tile = this.tiles[y][x];
                tile.hasShip = false;
            }
        }
    }

    public void addShip(ArrayList<Position> list) {
        for (Position position: list) {
            int x = position.getX();
            int y = position.getY();

            if (x < 0 || y < 0 || x > 9 || y > 9)
                continue;

            Tile tile = this.tiles[y][x];
            tile.hasShip = true;
        }
    }

    public void highlightCoordinates(boolean valid, ArrayList<Position> list) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Tile tile = this.tiles[y][x];
                tile.setBackground(tile.hasShip ? Color.YELLOW : Color.GRAY);
            }
        }

        for (Position position: list) {
            int x = position.getX();
            int y = position.getY();

            if (x < 0 || y < 0 || x > 9 || y > 9)
                continue;

            Tile tile = this.tiles[y][x];
            tile.setBackground(valid ? Color.GREEN : Color.RED);
        }
    }

//=-=- Tiles that form the ocean =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    public class Tile extends JPanel { // Model Board element
        Position position;
        public boolean hasShip;
        Tile(){
            this.setPreferredSize(new Dimension(50, 50));
            this.setBackground(Color.red);
        }
        Tile(int x, int y){
            this();
            this.position = new Position(x, y);

        }
    }
//--------------------------------------------------------------------------------------------------------
}
