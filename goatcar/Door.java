/**
 * Manages an individual door
 * @author Jayden
 * @version 21:05:21
 */
import ecs100.*;
public class Door {
    private boolean isCar = false;
    private int x;
    private int y;

    // Methods
    public void isWinner(boolean winner) {
        isCar = winner;
    }

    public void open() {
        if (isCar) {
            UI.drawImage("imgs\\car.png", x, y, 100, 200);
        } else {
            UI.drawImage("imgs\\goat.png", x, y, 100, 200);
        }
    }

    public void regen(int x, int y) {
        UI.drawImage("imgs\\door.jpg", x, y, 100, 200);
    }
}