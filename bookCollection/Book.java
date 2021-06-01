/**
 * Support class of book
 * A book contains an id, name, author, quantity, image
 * 
 * @author Jayden  
 * @version 27/05/2021
 */
import java.util.HashMap;
import ecs100.*;
public class Book {
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "book.jpeg";

    /**
     * Constructor for objects of class Book
     */
    public Book(int ID, String nm, String auth, int qty, String img) {
        this.id = ID;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.image = img;
    }

    /**
     * Constructor overloading
     */
    public Book(int ID, String nm, String auth, int qty) {
        this(ID, nm, auth, qty, DEFAULT_IMAGE);
    }

    /**
     * Getter for id
     * @return  int the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for name
     * @return  String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for author
     * @return  String author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Getter for quantity
     * @return  int quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Display our image on our GUI
     */
    public void displayBook() {
        double locX = 100.0;
        double locY = 100.0;
        final double WIDTH = 100.0;
        final double HEIGHT = 100.0;

        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
}