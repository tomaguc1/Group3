package Views.SetShips.Grid;

import Helpers.ImageLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Draft_Layer1_panel extends JPanel implements MouseListener {
    ImageLibrary graphics = new ImageLibrary();
    ImageIcon smallShip = new ImageIcon(graphics.smallShip.getImage());

    int WIDTH = smallShip.getIconWidth();
    int HEIGHT = smallShip.getIconHeight();
    JLabel labelShip = new JLabel(smallShip);

    Point shipCorner;
    Point lastPoint;

    public Draft_Layer1_panel(){
        this.setLayout(null);
        this.setBounds(350, 50, 930, 500);

        this.setOpaque(false);

        shipCorner = new Point(0, 0);
            labelShip.setBounds(600, 50, 100, 50);
            labelShip.setBackground(Color.YELLOW);
            labelShip.setOpaque(true);
            labelShip.addMouseListener(this);


        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();


        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);



        this.add(labelShip);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.paintComponents(g);
        smallShip.paintIcon(this, g, (int) shipCorner.getX(), (int) shipCorner.getY());

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

    //======================================================================================================================
    private class ClickListener extends MouseAdapter { // Assigns click coords to prevPt
        public void mousePressed(MouseEvent e){
            lastPoint = e.getPoint();
            System.out.println("prevPt X = " + lastPoint.getX() + " Y = " + lastPoint.getY());
        }
    }
//----------------------------------------------------------------------------------------------------------------------



//======================================================================================================================
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){

            Point currentPoint = e.getPoint();
                System.out.println("Current mouse point is x = " + currentPoint.getX() + " y = " + currentPoint.getY());

            shipCorner.translate(   // Asigns updated previous point to the ship corner
                    (int)(currentPoint.getX() - lastPoint.getX()),
                    (int)(currentPoint.getY() - lastPoint.getY())
            );
            lastPoint = currentPoint;
            repaint();
        }

    }
//----------------------------------------------------------------------------------------------------------------------
}
