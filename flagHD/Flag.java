/**
 * Draws the flag and manages wind movement
 * 
 * @author Jayden
 * @version 6/05/2021
 */
import ecs100.*;
import java.awt.Color;

public class Flag {
    // Constants
    private final double FLAGHEIGHT = 50.0;
    private final double FLAGWIDTH = 100.0;
    private final double FLAGDIVISIONS = 3;

    private final Color COLORA = Color.BLACK;
    private final Color COLORB = Color.YELLOW;
    private final Color COLORC = Color.RED;

    private final double RISEAMT = 5.0;
    
    // Variables
    private double flagX;
    private double flagY;
    private double riseA = 0.0;
    private double riseB = 0.0;
    private double riseC = 0.0;
    

    // Methods
    /**
     * DrawFlag changes the coordinates of the flag
     * @param x    X position of new flag
     * @param y    Y position of new flag
     */
    public void drawFlag(double x, double y) {
        flagX = x;
        flagY = y;
        updateFlag();

    }

    /**
     * Adjusts the flag sway amt in the wind
     */
    public void sway(){
        if (riseA > 0.0) {
            riseA = 0.0;
            riseB = RISEAMT;
        } else if (riseB > 0.0) {
            riseB = 0.0;
            riseA = -RISEAMT;
        } else if (riseA < 0.0) {
            riseA = 0.0;
            riseB = -RISEAMT;
        } else {
            riseA = RISEAMT;
            riseB = 0.0;
        }
        updateFlag();
    }

    /**
     * Refreshes the flag
     */
    private void updateFlag() {
        clearFlag();
        double lineSpacing = FLAGWIDTH/FLAGDIVISIONS;

        UI.setColor(COLORA);
        UI.fillRect(flagX, flagY, lineSpacing, FLAGHEIGHT);
        UI.setColor(COLORB);
        UI.fillRect(flagX+lineSpacing, flagY+riseB, lineSpacing, FLAGHEIGHT);
        UI.setColor(COLORC);
        UI.fillRect(flagX+lineSpacing*2, flagY+riseA, lineSpacing, FLAGHEIGHT);
    }
    /**
     * Clear clears the screen of the current flag
     * @param x    X position of flag to clear
     * @param y    Y position of flag to clear
     */
    private void clearFlag() {
        UI.eraseRect(flagX, flagY-RISEAMT, FLAGWIDTH, FLAGHEIGHT+RISEAMT*2);
    }

    /**
     * Adjusts the height of the flag
     * @param y    Amount to adjust flagY by
     */
    public void changeHeight(double y) {
        clearFlag();
        flagY = y;
    }

}