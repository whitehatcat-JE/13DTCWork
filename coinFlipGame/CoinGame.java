
/**
 * Coin Game
 * Whoever gets three heads or tails first wins
 *
 * @author Jayden
 * @version 23/02/21
 */
public class CoinGame
{
    // instance variables - replace the example below with your own
    private int p1Tails;
    private int p1Heads;
    private int p2Tails;
    private int p2Heads;
    
    /**
     * The main game loop
     */
    public static void main(String[] args)
    {
        boolean running = true;
        boolean p1Win;
        boolean p2Win;
           
        while (running)
        {
            if (p1Tails == 3 || p1Heads == 3)
            {
                p1Win = true;
            }
            
            if (p2Tails == 3 || p2Heads == 3)
            {
                p2Win = true;
            }
            
            if (p1Win && p2Win)
            {
                System.out.println("Tie!");
                running = false;
            } else if (p1Win)
            {
                System.out.println("Player 1 Wins!");
                running = false;
            } else if (p2Win)
            {
                System.out.println("Player 2 Wins!");
                running = false;
            }
        }
    }
}
