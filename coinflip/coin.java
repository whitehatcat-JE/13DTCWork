
/**
 * Making a coin object
 *
 * @author Jayden
 * @version 19/02/2021
 */
public class coin
{
    private final int HEADS = 0;
    private int face; // current side showing
    
    /**
     * Setup this coin
     */
    public coin()
    {
        this.flip();
    }
    
    public void flip()
    {
        face = (int) (Math.random() * 2);
    }
    
    /**
     * @return bool Returns true if the current face of the coin is heads
     */
    public boolean isHeads()
    {
        return (face == HEADS);
    }
    
    /**
     * @return Returns the current face of this coin as a String
     */
    public String toString()
    {
        return (face == HEADS) ? "Heads" : "Tails";
    }
    
    
}
