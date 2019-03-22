// http://www.webbasedprogramming.com/Java-Expert-Solutions/ch13.htm
// (c) Mark Wutka

import java.applet.*;
import java.util.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

// This class provides a generic applet context for standalone
// applications. It is implemented as a singleton object, which
// means that there is only one instance of this class within the
// runtime environment. It stores all the loaded applets in a
// hash table so it can provide working getApplet and getApplets methods.

public class RunAppletContext extends Object implements AppletContext, AudioClip {

    // The pointer to the lone instance of this class
    protected static RunAppletContext context;

    // The table of all the known applets in the runtime environment.
    protected Hashtable applets;

    protected RunAppletContext() {
        applets = new Hashtable();
    }
    // Returns the lone instance of the RunAppletContext. If there isn't
    // an instance, it creates a new one.

    public synchronized static RunAppletContext instance() {
        if (context == null) {
            context = new RunAppletContext();
        }
        return context;
    }

    // Adds an applet to the table of known applets

    public void addApplet(Applet applet, String name) {
        applets.put(name, applet);
    }

    // Locates an applet in the table

    public Applet getApplet(String name) {
        return (Applet) applets.get(name);
    }

    // Returns an enumeration of all the known applets

    public Enumeration getApplets() {
        return applets.elements();
    }

    // Tries to load an audio clip using Sun's AppletAudioClip
    // which is distributed with the JDK. This class may not be
    // available in all Java implementations since it is not a
    // documented part of the JDK.

    public AudioClip getAudioClip(URL url) {
        return null;
    }

    // Uses the AWT Toolkit class to fetch an image from a URL

    public Image getImage(URL url) {
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    // Since we aren't running in a browser and there aren't really
    // any classes to render HTML in Java, we have to wimp out with
    // the showDocument method and just print a message that the
    // applet wanted to load a URL.

    public void showDocument(URL url) {
        System.out.println("Wanted to show document on: " + url);
    }

    public void showDocument(URL url, String target) {
        System.out.println("Wanted to show document on: " + url + " in frame " + target);
    }

    // Just print to System.out for showStatus.

    public void showStatus(String status) {
        System.out.println(status);
    }

    // If we can't create an instance of sun.applet.AppletAudioClip, we
    // return a pointer to this same object, which happens to also implement
    // the AudioClip interface, but it doesn't do anything with them.
    // The following three methods are the methods for AudioClip:

    public void play() {
    };

    public void loop() {
    };

    public void stop() {
    }

    @Override
    public void setStream(String key, InputStream stream) throws IOException {

    }

    @Override
    public InputStream getStream(String key) {
        return null;
    }

    @Override
    public Iterator<String> getStreamKeys() {
        return null;
    };
}
