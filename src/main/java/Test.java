import Controller.GameController;
import Views.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {


    public Test() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(1280,720));
        this.setBackground(Color.yellow);

        JPanel upperPanel = new JPanel(); // Switch Players Pane
        upperPanel.setPreferredSize(new Dimension(1280,65));
        upperPanel.setBackground(Color.LIGHT_GRAY);

        JPanel middlePanel = new JPanel(); // Middle Player Pane
        middlePanel.setPreferredSize(new Dimension(1280,655));
        middlePanel.setBackground(Color.CYAN);

        this.add(upperPanel);
        this.add(middlePanel);
    }


    public static void main(String[] args) {

        Test myPane = new Test();

        JFrame myFrame = new JFrame();
        myFrame.add(myPane);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout());
        myFrame.setTitle("MenuConnect Title !");
        myFrame.setResizable(false);
        myFrame.setSize(1280,720);
        myFrame.getContentPane().setBackground(Color.pink);

        myFrame.setVisible(true);

    }

}
