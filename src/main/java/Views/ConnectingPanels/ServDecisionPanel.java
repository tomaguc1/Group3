package Views.ConnectingPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum SERVICE{
    CLIENT,
    SERVER
}


public class ServDecisionPanel extends JLayeredPane implements ActionListener {
    JButton buttonHost;
    JButton buttonClient;
    SERVICE service;

    JPanel basePanel;
    JPanel clientConPanel;
    JPanel hostConPanel;
    public ServDecisionPanel() {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(100, 200));
        this.setLayout(new FlowLayout());
        basePanel = new JPanel();


        //====  Connection menu Pannel ==== TODO :{ after pressing host should display the ip address to connect at, and handle a ready lock to transition to the game }

        //Button for Hosting
//HOST  :
        buttonHost = new ButtonClient();

//CLIENT:buttonClient = new ButtonClient();

//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================


        //@button_Subpanel

        basePanel.add(buttonHost);
        basePanel.add(buttonClient);
        this.add(basePanel, Integer.valueOf(0));
        this.setVisible(true);

        //ADD components to the frame
        //''this'' -- Frame Component
    }//End of constrctor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonHost){
            System.out.println("=>actionEvent on host");
        }else if(e.getSource() == buttonClient){

        }
    }
}