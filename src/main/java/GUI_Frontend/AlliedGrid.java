package GUI_Frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;



public class AlliedGrid extends JPanel {

    public AlliedGrid() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLayout(new BorderLayout());
        this.setBounds(screenSize.width/3,0, screenSize.width/3, screenSize.height);
        this.setBackground(Color.RED);

    }
}