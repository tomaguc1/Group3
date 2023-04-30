package Views;

import javax.swing.*;
import java.awt.*;

public class HelpWindow {
    JFrame jFrame = new JFrame();
    String labelText ="<html> <font > <h1>HELP!</h1> <p> On the main menu, you will find options to select either single-player mode with multiple difficulties or a multiplayer mode. You will also find the option to submit your choice of music while playing. You have three choices: “Mario”, “Pirates” and “Goofy”. Also, if you like memes, make sure to keep an eye out for a fun musical Easter Egg!\n" +
            "\n" +
            "Above the grid, you can see a box where you can type in your name.\n" +
            "After choosing your desired game mode, place your ship in an unpredictable manner. You can place your ships by clicking on the ship icon on the right side of the grid. From there, hover over the grid. You should see the shape of the ship you just selected. Use the right click button on your mouse to rotate the ship. You can now place your ship.\n" +
            "Repeat those steps until you have no ship left.\n" +
            
            "You can now press the “Lock In” button next to your name to proceed to the game.\n" +
            "\n" +
            "On the left side of your screen, you should be able to see your grid where you placed your ships. This is where the opponent’s shot will be shown.\n" +
            "You can play by simply clicking on the grid in the middle of the screen.\n" +
            "Red coloured cells means a shot has struck a ship.\n" +
            "Blue coloured cells are failed shot.\n" +
            "\n" +
            "The game ends when all ships for either player have been hit.\n" +
            "\n" +
            "Have fun! </p> </font></html>";
    JLabel jLabel= new JLabel(labelText);

    JButton jButton = new JButton();

        public HelpWindow(){
            jLabel.setPreferredSize(new Dimension(1200,700));
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setVerticalAlignment(JLabel.TOP);

            jFrame.setLayout(new FlowLayout());
            jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            jFrame.setSize(1280,720);
            jFrame.add(jLabel);
            jFrame.setVisible(true);


        }

}
