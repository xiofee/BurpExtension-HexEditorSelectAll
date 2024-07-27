package net.portswigger.burp.extensions.hexeditorselectall;

import burp.api.montoya.extension.ExtensionUnloadingHandler;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

class MyExtensionUnloadingHandler implements ExtensionUnloadingHandler {

    private final MyAWTEventListener listener;

    MyExtensionUnloadingHandler(MyAWTEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void extensionUnloaded() {
        try {
            Toolkit.getDefaultToolkit().removeAWTEventListener(this.listener);
        } catch (Exception ignored) {}
    }
}
