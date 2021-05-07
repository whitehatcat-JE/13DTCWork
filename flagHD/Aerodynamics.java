/**
 * Manages drawing of the enviroment and flag, 
 * as well as responses to inputs and general
 * GUI setup.
 * 
 * @author Jayden
 * @version 6/05/2021
 */
import ecs100.*;
import java.lang.Math;
public class Aerodynamics {
    // Constants
    private final double STARTINGWINDSPEED = 1;
    private final double STARTINGRAISESPEED = 1;
    private final double FLAGX = 100;
    private final double FLAGY = 100;
    private final double MAXFLAGY = 250;
    private final double MINFLAGY = 50;

    // Variables
    private double windSpeed;
    private double raiseSpeed;

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
        Flag flag = new Flag();
        Enviroment enviro = new Enviroment();
        enviro.drawEnviroment();
        double counter = 0;
        flag.drawFlag(100.0, 100.0 + Math.sin(counter/10)*10.0);
        while (true){
            UI.sleep(500);
            flag.sway();
        }
    }

 } 