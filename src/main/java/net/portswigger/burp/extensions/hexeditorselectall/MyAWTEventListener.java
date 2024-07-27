package net.portswigger.burp.extensions.hexeditorselectall;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

class MyAWTEventListener implements AWTEventListener {
    @Override
    public void eventDispatched(AWTEvent event) {
        // ensure is keyboard press event
        if (event.getID() == KeyEvent.KEY_PRESSED) {
            KeyEvent e = (KeyEvent)event;
            // pressed key is Ctrl-A or Command-A
            if (e.getKeyCode() == KeyEvent.VK_A && (e.isMetaDown() || e.isControlDown())) {
                // source component is JTable
                if (e.getComponent() instanceof JTable table) {
                    // JTable is visible and has data
                    if (table.isVisible() && table.getRowCount() > 0) {
                        // select position 0
                        table.changeSelection(0, 0, false, false);
                        // extend selection to end
                        table.changeSelection(table.getRowCount(), table.getColumnCount(), false, true);
                    }
                }
            }
        }
    }
}
