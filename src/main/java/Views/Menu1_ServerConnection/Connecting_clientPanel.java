package Views.ConnectingPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connecting_clientPanel extends JPanel implements ActionListener {

    JLabel centerLabel;
    JButton buttonReady;
    JTextField servIpText;

    void addCompoToPannel(JLabel label, JTextField textBox, JButton button){
        this.add(label);
        this.add(textBox);
        this.add(button);
        this.setVisible(true);
    }
    public Connecting_clientPanel(){
//LABEL:
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(100, 190));
        centerLabel = new JLabel("Localhost ...", JLabel.CENTER );  //TODO: add display of localhost
        centerLabel.setVerticalAlignment(JLabel.TOP);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalTextPosition(JLabel.CENTER);
        centerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        centerLabel.setFont(new Font("Helvetica", Font.PLAIN, 19));

        centerLabel.setBackground(Color.LIGHT_GRAY);
        centerLabel.setOpaque(true);


//buttonREADY
        buttonReady = new JButton();
        buttonReady.setSize(150,100);
        buttonReady.setHorizontalAlignment(SwingConstants.CENTER);
        buttonReady.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonReady.addActionListener(e -> {System.out.println(" ->-> Ready button pressed !");
                                            System.out.println(servIpText.getText());
                                            buttonReady.setEnabled(false); // Stop button and textbox from being used
                                            servIpText.setEditable(false);
                }
        );
        //Button formatting
        buttonReady.setFocusable(false);                         //removes the box around text
        buttonReady.setText("Ready");
        buttonReady.setHorizontalTextPosition(JButton.CENTER);
        buttonReady.setVerticalTextPosition(JButton.TOP);
        buttonReady.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        buttonReady.setBackground(Color.LIGHT_GRAY);
        buttonReady.setBorder(BorderFactory.createEtchedBorder());


//servIP
        servIpText = new JTextField();
        servIpText.setPreferredSize(new Dimension(160,30));
        servIpText.setText("Remote IP ...");

        this.addCompoToPannel(centerLabel, servIpText, buttonReady);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
