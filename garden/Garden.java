import ecs100.*;
import java.awt.Color;

/**
 * Create the garden
 * 
 * @author Jayden
 * @version 13/04/2021
 */

 public class Garden {
     private Flower f1 = new Flower(50, 100, 20, 50, Color.BLUE);
     private Flower f2 = new Flower(100, 100, 30, 50, Color.PINK);
     private Flower f3 = new Flower(150, 100, 10, 50, Color.RED);

    /**
     * Constructor for objects in class Garden
     */
    public Garden() {
        UI.initialise();
        UI.addButton("Grow", this::growGarden);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Script to animate drawing the flowers
     */
    public void growGarden() {
        f1.draw();
        f2.draw();
        f3.draw();
        f1.grow();
        f2.grow();
        f1.grow();
        f3.grow();
        f2.erase();
    }

    /**
     * Main routine
     */
    public static void main(String[] args) {
        Garden obj = new Garden();

    }
    
 }