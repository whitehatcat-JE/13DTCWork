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
    private final double STARTINGWINDSPEED = 1.0;
    private final double STARTINGRAISESPEED = 50.0;
    private final double STARTINGFLAGX = 100.0;
    private final double FLAGY = 100.0;
    private final double MAXFLAGY = 245.0;
    private final double MINFLAGY = 50.0;
    private final double MAXAMT = 300.0;
    
    private final double MAXDISTANCE = 100.0;


    // Variables
    private double windSpeed;
    private double raiseSpeed;
    private double flagOffset = 0.0;
    private double distance = STARTINGRAISESPEED;

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
        flagOffset -= distance;
        if (flagOffset < 0.0) {
            flagOffset = 0.0;
        }
    }

    /**
     * Decreases the flag height
     */
    public void lowerFlag() {
        flagOffset += distance;
        if (flagOffset > MAXFLAGY) {
            flagOffset = MAXFLAGY;
        }
    }

    /**
     * Changes the raise amt
     */
    public void raiseAmt(double amt) {
        distance = amt;
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
        UI.addSlider("Distance", 0, aero.MAXDISTANCE, aero::raiseAmt);
        enviro.drawEnviroment();
        flag.drawFlag(100.0, 100.0);
        while (true){
            UI.sleep(500);
            flag.changeHeight(aero.FLAGY + aero.flagOffset);
            flag.sway();
        }
    }

 } 