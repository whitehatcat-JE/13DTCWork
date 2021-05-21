/**
 * Proves a monty theory thing
 * @author Jayden
 * @version 21:05:21
 */
import ecs100.*;
import java.awt.Color;

 public class Stage {
    // Constants

    // Variables
    private Door doorA = new Door();
    private Door doorB = new Door();
    private Door doorC = new Door();

    private int doorWidth = 100;
    private int doorHeight = 200;

    private int doorY = 100;

    private int doorXA = 50;
    private int doorXB = 150;
    private int doorXC = 250;


    // methods
    private void openDoorA() {
        doorA.open();
    }

    private void openDoorB() {
        doorB.open();
    }

    private void openDoorC() {
        doorC.open();
    }

    private void clickDoors(String action, double x, double y) {
        if ((doorY < y) && (doorY + doorHeight > y)) {
            if ((doorXA < x) && (doorXA + doorWidth > x)) {
                openDoorA();
                System.out.println("Nope");
            } else if ((doorXB < x) && (doorXB + doorWidth > x)) {
                openDoorB();
            } else if ((doorXC < x) && (doorXC + doorWidth > x)) {
                openDoorC();
            }
        }
    }

    public static void main(String[] args) {
        UI.initialise();
        Stage s = new Stage();
        s.doorA.regen(s.doorXA, s.doorY);
        s.doorB.regen(s.doorXB, s.doorY);
        s.doorC.regen(s.doorXC, s.doorY);
        UI.setMouseListener(s::clickDoors);
    }
 }