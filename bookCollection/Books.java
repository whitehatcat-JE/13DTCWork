import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu
 * maybe delete if we have time
 * prevent user from having a duplicate?
 * 
 * @author Jayden
 * @version (A version number or date)
 */
public class Books {
    // Instance Variables
    private HashMap<Integer, Book> booksMap;
    private int currBookID;

    /**
     * Constructor for objects in class Books
     */
    public Books() {
        // Initialise instance variables
        booksMap = new HashMap<Integer, Book>(); // Initialise hashmap

        // Creating books
        Book1 b1 = new Book(1, "Pet Semetary", "Stephen  King", 76);
        Book b2 = new Book(2, "1984", "George Orwell", 66);
        Book b3 = new Book(3, "The subtle knife", "Phillip Pullman", 42);
        Book b4 = new Book(4, "The subtle art of not giving a F*ck", "George Washington", 99);

        // Add Books to collection
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);

        this.currBookId = 4;
    }

    /**
     * Adds a book to the map
     */
    public void addBook() {
        final int MAX_QUANTITY = 99;
        int quantity = -1;

        // Ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");

        // Check boundaries for the number of books added to stock
        do {
            quantity = UI.askInt("Quantity: ")
        } while (0 > quantity || quantity > MAX_QUANTITY);

        // Increment the book ID counter and add book to hashmap
        currBookId++;
        booksMap.put(currBookId, new Book(currBookId, name, author, quantity));
    }

    /**
     * Finds a book based on the id
     * should refactor to find on name
     */
    public void findBook() {
        int bookId = UI.askInt("Id: ");     // Finds book on ID - change to title
        booksMap.get(bookId)
    }

    /**
     * Prints detail of all books
     */
    public void printAll() {
        for (int bookId : booksMap.keySet()) {
            UI.println(bookId + "Details: ");
            UI.println(booksMap.get(bookId).getName() + " "
                + booksMap.get(bookId).getAuthor() + " "
                + booksMap.get(bookId).getQuantity());
        }
    }



    /**
     * Menu to print and call appropriate methods
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(Q)uit");

            choice = UI.askString("Enter a choice: ");

            if (choice.equalsIgnoreCase("A")) {
                addBook();
            } else if (choice.equalsIgnoreCase("F")) {
                findBook();
            } else if (choice.equalsIgnoreCase("P")) {
                printAll();
            } else if (choice.equalsIgnoreCase("Q")) {
                UI.println("Goodbye!");
                UI.quit();
            } else {
                UI.println("Wrong.");
            }
        } while (!choice.equalsIgnoreCase("Q"));
    }
}