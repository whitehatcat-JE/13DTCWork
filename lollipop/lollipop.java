import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/**
 * Will draw a GUI Lollipop
 * @author Jayden
 * @version 1/04/21
 */
public class lollipop{
    /* Fields */
    private final double THICKNESS = 8.0; // Thickness compared to sizer
    private final double SIZEDEMODIFIER = 2.0;
    private final Color STICKCOLOR = Color.white;
    private final Color LOLLIPOPCOLOR = Color.red; // new Color((float) Math.random(), (float)Math.random(), (float)Math.random());

    /**
     * Constructor for objects of class lollipop
     */
    public lollipop(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);  // Comment out to checkstyle
    }

    /**
     * Draw a red lollipop on a stick
     */
    private void drawLollipop(double x, double y, double size, double stick) {
        double left = x-size/SIZEDEMODIFIER; // left of the lollipop
        double top = y-size/SIZEDEMODIFIER; // top of the lollipop
        double bottom = y+stick; // bottom of the lollipop
        /* Drawing our stick */
        // set line width to 10
        UI.setColor(STICKCOLOR);
        UI.setLineWidth(size/ THICKNESS);
        // Draw line (300, 200) to (300, 400)
        UI.drawLine(x, y, x, bottom);
        /* Draw our lollipop */
        // Set line width to 1
        UI.setLineWidth(1);
        UI.setColor(LOLLIPOPCOLOR);
        UI.fillOval(left, top, size, size);
    }

    /**
     * Draw a lollipop and ask the user for its size
     */
    public void doDrawLollipop() {
        double diam = UI.askDouble("Diameter: ");
        this.drawLollipop(300, 180, diam, 200);
    }

    /**
     * Executes the lollipop script
     */
    public static void main(String[] args){
        lollipop obj = new lollipop();
        obj.doDrawLollipop();
    }

}

