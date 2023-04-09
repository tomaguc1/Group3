package Views.Menu1_ServerConnection;

import Helpers.ImageLibrary;
import Model.Network.Client;
import Model.Network.Server;
import Views.UI_Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HostClient_Pane extends JLayeredPane implements ActionListener {
    ImageLibrary graphics = new ImageLibrary();
    JButton buttonHost;
    JButton buttonClient;
    ImageIcon image = new ImageIcon(graphics.shipImage.getImage());
    JLabel menuLabel_shipLabel;
    JPanel SOUTHbasePanel;
    JPanel clientConPanel;
    JPanel hostConPanel;
    JPanel menuLabel_Pane;
    public HostClient_Pane() {
                        hostConPanel = new Connecting_hostPanel();
                        clientConPanel = new Connecting_clientPanel();
                        //Button for Hosting
                        //HOST  :
                        buttonHost = new ButtonHost();
                        buttonHost.addActionListener(e -> {
                            System.out.println("->hostButton pressed 2 !");
                            SOUTHbasePanel.setVisible(false);
                                Server serv = new Server();
                            this.add(hostConPanel, BorderLayout.SOUTH);
                        });

                        buttonClient = new ButtonClient();
                        buttonClient.addActionListener(e -> {
                            System.out.println("->clientButton pressed !");
                            SOUTHbasePanel.setVisible(false);
//                                Client clie = new Client();
                            this.add(clientConPanel, BorderLayout.SOUTH);
                        });

        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(1280,720));
        this.setLayout(new BorderLayout());



//Label Ship + Text
        menuLabel_shipLabel = new JLabel(image);
//        menuLabel_shipLabel.setSize(new Dimension(500,400));
        menuLabel_shipLabel.setText("Battleships Group3");
        menuLabel_shipLabel.setVerticalAlignment(JLabel.TOP);
        menuLabel_shipLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel_shipLabel.setHorizontalTextPosition(JLabel.CENTER);
        menuLabel_shipLabel.setVerticalTextPosition(JLabel.BOTTOM);
        menuLabel_shipLabel.setForeground(new Color(105,0,0));
        menuLabel_shipLabel.setFont(new Font("Helvetica", Font.BOLD, 28));
            menuLabel_shipLabel.setOpaque(true);
            menuLabel_shipLabel.setBackground(Color.GREEN);


        menuLabel_Pane = new JPanel();
        menuLabel_Pane.setPreferredSize(new Dimension(500,500));
//        menuLabel_Pane.add(menuLabel_shipLabel);
        menuLabel_Pane.setBackground(Color.BLACK);
        menuLabel_Pane.setVisible(true);


        JPanel emptyEastPanel = new UI_Panels(150, 100, Color.LIGHT_GRAY);
        JPanel emptyWestPanel = new UI_Panels(150, 100, Color.MAGENTA);
        JPanel emptyNorthPanel = new UI_Panels(150, 70, Color.CYAN);
        JPanel centerPanel = new JPanel();
        centerPanel.add(menuLabel_shipLabel);
        centerPanel.setPreferredSize(new Dimension(150,100));
        centerPanel.setBackground(Color.ORANGE);


        SOUTHbasePanel = new UI_Panels(100, 190, Color.RED);
        SOUTHbasePanel.setLayout(new FlowLayout());
        SOUTHbasePanel.add(buttonHost);
        SOUTHbasePanel.add(buttonClient);








//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================



//        this.add(menuLabel_Pane, BorderLayout.CENTER);

//        basePanel.setVisible(true);
//        this.setVisible(true);

        //ADD components to the LayeredPane
        //''this'' -- LayeredPane Component
//        this.add(menuLabel_Pane, BorderLayout.CENTER);
        this.add(emptyNorthPanel, BorderLayout.NORTH);
        this.add(emptyWestPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(emptyEastPanel, BorderLayout.EAST);
        this.add(SOUTHbasePanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }//End of constrctor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonHost){
            System.out.println("=>actionEvent on host");
        }else if(e.getSource() == buttonClient){

        }
    }
}