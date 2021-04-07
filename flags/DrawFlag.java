import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/**
 * Will draw a GUI flag
 * @author Jayden
 * @version 1/04/21
 */
public class DrawFlag{
    private final static float WIDTH = 600;
    private final static float HEIGHT = 300;
    /**
     * Constructor for objects of class DrawFlag
     */
    public DrawFlag(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);  // Comment out to checkstyle
    }

    /**
     * Draws a horizontal flag with given colours
     */
    private static void drawHorizontalFlag(ArrayList<Color> colors) {
        double lineHeight = HEIGHT / colors.size(); // Determines vertical spacing
        for (int i = 0; i < colors.size(); i++) { // Draws each color
            UI.setColor(colors.get(i));
            UI.fillRect(0, i * lineHeight, WIDTH, lineHeight);
        }
    }

    /**
     * Draws a vertical flag with given colors
     */
    private static void drawVerticalFlag(ArrayList<Color> colors) {
        double lineWidth = WIDTH / colors.size(); // Determines horizontal spacing
        for (int i = 0; i < colors.size(); i++) { // Draws each color
            UI.setColor(colors.get(i));
            UI.fillRect(i * lineWidth, 0, lineWidth, HEIGHT);
        }
    }

    /**
     * Sets colors and draws flag
     */
    public static void main(String[] args){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(Color.BLACK);
        flagDesign.add(Color.RED);
        flagDesign.add(Color.YELLOW);
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

}

