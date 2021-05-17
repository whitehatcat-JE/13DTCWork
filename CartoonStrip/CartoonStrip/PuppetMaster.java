import ecs100.*;
/**
 * User Interface to command the carton characters
 * 
 * @author Jayden
 * @version 4/05/21
 */
public class PuppetMaster {
    // fields to store values between events/method calls
    private static final int CANVASWIDTH = 1000;
    private static final int CANVASHEIGHT = 500; // ??
    private CartoonCharacter cc1 = new CartoonCharacter(200, 100, "casey");
    private CartoonCharacter cc2 = new CartoonCharacter(500, 100, "alice");
    private CartoonCharacter cc3 = new CartoonCharacter(800, 100, "bob");

    private CartoonCharacter selectedCC = cc1;  // Selected one
    private CartoonCharacter nonSelectedCC1 = cc2;
    private CartoonCharacter nonSelectedCC2 = cc3;

    private double walkDist = 20;
    // methods
    /**
     * Switch to alice
     */
    public void doAlice() {
        this.selectedCC = this.cc2;
        this.nonSelectedCC1 = this.cc1;
        this.nonSelectedCC2 = this.cc3;
    }

    /**
     * Switch to casey
     */
    public void doCasey() {
        this.selectedCC = this.cc1;
        this.nonSelectedCC1 = this.cc2;
        this.nonSelectedCC2 = this.cc3;
    }

    /**
     * Switch to bob
     */
    public void doBob() {
        this.selectedCC = this.cc3;
        this.nonSelectedCC1 = this.cc2;
        this.nonSelectedCC2 = this.cc1;
    }

    /**
     * Tell the cartoonCharacter to smile
     */
    public void doSmile() {
        this.selectedCC.smile();
    }

    /**
     * Tell the cartoonCharacter to frown
     */
    public void doFrown() {
        this.selectedCC.frown();
    }

    /**
     * Tell the cartoonCharacter to turn Left
     */
    public void doLeft() {
        this.selectedCC.lookLeft();
    }

    /**
     * Tell the cartoonCharacter to turn Right
     */
    public void doRight() {
        this.selectedCC.lookRight();
    }

    /**
     * Tell the cartoonCharacter to speak
     * @param text  The text cartoonCharacter will say
     */
    public void doSpeak(String text) {
        this.selectedCC.speak(text);
    }

    /**
     * Tell the cartoonCharacter to think
     * @param text  The text the cartoonCharacter will think
     */
    public void doThink(String text) {
        this.selectedCC.think(text);
    }

    /**
     * Set the distance to Walk
     * @param dist    New distance to change walkDist to
     */
    public void setDist(double dist) {
        this.walkDist = dist;
    }

    /**
     * Tell the cartoonCharacter to Walk
     */
    public void doWalk() {
        if (this.selectedCC.direction == "right") {
            if (nonSelectedCC1.characterX >= this.selectedCC.characterX + 70.0 + walkDist) {
                if (nonSelectedCC2.characterX >= this.selectedCC.characterX + 70.0 + walkDist) {
                    this.selectedCC.walk(walkDist);
                }
            }
        } else {
            if (nonSelectedCC1.characterX <= this.selectedCC.characterX - walkDist) {
                if (nonSelectedCC2.characterX <= this.selectedCC.characterX - walkDist) {
                    this.selectedCC.walk(walkDist);
                }
            }
        }
    }

    /**
     * Clear the graphics pane
     */
    private void clear() {
        UI.clearPanes(); // Clear the graphics pane
        UI.setDivider(0.0); // Hide the text pane
    }

    // main setup GUI
    public static void main(String[] args){
        // make a PuppetMaster object
        PuppetMaster pm = new PuppetMaster();

        final int DISTMIN = 1;
        final int DISTMAX = 100;
        final int DISINIT = 20;

        // setup the buttons, slider, textField, to call methods on the object
        UI.initialise();
        UI.setWindowSize(CANVASWIDTH, CANVASHEIGHT);

        // Buttons to switch selected character
        UI.addButton("Do Alice", pm::doAlice);
        UI.addButton("Do Casey", pm::doCasey);
        UI.addButton("Do Bob", pm::doBob);

        UI.addButton("Smile", pm::doSmile);
        UI.addButton("Frown", pm::doFrown);
        UI.addButton("Left", pm::doLeft);
        UI.addButton("Right", pm::doRight);
        UI.addTextField("Say", pm::doSpeak);
        UI.addTextField("Think", pm::doThink);
        UI.addButton("Walk", pm::doWalk);
        UI.addSlider("Distance", DISTMIN, DISTMAX, DISINIT, pm::setDist);

        // Add standard buttons
        UI.addButton("Clear", pm::clear);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0); // Must come after setting up button etc.
    }
}