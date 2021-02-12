
/**
 * Cats have hair colour and type
 * As defined here they can only bark
 * 
 * @author Jayden Everest 
 * @version 11/02/21
 */
public class Cat
{
    // fields
    private String colour;
    private String hair;
    private int age;

    /**
     * Constructor for objects of class Cat
     * Construct a new Cat object
     * 
     * @param col  a string for the colour of the cat's hair
     * @param hairtype  a string for the type of hair the cat has
     * @param years  an int giving the cats age in years
     */
    public Cat(String col, String hairtype, int years)
    {
        // initialise instance variables
        colour = col;
        hair = hairtype;
        age = years;
    }

    /**
     * prints "Woof!"
     */
    public void bark()
    {
        // put your code here
        System.out.println("Wolf!");
    }
}
