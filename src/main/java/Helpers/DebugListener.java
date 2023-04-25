package Helpers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DebugListener implements MouseListener {

    private String name;

    public DebugListener(String name) {
        this.name = name;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("DebugListener [" + name + "] mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("DebugListener [" + name + "] mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("DebugListener [" + name + "] mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("DebugListener [" + name + "] mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("DebugListener [" + name + "] mouseExited");
    }
}
