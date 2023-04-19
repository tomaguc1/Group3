package Views.SetShips.Grid;

import Views.SetShips.DragPanel.ShipIcon;
import Views.SetShips.DragPanel.ShipLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Layer1_panel extends JPanel implements MouseListener {
    ArrayList<ShipIcon> iconsShips;
    ArrayList<ShipLabel> labelsShips;
    String[] shipList = {"s","s","s", "m", "m", "l", "c"};

    public Layer1_panel(){
        this.setLayout(null);
        this.setBounds(350, 50, 930, 500);
        this.setOpaque(false);

        iconsShips = new ArrayList<>();
        labelsShips = new ArrayList<>();

        for(int i = 0; i < shipList.length; i++){
            iconsShips.add(new ShipIcon(shipList[i],i + 1));
            labelsShips.add(new ShipLabel(shipList[i], i + 1));
                System.out.println("Ship icon and pannel created !");
        }

        for(ShipLabel e : labelsShips){
            this.add(e);
            e.addMouseListener(this); //Adding click on action on the label
            System.out.println(" -> label added !");
        }


        this.setVisible(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(ShipIcon e : iconsShips){
            e.paintIcon(this, g, (int) e.getCorner().getX(), (int) e.getCorner().getY());
        }

    }







    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked !");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
