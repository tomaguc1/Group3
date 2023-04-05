package Views;

import javax.swing.*;
import java.awt.*;

public class UI_Panels extends JPanel {
    public UI_Panels(int wide, int high){
        this.setPreferredSize(new Dimension(wide, high));
        this.setVisible(true); //At the end
    }
    public UI_Panels(int wide, int high, Color c){
        this(wide,high);
        this.setBackground(c);
        this.setVisible(true); //At the end
    }
    public UI_Panels(Color c){
        this.setBackground(c);
        this.setVisible(true); //At the end
    }
}
