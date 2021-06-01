import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 * Draws shapes
 * @author Jayden
 * @version 15/04/2021
 */

public class DrawShape {
    public DrawShape() {
        UI.initialise();
        UI.addButton("Quit", UI::quit);
    }


    public void doMouse(String action, double x, double y) {
        final int SIZE = 50;
        if (action.equals("clicked")) {
            UI.fillOval(x, y, SIZE, SIZE);
        }
    }

    /**
     * Make a random button
     */
    public void changeColor() {
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }

    /**
     * Main routine
     */
    public static void main(String[] args) {
        DrawShape obj = new DrawShape();
        UI.addButton("Change Color", obj::changeColor);
        UI.setMouseListener(obj::doMouse);
    }
}