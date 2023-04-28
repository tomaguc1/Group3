package Views;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame{

    public static ImageLibrary graphics = new ImageLibrary();

    public GameView() {


/*  Frame settings
* */
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,0));
        this.setTitle("MainFrame Title !");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.getContentPane().setBackground(Color.YELLOW);
//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================


        this.setVisible(true);

    }//End of constrctor

}
 
