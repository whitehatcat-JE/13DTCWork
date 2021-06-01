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
    private double lineSize = 10;
    private String tool = "circle";

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

    public void changeLineSize(double size) {
        lineSize = size; 
        UI.setLineWidth(lineSize);
    }

    /**
     * Clear canvas
     */
    public void doClear() {
        UI.eraseRect(0, 0, 10000, 10000);
    }
    
    /**
     * Mouse actioner
     */
    public void doMouse(String action, double x, double y) {
        if (tool == "line") {
            if (action.equals("pressed")) {
                startX = x;
                startY = y;
            } else if (action.equals("released")) {
                UI.drawLine(startX, startY, x, y);
            }
        } else {
            if (action.equals("dragged") || action.equals("pressed")) {
                if (tool == "square") {
                    UI.fillRect(x - lineSize/2, y - lineSize/2, lineSize, lineSize);
                } else if (tool == "circle") {
                    UI.fillOval(x - lineSize/2, y - lineSize/2, lineSize, lineSize);
                } 
            }
        }
    }

    /**
     * Sets tool to circle
     */
    public void setCircle(){
        tool = "circle";
    }

    /**
     * Sets tool to square
     */
    public void setSquare(){
        tool = "square";
    }

    /**
     * Sets tool to line
     */
    public void setLine(){
        tool = "line";
    }

    /**
     * Main routine
     */
    public static void main(String[] args) {
        LineDrawer obj = new LineDrawer();
        UI.setLineWidth(50); 
        UI.setMouseListener(obj::doMouse);
        UI.setMouseMotionListener(obj::doMouse);

        UI.addButton("Tool: Circle", obj::setCircle);
        UI.addButton("Tool: Square", obj::setSquare);
        UI.addButton("Tool: Line", obj::setLine);

        UI.addButton("Color", obj::doChooseColor);
        UI.addButton("Reset", obj::doClear);
        UI.addSlider("Thickness", 0, 101, obj::changeLineSize);
    }

 }