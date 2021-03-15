/**
 * Coin Game
 * Whoever gets three heads or tails first wins
 *
 * @author Jayden
 * @version 23/02/21
 */
public class CoinGame
{
    /**
     * The main game loop
     * @param args 
     */
    public static void main(String[] args)
    {
        //Constants
        final int WINAMT = 3; //Constant ignore checkstyle
        
        //Game tracking variables
        boolean running = true;
        boolean p1Win = false;
        boolean p2Win = false;
        
        int p1Tails = 0;
        int p1Heads = 0;
        int p2Tails = 0;
        int p2Heads = 0;
        
        Coin nextCoin = new Coin(); //Generate coin object
        
        //Main game script loop
        while (running)
        {
            //Flips player1's coin
            nextCoin.flip();
            
            if (nextCoin.isHeads())
                p1Heads++;
            else
                p1Tails++;
            //Flips player2's coin
            nextCoin.flip();
            
            if (nextCoin.isHeads())
                p2Heads++;
            else
                p2Tails++;
            
            //Checks if either player has won
            if (p1Tails >= WINAMT || p1Heads >= WINAMT)
            {
                p1Win = true;
            }
            
            if (p2Tails >= WINAMT || p2Heads >= WINAMT)
            {
                p2Win = true;
            }
            
            //Checks what the current game state is
            if (p1Win && p2Win)
            {
                System.out.println("Tie!");
                running = false;
            }
            else if (p1Win)
            {
                System.out.println("Player 1 Wins!");
                running = false;
            }
            else if (p2Win)
            {
                System.out.println("Player 2 Wins!");
                running = false;
                System.out.println("Player 1 Loses!");
            }
        }
    }
}
