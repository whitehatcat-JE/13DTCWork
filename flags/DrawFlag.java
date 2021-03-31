import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/**
 * Will draw a GUI Lollipop
 * @author Jayden
 * @version 1/04/21
 */
public class DrawFlag{
    private final float WIDTH = 600;
    private final float HEIGHT = 300;
    /**
     * Constructor for objects of class DrawFlag
     */
    public DrawFlag(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);  // Comment out to checkstyle
    }

    /**
     * Draw a red v on a stick
     */
    private void drawHorizontalFlag(ArrayList<Color> colors) {
        double lineHeight = HEIGHT / colors.size();
        for (int i = 0; i < colors.size(); i++) {}
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

