
/**
 * Creates a car and stores information on it
 *
 * @author Jayden
 * @version 18/02/21
 */
public class Car
{
    // instance variables - replace the example below with your own
    private String colour;
    private String model;
    private String make;
    private String owner;
    private double speed;

    /**
     * Constructor for objects of class Car
     */
    public Car(String col, String modelType, String brand, String buyer, double velocity)
    {
        // initialise instance variables
        colour = col;
        model = modelType;
        make = brand;
        owner = buyer;
        speed = velocity;
    }

    /**
     * Accelerate Vehicle
     */
    public double accelerateVehicle(double acceleration)
    {
        return this.speed * acceleration;
    }
    
    /**
     * Honk the horn
     */
    public void honk()
    {
        System.out.println("BEEP BEEEEEEEP");
    }
    
    /**
     * Return car speed
     */
    public double getSpeed()
    {
        return this.speed;
    }
    
    public String getColour()
    {
        return this.colour;
    }
    
    public static void main(String[] args)
    {
        Car tesla = new Car("Black", "Cybertruck", "Tesla", "Jayden", 10);
        tesla.honk();
        System.out.println(tesla.getSpeed());
        tesla.speed = tesla.accelerateVehicle(1.5);
        System.out.println(tesla.getSpeed());
    }
}
