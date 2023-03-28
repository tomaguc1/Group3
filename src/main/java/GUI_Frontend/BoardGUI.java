package GUI_Frontend;
import javax.swing.JFrame;

public class BoardGUI extends JFrame {

    public BoardGUI() {
        
        this.setTitle("BattleShipsTM"); //sets frame title in the bar with the close minimize and expand buttons
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets default close operation (what happens when you close the window, default is Hide on close)
        this.setResizable(true); // determines if you can alter the size of the window
        this.setVisible(true); // Shows the JFrame (default is false)
        this.setSize(420,69); // sets an arbitrary size for the initially generated frame
    }
    
}
