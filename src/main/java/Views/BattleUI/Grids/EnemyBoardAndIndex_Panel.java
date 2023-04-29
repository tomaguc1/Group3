package Views.BattleUI.Grids;

import Controller.BattleController;
import Model.Board.Board;

import javax.swing.*;
import java.awt.*;

public class EnemyBoardAndIndex_Panel extends JPanel {

    EnemyGridBoard enemyGridBoard;

    JPanel letterIndex = new JPanel();
    JPanel numberIndex = new JPanel();

    public EnemyBoardAndIndex_Panel(BattleController controller){
        enemyGridBoard = new EnemyGridBoard(controller);
        init_IndexPanes();

        this.add(enemyGridBoard);

    }
    void init_IndexPanes(){
        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setBackground(Color.MAGENTA);

        String[] int_labels = {"1","2","3","4","5","6","7","8","9","10"};
        String[] letter_labels = {"A","B","C","D","E","F","G","H","I","J"};


        numberIndex.setLayout(new GridLayout(10, 1));
        numberIndex.setBounds(0, 0, 50, 500);
        numberIndex.setBackground(Color.LIGHT_GRAY);
        for (String i : int_labels){

            numberIndex.add(new JButton(i));
        }

        letterIndex.setLayout(new GridLayout(1, 10));
        letterIndex.setBounds(50, 500, 500, 50);
        letterIndex.setBackground(Color.GRAY);
        for (String i : letter_labels){
            letterIndex.add(new JButton(i));
        }

        add(letterIndex);
        add(numberIndex);
//---------------------------------------------------------------------------------------------------------

    }

    public void clearBoard() {
        this.enemyGridBoard.clearBoard();
    }

    public void populate(Board board) {
        this.enemyGridBoard.populate(board);
    }

}
