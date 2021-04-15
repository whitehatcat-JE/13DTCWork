import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Draw a line, using the esc100 library.
 * 
 * @author Jayden
 * @version 15/04/2021
 */

 public class LineDrawer {
    // Fields
    private double startX, startY; // fields to remember the "pressed" pos
    private Color currentColor = Color.BLACK; // Current color
    private int lineSize = 10;

    /**
     * Constructor for objects in class LineDrawer
     */
    public LineDrawer() {
        UI.initialise();
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Color chooser
     */
    public void doChooseColor() {
        currentColor = JColorChooser.showDialog(null, "Choose Color", currentColor);
        UI.setColor(currentColor);
    }

    /**
     * Increases line size
     */
    public void increaseLineSize() {
        lineSize++;
        UI.setLineWidth(lineSize); 
    }

    /**
     * Decrease line size
     */
    public void decreaseLineSize() {
        if (lineSize > 0) {
            lineSize--;
        }
        UI.setLineWidth(lineSize); 
    }

    /**
     * Clear canvas
     */
    public void doClear() {
        UI.eraseRect(0, 0, 1000, 1000);
    }

    /**
     * Mouse actioner
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            startX = x;
            startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(startX, startY, x, y);
        }
    }

    /**
     * Main routine
     */
    public static void main(String[] args) {
        LineDrawer obj = new LineDrawer();
        UI.setLineWidth(10); 
        UI.setMouseListener(obj::doMouse);
        UI.addButton("Color", obj::doChooseColor);
        UI.addButton("Increase", obj::increaseLineSize);
        UI.addButton("Decrease", obj::decreaseLineSize);
        UI.addButton("Reset", obj::doClear);
    }

 }