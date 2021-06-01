/**
 * Draws and manages the background art/enviroment
 * @author Jayden
 * @version 7/05/21
 */
import ecs100.*;
import java.awt.Color;
public class Enviroment {
    // Constants
    private final double POLEHEIGHT = 350;
    private final double POLEWIDTH = 10;
    private final double POLEX = 90;
    private final double POLEY = 100;

    private final double GROUNDHEIGHT = 1000;
    private final double GROUNDWIDTH = 1000;
    private final double GROUNDX = 0;
    private final double GROUNDY = 400;

    private final Color POLECOLOR = Color.BLACK;
    private final Color GROUNDCOLOR = Color.GREEN;
    // Variables

    // Methods
    public void drawEnviroment() {
        UI.setColor(POLECOLOR);
        UI.fillRect(POLEX, POLEY, POLEWIDTH, POLEHEIGHT);
        UI.setColor(GROUNDCOLOR);
        UI.fillRect(GROUNDX, GROUNDY, GROUNDWIDTH, GROUNDHEIGHT);
    }
}