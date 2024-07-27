package net.portswigger.burp.extensions.hexeditorselectall;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

import java.awt.AWTEvent;
import java.awt.Toolkit;

public class HexEditorSelectAll implements BurpExtension {
    @Override
    public void initialize(MontoyaApi api)
    {
        api.extension().setName("HexEditor Select All");

        MyAWTEventListener listener = new MyAWTEventListener();

        // Register unloading event to remove listeners
        api.extension().registerUnloadingHandler(new MyExtensionUnloadingHandler(listener));

        // Register keyboard event
        Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);
    }
}
