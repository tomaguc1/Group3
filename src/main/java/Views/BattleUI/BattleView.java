package Views.BattleUI;

import Controller.BattleController;
import Model.Board.Board;
import Views.BattleUI.Grids.EnemyBoardAndIndex_Panel;
import Views.BattleUI.Grids.LilPlayerGrid;


import javax.swing.*;
import java.awt.*;

public class BattleView extends JPanel {

    EnemyBoardAndIndex_Panel enemyBoardAndIndex_panel;
    LilPlayerGrid lilPlayerGrid;


    JLabel labelStatus;
    JLabel labelReady;
    JPanel panelBoards;
    JPanel panelReady;


    public BattleView(BattleController controller) {
        this.setPreferredSize(new Dimension(1280,720));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,0));

        labelStatus = new JLabel("loading");
        this.add(labelStatus, BorderLayout.NORTH);

        panelBoards = new JPanel(); {
            panelBoards.setPreferredSize(new Dimension(1280, 665));
            panelBoards.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 55));

            enemyBoardAndIndex_panel = new EnemyBoardAndIndex_Panel(controller);
            lilPlayerGrid = new LilPlayerGrid(controller);


            panelBoards.add(lilPlayerGrid);
            panelBoards.add(enemyBoardAndIndex_panel);

        }
        this.add(panelBoards, BorderLayout.CENTER);

        panelReady = new JPanel(); {
            panelReady.setPreferredSize(new Dimension(1280, 55));
            panelReady.setLayout(new FlowLayout(FlowLayout.CENTER));

            labelReady = new JLabel("loading");
            panelReady.add(labelReady);

            JButton buttonReady = new JButton("READY");
            buttonReady.addActionListener(controller.actionReady());
            panelReady.add(buttonReady);
        }
        this.add(panelReady, BorderLayout.CENTER);
    }

    public void setStatusText(String text) {
        this.labelStatus.setText(text);
    }

    public void setReadyText(String text) {
        this.labelReady.setText(text);
    }

    public void setBoardsVisible(boolean visible) {
        if (visible) {
            this.panelReady.setVisible(false);
            this.panelBoards.setVisible(true);
        } else {
            this.panelBoards.setVisible(false);
            this.panelReady.setVisible(true);
        }
    }

    public void clearPlayerData() {
        this.enemyBoardAndIndex_panel.clearBoard();
        this.lilPlayerGrid.clearBoard();

    }

    public void populateAllyBoard(Board board) {
        this.lilPlayerGrid.populate(board);
    }

    public void populateEnemyBoard(Board board) {
        this.enemyBoardAndIndex_panel.populate(board);
    }


}
