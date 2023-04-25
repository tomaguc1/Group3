package Helpers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MouseClickedListener extends MouseListener {

    void mouseClicked(MouseEvent mouseEvent);

    default void mousePressed(MouseEvent mouseEvent) {};

    default void mouseReleased(MouseEvent mouseEvent) {};

    default void mouseEntered(MouseEvent mouseEvent) {};

    default void mouseExited(MouseEvent mouseEvent) {};

}
