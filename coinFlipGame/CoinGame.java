/**
 * Coin Game
 * Whoever gets three heads or tails first wins
 *
 * @author Jayden
 * @version 23/02/21
 */
public class CoinGame
{
    //Constants
    private static int winAmt = 3;
    /**
     * The main game loop
     * @param running   Loops the script until a player wins
     * @param p1Win     Stays false unless the player1 wins
     * @param p2Win     Stays false unless player2 wins
     * 
     * @param p1Tails   How many times player1 has rolled tails
     * @param p1Heads   How many times player1 has rolled heads
     * @param p2Tails   How many times player2 has rolled tails
     * @param p2Tails   How many times player2 has rolled heads
     */
    public static void main(String[] args)
    {
        //Game tracking variables
        boolean running = true;
        boolean p1Win = false;
        boolean p2Win = false;
        
        int p1Tails = 0, p1Heads = 0, p2Tails = 0, p2Heads = 0;
        
        Coin nextCoin = new Coin(); //Coin the class uses to determine if the players flip heads or tails
        
        //Main game script loop
        while (running)
        {
            //Flips player1's coin
            nextCoin.flip();
            if (nextCoin.isHeads())
            {
                p1Heads++;
            } else
            {
                p1Tails++;
            }
            //Flips player2's coin
            nextCoin.flip();
            if (nextCoin.isHeads())
            {
                p2Heads++;
            } else
            {
                p2Tails++;
            }
            
            //Checks if either player has won
            if (p1Tails >= winAmt || p1Heads >= winAmt)
            {
                p1Win = true;
            }
            
            if (p2Tails >= winAmt || p2Heads >= winAmt)
            {
                p2Win = true;
            }
            
            //Checks what the current game state is
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
