package Views.ConnectingPanels;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum SERVICE{
    CLIENT,
    SERVER
}


public class ServDecisionPanel extends JLayeredPane implements ActionListener {
    ImageLibrary graphics = new ImageLibrary();
    JButton buttonHost;
    JButton buttonClient;
    SERVICE service;
    ImageIcon image = new ImageIcon(graphics.shipImage.getImage());
    JLabel menuLabel_shipLabel;
    JPanel basePanel;
    JPanel clientConPanel;
    JPanel hostConPanel;
    public ServDecisionPanel() {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(100, 200));
        this.setLayout(new BorderLayout());
//Label Ship + Text
        menuLabel_shipLabel = new JLabel(image);
        menuLabel_shipLabel.setSize(new Dimension(500,400));
        menuLabel_shipLabel.setText("Battleships Group3");
        menuLabel_shipLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel_shipLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel_shipLabel.setHorizontalTextPosition(JLabel.CENTER);
        menuLabel_shipLabel.setVerticalTextPosition(JLabel.BOTTOM);
        menuLabel_shipLabel.setForeground(new Color(105,0,0));
        menuLabel_shipLabel.setFont(new Font("Helvetica", Font.BOLD, 28));
            menuLabel_shipLabel.setOpaque(true);
            menuLabel_shipLabel.setBackground(Color.GREEN);
        JPanel menuLabel_Pane = new JPanel();
        menuLabel_Pane.add(menuLabel_shipLabel);




        basePanel = new JPanel();
        basePanel.setSize(1280,720);
            basePanel.setLayout(new BorderLayout());
            basePanel.setBackground(Color.RED); //TODO: REMOVE
        //BasePanel initialization
        basePanel.add(menuLabel_shipLabel);
//        basePanel.add(buttonHost);
//        basePanel.add(buttonClient);


        hostConPanel = new Connecting_hostPanel();
        clientConPanel = new Connecting_clientPanel();
//Button for Hosting
        //HOST  :
        buttonHost = new ButtonClient();
        buttonHost.addActionListener(e -> {
            System.out.println("->hostButton pressed !");
            basePanel.setVisible(false);
            this.add(hostConPanel, Integer.valueOf(1));
        });

        buttonClient = new ButtonClient();
        buttonClient.addActionListener(e -> {
            System.out.println("->clientButton pressed !");
            basePanel.setVisible(false);
            this.add(clientConPanel, Integer.valueOf(1));
        });


//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================



        this.add(menuLabel_Pane, BorderLayout.CENTER);

        basePanel.setVisible(true);
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