
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
    
    /**
     * Returns age
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * returns age in cat years
     */
    public double catYears()
    {
        double catAge; //Declaring var
        if (this.age <= 2) {
            catAge = this.age * 10.5;
        } else {
            catAge = (this.age - 2) * 4 + 21;
        }
        return catAge;
    }
    
    /**
     * Returns colour
     */
    public String colour()
    {
        return this.colour;
    }
    
    /**
     * Returns hair type
     */
    public String getHair()
    {
        return this.hair;
    }
    /**
     * Create 2 dogs. Make them bark.
     */
    public static void main(String[] args)
    {
        Cat ape = new Cat("Brown", "Long", 4);
        Cat can = new Cat("Fat", "Short", 14);
        ape.bark();
        can.bark();
        System.out.println(ape.getAge());
        System.out.println(can.getAge());
        System.out.println(ape.catYears());
        System.out.println(can.catYears());
        System.out.println(ape.colour());
        System.out.println(can.colour());
        System.out.println(ape.getHair());
        System.out.println(can.getHair());
        
        Cat henry = new Cat("Grey", "Spikey", 7);
        henry.bark();
        
    }
}
