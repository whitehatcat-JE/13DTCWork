import ecs100.*;
import java.awt.Color;

/**
 * Flower support class
 * Creates a flower of a size and color.
 * Can grow.
 * 
 * @author Jayden
 * @version 9/04/2021
 */

 public class flower {
    // instance Variables
    private double flowerX = -100; // x pos of flower
    private double flowerY = -100; // y pos of flower

    private int flowerSize; // size of flower
    private int flowerHeight // height of flower

    private double left; // left of flower
    private double right; // right of flower
    private double bottom; // bottom of flower
    private double top; // top of flower

    private Color color; // color of flower

    /**
     * Constructor for objects of class flower
     */
    public flower(double x, double y, int size, int stem, Color col) {
        flowerX = x;
        flowerY = y;
        flowerSize = size;
        flowerHeight = stem;
        color = col;

        // set the top, left, bottom
        setTop();
        setLeft();
        setBottom();
    }

    /**
     * Set left
     */
    public void setLeft() {
        left = flowerX - flowerSize/2.0;
    }

    /**
     * Set top
     */
    public setTop() {
        top = flowerY - flowerSize/2.0;
    }

    /**
     * Set bottom
     */
    public setBottom() {
        bottom = flowerY + flowerHeight;
    }

    /**
     * Draws the flower on screen
     */
    public void draw() {
        // draw stem
        UI.setColor(Color.GREEN); // set color of stem
        UI.setLineWidth(2); // set the width of the stem
        UI.drawLine(flowerX, flowerY, flowerX, bottom); // draw in stem

        // draw flower
        UI.setColor(color); // set color of flower
        UI.fillOval(left, top, flowerSize, flowerSize); // draw the flower
        // wait
        UI.sleep(500);
    }

    /**
     * Erase a rectangle around the current obj
     */
    public void erase() {
        UI.eraseRect(left-1, top-1, flowerSize+1, bottom+1);
    }

    /**
     * Make the flower grow
     */
    public void grow() {
        erase();
        flowerY -= 10; // increase the height
        flowerSize += 10; // increase the bulb

        // set the new position
        setTop();
        setLeft();
        setDraw();
    }
 }