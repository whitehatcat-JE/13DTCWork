
/**
 * This is the brain of a car
 *
 * @author Jayden
 * @version 18/02/21
 */
public class Car
{
    // instance variables
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
    private int posX;
    private int posY;
    private Direction facing;

    
    /**
     * Sets up the cars position
     * 
     * @param xPosition     The initial x starting position
     * @param yPosition     The initial y starting position
     * @param face          Direction the car is facing
     */
    public Car(int xPosition, int yPosition, Direction face)
    {
        // initialise instance variables
        posX = xPosition;
        posY = yPosition;
        facing = face;
    }
    
    /**
     * Moves the car in the facing direction
     * 
     * @param distance      Moves the car by the given amount
     */
    public void move(int distance)
    {
        if (facing == Direction.UP) {
            this.posY = this.posY + distance;
        } else if (facing == Direction.DOWN) {
            this.posY = this.posY - distance;
        } else if (facing == Direction.LEFT) {
            this.posX = this.posX + distance;
        } else {
            this.posX = this.posX - distance;
        }
    }
}
