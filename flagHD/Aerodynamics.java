/**
 * Manages drawing of the enviroment and flag, 
 * as well as responses to inputs and general
 * GUI setup.
 * 
 * @author Jayden
 * @version 6/05/2021
 */
import ecs100.*;
public class Aerodynamics {
    // Constants
    private final float STARTINGWINDSPEED = 1;
    private final float STARTINGRAISESPEED = 1;
    private final float FLAGX = 100;
    private final float FLAGY = 100;
    private final float MAXFLAGY = 250;
    private final float MINFLAGY = 50;

    // Variables
    private float windSpeed;
    private float raiseSpeed;

    // Methods
    /**
     * Constructor for objects in class Aerodynamics
     */
    public Aerodynamics() {
        windSpeed = STARTINGWINDSPEED;
        raiseSpeed = STARTINGRAISESPEED;
    }

    /**
     * Main routine for creating the GUI
     */
    public static void main(String[] args) {
        
    }

 } 