package Helpers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MouseHoverListener extends MouseListener {

    void hoverUpdate(MouseEvent mouseEvent, boolean isHovering);

    default void mouseClicked(MouseEvent mouseEvent) {};

    default void mousePressed(MouseEvent mouseEvent) {};

    default void mouseReleased(MouseEvent mouseEvent) {};

    default void mouseEntered(MouseEvent mouseEvent) {
        this.hoverUpdate(mouseEvent, true);
    };

    default void mouseExited(MouseEvent mouseEvent) {
        this.hoverUpdate(mouseEvent, false);
    };

}
