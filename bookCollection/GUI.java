import ecs100.*;
/**
 * Class to handle the GUI functionality
 * 
 * @author Jayden
 * @version 27/5/2021
 */
public class GUI {
    /**
     * Constructor for objects of class GUI
     */
    public GUI() {
        Books bk = new Books();
        UI.initialise();
        UI.addButton("All", bk::printAll);
        UI.addButton("Find", bk::findBook);
        UI.addButton("Add", bk::addBook);
        UI.addButton("Quit", UI::quit);
    }
}