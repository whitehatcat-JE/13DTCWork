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
    private final float WIDTH = 600;
    private final float HEIGHT = 300;
    /**
     * Constructor for objects of class DrawFlag
     */
    public DrawFlag(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);  // Comment out to checkstyle

        hungary();
    }

    /**
     * Draws a horizontal flag with given colours
     */
    private void drawHorizontalFlag(ArrayList<Color> colors) {
        double lineHeight = HEIGHT / colors.size(); // Determines vertical spacing
        for (int i = 0; i < colors.size(); i++) { // Draws each color
            UI.setColor(colors.get(i));
            UI.fillRect(0, i * lineHeight, WIDTH, lineHeight);
        }
    }

    /**
     * Draws a vertical flag with given colors
     */
    private void drawVerticalFlag(ArrayList<Color> colors) {
        double lineWidth = WIDTH / colors.size(); // Determines horizontal spacing
        for (int i = 0; i < colors.size(); i++) { // Draws each color
            UI.setColor(colors.get(i));
            UI.fillRect(i * lineWidth, 0, lineWidth, HEIGHT);
        }
    }

    /**
     * Draws Hungary
     */
    public void hungary(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(205,42,61));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(67,111,76));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Estonia
     */
    public void estonia(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(0,113,205));
        flagDesign.add(Color.BLACK);
        flagDesign.add(Color.WHITE);
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Thai
     */
    public void thai(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(160, 24, 47));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(44, 41, 72));
        flagDesign.add(new Color(44, 41, 72));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(160, 24, 47));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws French
     */
    public void french(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(0,34,144));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(230,40,55));
        // Draws flag
        drawVerticalFlag(flagDesign);
    }

    /**
     * Draws Dutch
     */
    public void dutch(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(170,26,38));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(0,34,144));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Belgium
     */
    public void belgium(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(35,31,32));
        flagDesign.add(new Color(255,242,0));
        flagDesign.add(new Color(237,28,36));
        // Draws flag
        drawVerticalFlag(flagDesign);
    }

    /**
     * Draws Botswana (Don't look too hard at this :))
     */
    public void botswana(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(Color.WHITE);
        flagDesign.add(Color.BLACK);
        flagDesign.add(Color.BLACK);
        flagDesign.add(Color.BLACK);
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        flagDesign.add(new Color(0,189,242));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Colombia
     */
    public void colombia(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(255,242,0));
        flagDesign.add(new Color(255,242,0));
        flagDesign.add(new Color(0,102,179));
        flagDesign.add(new Color(237,28,36));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Indonesia
     */
    public void indonesia(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(237,28,36));
        flagDesign.add(Color.WHITE);
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Latvia
     */
    public void latvia(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(158,6,33));
        flagDesign.add(new Color(158,6,33));
        flagDesign.add(Color.WHITE);
        flagDesign.add(new Color(158,6,33));
        flagDesign.add(new Color(158,6,33));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

    /**
     * Draws Mauritius
     */
    public void mauritius(){
        ArrayList<Color> flagDesign = new ArrayList<Color>();
        // Adds colors
        flagDesign.add(new Color(237,27,36));
        flagDesign.add(new Color(0,101,179));
        flagDesign.add(new Color(254,242,0));
        flagDesign.add(new Color(0,166,80));
        // Draws flag
        drawHorizontalFlag(flagDesign);
    }

}

