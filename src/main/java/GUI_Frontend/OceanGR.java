package GUI_Frontend;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OceanGR extends JPanel {

    public OceanGR() {
      //GridLayout layout = new GridLayout(10,10);
      //this.setLayout(layout);
    	this.setBackground(Color.darkGray);
        this.setSize(300,300);
        GridLayout layout = new GridLayout(0,10);
        layout.setHgap(3);
        layout.setVgap(3);
         
    	JButton[][] buttons = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
      	  for (int j = 0; j < 10; j++) {
      		 
      	    buttons[i][j] = new JButton();
      	  }
      	}
    }

}
