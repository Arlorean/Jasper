// http://www.webbasedprogramming.com/Java-Expert-Solutions/ch13.htm
// (c) Mark Wutka

import java.applet.*;
import java.net.*;
import java.awt.*;

// This class provides an applet stub for applets running
// as standalone applications. You can set the document base
// by setting the "docbase" system property. Likewise, you can set
// the code base through the "codebase" property.
// You can provide applet parameters by setting system properties
// with the applet's name followed by the parameter. For example:
// <PARAM name="stooge" value="moe">
// for an applet named MyApplet, could be set in this stub
// with by setting the system property "MyAppletstooge" to "moe".
// You can also just set the "stooge" property, but it will try
// using the appletname in front first. This allows you to run
// multiple applets at once that have the same parameter names.


public class RunAppletStub extends Object implements AppletStub
{
    Frame appletFrame;
    Applet applet;
    String appletName;
    String startDir;

    public RunAppletStub()
    {
    }

    // startDir is the local directory where this applet is started, or
    // another directory if you prefer. If you don't specify a code base
    // or a document base, the startDir is used for those. The directory
    // separators must be '/' and not '\' or the URL class gets confused.

    public RunAppletStub(Frame appletFrame, Applet applet, String name,
        String startDir)
    {
        this.appletFrame = appletFrame;
        this.applet = applet;
        this.appletName = name;
        this.startDir = startDir;

        RunAppletContext.instance().addApplet(applet, name);
    }

    public void setParams(Frame appletFrame, Applet applet, String name,
        String startDir)
    {
        this.appletFrame = appletFrame;
        this.applet = applet;
        this.appletName = name;
        this.startDir = startDir;

        RunAppletContext.instance().addApplet(applet, name);
    }

    public boolean isActive() { return true; }

    // Return the document base URL. Try getting the docbase system parameter.
    // If that isn't available, use the startDir directory.

    public URL getDocumentBase()
    {
        String docbase = System.getProperty("docbase");

        try {
            if (docbase == null) {
                return new URL("file://"+startDir);
            } else {
                return new URL(docbase);
            }
        } catch (MalformedURLException e) {
            return null;
        }
    }

    // Return the code base URL. Try getting the codebase system parameter.
    // If that isn't available, use the startDir directory.

    public URL getCodeBase()
    {
        String codebase = System.getProperty("codebase");

        try {
            if (codebase == null) {
                return new URL("file://"+startDir);
            } else {
                return new URL(codebase);
            }
        } catch (MalformedURLException e) {
            return null;
        }
    }

    // fetch a parameter for the applet from the system properties. First
    // try the applet name followed by the param name. If that's null,
    // try just the param name.

    public String getParameter(String paramName)
    {
        String prop = System.getProperty(appletName+paramName);
        if (prop != null) return prop;
        return System.getProperty(paramName);
    }

    public AppletContext getAppletContext()
    {
        return RunAppletContext.instance();
    }

    // appletResize is the only reason we need a reference to the applet's
    // frame. If the applet wants to resize, we resize the frame, then
    // the applet.

    public void appletResize(int width, int height)
    {
        appletFrame.resize(width+10, height+20);
        applet.resize(width, height);
    }
}