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
    private final double STARTINGFLAGX = 100;
    private final double FLAGY = 100;
    private final double MAXFLAGY = 250;
    private final double MINFLAGY = 50;
    private final double MAXSPEED = 100;
    private final double MAXAMT = 300;
    private final double MAXY = 1000;
    private final double MINY = 0;


    // Variables
    private double windSpeed;
    private double raiseSpeed;
    private double 

    // Methods
    /**
     * Constructor for objects in class Aerodynamics
     */
    public Aerodynamics() {
        windSpeed = STARTINGWINDSPEED;
        raiseSpeed = STARTINGRAISESPEED;
    }

    /**
     * Increases the flag height
     */
    public void raiseFlag() {

    }

    /**
     * Decreases the flag height
     */
    public void lowerFlag() {

    }

    /**
     * Changes the raise amt
     */
    public void raiseAmt(double amt) {

    }

    /**
     * Changes the raise speed
     */
    public void raiseSpeed(double amt) {

    }

    /**
     * Main routine for creating the GUI
     */
    public static void main(String[] args) {
        Aerodynamics aero = new Aerodynamics();
        Flag flag = new Flag();
        Enviroment enviro = new Enviroment();
        
        UI.addButton("Up", aero::raiseFlag);
        UI.addButton("Down", aero::lowerFlag);
        UI.addSlider("Distance", 0, MAXDISTANCE, aero::raiseAmt);
        UI.addSlider("Speed", 0, MAXSPEED, aero::raiseSpeed);
        enviro.drawEnviroment();
        double counter = 0;
        flag.drawFlag(100.0, 100.0 + Math.sin(counter/10)*10.0);
        while (true){
            UI.sleep(500);
            flag.sway();
        }
    }

 } 