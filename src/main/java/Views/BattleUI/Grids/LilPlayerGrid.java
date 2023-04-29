package Views.BattleUI.Grids;

import Controller.BattleController;
import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Board.ShipElement;
import Model.Position;

import javax.swing.*;
import java.awt.*;

public class LilPlayerGrid extends JPanel {

    private LilTile[][] tiles;

    public LilPlayerGrid(BattleController controller){
        this.setBackground(Color.MAGENTA);
        this.setPreferredSize(new Dimension(250, 250));
        this.setLayout(new GridLayout(10, 10, 1, 1));

        this.tiles = new LilTile[10][10];
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                LilTile tile = new LilTile(x, y);
                this.add(tile);
                this.tiles[y][x] = tile;
            }
        }
    }

    public void clearBoard() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                LilTile tile = this.tiles[y][x];
                tile.setBackground(Color.CYAN);
            }
        }
    }

    public void populate(Board board) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Position position = new Position(x, y);
                BoardElement boardElement = board.getBoardElementAtPosition(position);
                LilTile tile = this.tiles[y][x];

                if (boardElement.getWasHit()) {
                    if (boardElement instanceof ShipElement) {
                        tile.setBackground(Color.RED);
                    } else {
                        tile.setBackground(new Color(100,100,200));
                    }
                } else {
                    if (boardElement instanceof ShipElement) {
                        tile.setBackground(Color.GREEN);
                    } else {
                        tile.setBackground(new Color(0,0,90));
                    }
                }
            }
        }
    }

    public class LilTile extends JPanel { // Model Board element
        Position position;
        public boolean hasShip;
        LilTile(){
            this.setPreferredSize(new Dimension(25, 25));
            this.setBackground(Color.cyan);
        }
        LilTile(int x, int y){
            this();
            this.position = new Position(x, y);

        }
    }
}
