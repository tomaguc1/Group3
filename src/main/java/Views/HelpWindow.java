package Views;

import javax.swing.*;
import java.awt.*;

public class HelpWindow {
    JFrame jFrame = new JFrame();
    String labelText ="<html> <font> <h1>HELP!</h1> <p> something </p> </font></html>";
    JLabel jLabel= new JLabel(labelText);

    JButton jButton = new JButton();

        public HelpWindow(){
            jLabel.setBounds(0,0,1280,720);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setVerticalAlignment(JLabel.TOP);

            jFrame.setLayout(null);
            jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            jFrame.setSize(1280,720);
            jFrame.add(jLabel);
            jFrame.setVisible(true);


        }

}
