package Views.PlaceShips;

import Controller.PlaceShipsController;
import Model.Position;
import Model.Ship.Ship_Type;
import Views.PlaceShips.GridShip.BoardAndIndex_Panel;
import Views.PlaceShips.MenuShips.ShipsMenu_Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PlaceShipsView extends JPanel {

    private PlaceShipsController controller;

    JPanel contentPane;
    JPanel lockInShipPanel;

    BoardAndIndex_Panel boardAndIndex_panel;
    ShipsMenu_Panel shipsMenu_panel;

    public PlaceShipsView(PlaceShipsController controller) {
        this.controller = controller;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(1280,720));
        this.setBackground(Color.yellow);




    //=-=-  Lock In Ships Panel =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        lockInShipPanel = new JPanel();
        lockInShipPanel.setPreferredSize(new Dimension(1280, 55));
        lockInShipPanel.setBackground(Color.LIGHT_GRAY);

        JPanel panelName = new JPanel(); {
            JLabel labelName = new JLabel("Name:");
            panelName.add(labelName);

            JTextField textName = new JTextField();
            Dimension dim = textName.getPreferredSize();
            dim.width = 200;
            textName.setPreferredSize(dim);
            textName.getDocument().addDocumentListener(controller.actionUpdateName(textName));
            panelName.add(textName);
        }
        lockInShipPanel.add(panelName);

        JButton buttonSubmit = new JButton("LOCK IN");
        buttonSubmit.addActionListener(controller.actionSubmitShipPlacement(buttonSubmit));
        lockInShipPanel.add(buttonSubmit);

        this.add(lockInShipPanel);
    //-------------------------------------------------------------------------
    //=-=-  Content Pane   =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        contentPane = new JPanel();

        this.boardAndIndex_panel = new BoardAndIndex_Panel(controller);
        this.shipsMenu_panel = new ShipsMenu_Panel();


        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30 , 30));
        contentPane.setPreferredSize(new Dimension(1280, 665));
        contentPane.setBackground(Color.CYAN);

        contentPane.add(boardAndIndex_panel);
        contentPane.add(shipsMenu_panel);


        this.add(contentPane);
    //-------------------------------------------------------------------------
    }

    public void clearShips() {
        this.shipsMenu_panel.clearShips();
        this.boardAndIndex_panel.clearShips();
    }

    public void addShipToMenu(Ship_Type type, int index, boolean isSelected) {
        this.shipsMenu_panel.addShip(this.controller, type, index, isSelected);
    }

    public void addShipToBoard(ArrayList<Position> list) {
        this.boardAndIndex_panel.addShip(list);
    }

    public void highlightCoordinates(boolean valid, ArrayList<Position> list) {
        this.boardAndIndex_panel.highlightCoordinates(valid, list);
    }
}
