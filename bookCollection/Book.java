/**
 * Support class of book
 * A book contains an id, name, author, quantity, image
 * 
 * @author Jayden  
 * @version 27/05/2021
 */
public class Book {
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;

    /**
     * Constructor for objects of class Book
     */
    public Book(int ID, String nm, String auth, int qty) {
        this.id = ID;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
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
    public int getName() {
        return this.name;
    }

    /**
     * Getter for author
     * @return  String author
     */
    public int getAuthor() {
        return this.auth;
    }

    /**
     * Getter for quantity
     * @return  int quantity
     */
    public int getQuantity() {
        return this.qty;
    }
}