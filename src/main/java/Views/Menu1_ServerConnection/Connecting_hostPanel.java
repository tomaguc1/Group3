package Views.ConnectingPanels;
import javax.swing.*;
import java.awt.*;
public class Connecting_hostPanel extends JPanel {
    JLabel centerLabel;
    JButton buttonStart;
    public Connecting_hostPanel(){
//LABEL:
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(100, 190));
        centerLabel = new JLabel("Connect to Localhost ...", JLabel.CENTER );  //TODO: add display of localhost
        centerLabel.setVerticalAlignment(JLabel.TOP);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalTextPosition(JLabel.CENTER);
        centerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        centerLabel.setFont(new Font("Helvetica", Font.PLAIN, 19));

        centerLabel.setBackground(Color.LIGHT_GRAY);
        centerLabel.setOpaque(true);
        this.add(centerLabel);


//buttonSTART
        buttonStart = new JButton();
        buttonStart.setSize(150,100);
        buttonStart.setHorizontalAlignment(SwingConstants.CENTER);
        buttonStart.setVerticalAlignment(SwingConstants.BOTTOM);
        buttonStart.addActionListener(e -> {System.out.println(" ->-> Start button pressed !");
                                                }
                                    );
        //Button formatting
        buttonStart.setFocusable(false);                         //removes the box around text
        buttonStart.setText("Start");
        buttonStart.setHorizontalTextPosition(JButton.CENTER);
        buttonStart.setVerticalTextPosition(JButton.TOP);
        buttonStart.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        buttonStart.setBackground(Color.LIGHT_GRAY);
        buttonStart.setBorder(BorderFactory.createEtchedBorder());
        this.add(buttonStart);


        this.setVisible(true);
    }
}
