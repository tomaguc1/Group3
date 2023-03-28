package GUI_Frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;



public class AlliedGrid extends JPanel {

    public AlliedGrid() {  
        OceanGR ocean = new OceanGR();

        JPanel container = new JPanel(new BorderLayout());
        container.add(ocean, BorderLayout.CENTER);

        BoardGUI board = new BoardGUI();
        board.setDefaultCloseOperation(BoardGUI.EXIT_ON_CLOSE);
        board.getContentPane().add(container);
        board.pack();
        board.setVisible(true);
    }
}
