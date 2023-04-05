package Views.Menu1_ServerConnection;

import javax.swing.*;
import java.awt.*;

public class ButtonClient extends JButton {

    public ButtonClient() {
        this.setSize(150, 100);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.BOTTOM);
        //Button formatting
        this.setFocusable(false);                         //removes the box around text
        this.setText("Connect");
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.TOP);
        this.setFont(new Font("Comic Sans", Font.PLAIN, 20));
    }
  /*  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            System.out.println("->clientButton Pressed !");
        }
    };

   */

}
