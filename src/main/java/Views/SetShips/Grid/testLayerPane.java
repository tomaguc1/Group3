package Views.SetShips.Grid;

import javax.swing.*;
import java.awt.*;

public class testLayerPane extends JLayeredPane {
    public testLayerPane(){
        this.setLayout(null);
        this.setBounds(0, 0, 1280, 720);
//        this.setPreferredSize(new Dimension(1280, 720));
        JPanel lay0 = new JPanel();
        lay0.setBounds(50,50,100,100);
        lay0.setBackground(Color.GREEN);
        lay0.setVisible(true);

        JPanel lay1 = new JPanel();
        lay1.setBounds(75,75,100,100);
        lay1.setBackground(Color.BLUE);
        lay1.setVisible(true);

        this.add(lay0,new Integer(0));
        this.add(lay1, new Integer(1));

        this.setVisible(true);


//            lay0.setB
    }
}
