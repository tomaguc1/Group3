package Helpers;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface DocumentChangedListener extends DocumentListener {
    @Override
    default void insertUpdate(DocumentEvent documentEvent) {
        this.changedUpdate(documentEvent);
    }

    @Override
    default void removeUpdate(DocumentEvent documentEvent) {
        this.changedUpdate(documentEvent);
    }

    void changedUpdate(DocumentEvent documentEvent);
}
