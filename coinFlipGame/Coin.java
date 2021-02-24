
/**
 * Creates a coin able to flip
 *
 * @author Jayden
 * @version 25/02/21
 */
public class Coin
{
    //Instance variables
    private final int HEADS = 0;
    private int face;
    
    /**
     * Flips the coin
     */
    public void flip()
    {
        face = (int) (Math.random() * 2);
    }
    
        public boolean isHeads()
    {
        return (face == HEADS);
    }
}
