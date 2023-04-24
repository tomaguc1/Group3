package Views.PlaceShips;

import Controller.PlaceShipsController;
import Views.PlaceShips.GridShip.BoardAndIndex_Panel;
import Views.PlaceShips.MenuShips.ShipsMenu_Panel;
import Views.PlaceShips.ReadyToPlay.ReadyToPlay_Panel;

import javax.swing.*;
import java.awt.*;

public class PlaceShipsView extends JPanel {
    private PlaceShipsController controller;

    JPanel contentPane;
    JPanel lockInShipPanel;

    public PlaceShipsView(PlaceShipsController controller){
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

        BoardAndIndex_Panel boardAndIndex_panel = new BoardAndIndex_Panel(controller);
        ShipsMenu_Panel shipsMenu_panel = new ShipsMenu_Panel();
        ReadyToPlay_Panel readyToPlay_panel = new ReadyToPlay_Panel();


        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30 , 30));
        contentPane.setPreferredSize(new Dimension(1280, 665));
        contentPane.setBackground(Color.CYAN);

        contentPane.add(boardAndIndex_panel);
        contentPane.add(shipsMenu_panel);
        contentPane.add(readyToPlay_panel);


        this.add(contentPane);
    //-------------------------------------------------------------------------
    }


}
