
// http://www.webbasedprogramming.com/Java-Expert-Solutions/ch13.htm
// (c) Mark Wutka

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.applet.*;

// StandaloneApplet is an applet that runs either as
// an applet or a standalone application.  To run
// standalone, it provides a main method that creates
// a frame, then creates an instance of the applet and
// adds it to the frame.

public class Main {

    public static void main(String args[]) throws Exception
    {
        // Pass snapshot file in as optional first argument
        if (args.length == 1) {
            System.setProperty("snapshot", args[0]);
        }

        // Set current directory as "docbase" for applet
        System.setProperty("docbase", new File(".").toURI().toURL().toString());

        // Fire interrupt 50 times per second (20ms) and sleep in between
        System.setProperty("sleepHack", "20");

        // Create the frame this applet will run in
        Frame appletFrame = new Frame("Jasper");

        // The frame needs a layout manager, use the GridLayout to maximize
        // the applet size to the frame.
        appletFrame.setLayout(new GridLayout(1,0));

        // Make the frame appear on the screen. You should make the frame appear
        // before you call the applet's init method. On some Java implementations,
        // some of the graphics information is not available until there is a frame.
        // If your applet uses certain graphics functions like getGraphics() in the
        // init method, it may fail unless there is a frame already created and
        // showing.
        appletFrame.show();

        // Close the applet frame when the window close button is pressed.
        appletFrame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        } );

        // Create an instance of the applet
        Applet myApplet = new Jasper();

        // Add the applet to the frame
        appletFrame.add(myApplet);

        // Now try to get an applet stub for this class.

        RunAppletStub stub = new RunAppletStub(appletFrame,
            myApplet, "standalone-applet", null);
        myApplet.setStub(stub);

        // Initialize and start the applet
        myApplet.init();
        myApplet.start();

     }
}
