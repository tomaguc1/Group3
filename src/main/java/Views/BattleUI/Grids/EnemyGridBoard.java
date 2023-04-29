package Views.BattleUI.Grids;

import Controller.BattleController;
import Model.Board.Board;
import Model.Board.BoardElement;
import Model.Board.ShipElement;
import Model.Position;
import Views.PlaceShips.GridShip.BoardGrid_Panel;

import javax.swing.*;
import java.awt.*;

public class EnemyGridBoard extends JPanel {

    private TileTwo[][] tiles;

    public EnemyGridBoard(BattleController controller){
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(10, 10, 1, 1));
        this.setBounds(50, 0,   500, 500);

        this.tiles = new TileTwo[10][10];
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                EnemyGridBoard.TileTwo tile = new EnemyGridBoard.TileTwo(x, y);
                tile.addMouseListener(controller.actionAttack(new Position(x, y)));
                this.add(tile);
                this.tiles[y][x] = tile;

//                tiles[y][x] = tile;
//
//                tile.addMouseListener(controller.actionHoverOverTile(new Position(x,y)));
//                tile.addMouseListener(controller.actionRotateShip());
//                tile.addMouseListener(controller.actionPlaceShip());

            }
        }
    }

    public void clearBoard() {
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                TileTwo tile = this.tiles[y][x];
                tile.setBackground(Color.RED);
            }
        }
    }

    public void populate(Board board) {
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                Position position = new Position(x, y);
                BoardElement boardElement = board.getBoardElementAtPosition(position);
                TileTwo tile = this.tiles[y][x];

                if (boardElement.getWasHit()) {
                    if (boardElement instanceof ShipElement) {
                        tile.setBackground(Color.RED);
                    } else {
                        tile.setBackground(new Color(100,100,200));
                    }
                } else {
                    tile.setBackground(new Color(0,0,90));
                }
            }
        }
    }

    public class TileTwo extends JPanel { // Model Board element
        Position position;
        public boolean hasShip;
        TileTwo(){
            this.setPreferredSize(new Dimension(50, 50));
            this.setBackground(Color.red);
        }
        TileTwo(int x, int y){
            this();
            this.position = new Position(x, y);

        }
    }

}
