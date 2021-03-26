/**
 * Runs a game, returning winner and needs plrboard and enemyboard
 * 
 * @author Jayden & co
 * @version 25/03/21
 */
import java.util.ArrayList;

 public class gameInstance {
    // Constants
    final int COMBATANTS = 2;

    // Variables
    int[] plrBoardLayout;
    int[] enemyBoardLayout;

    var[] plrCards;
    var[] enemyCards;

    // Tracking variables
    int rounds = 0;
    int winResult = 0; // 0: running, 1: p1win, 2: p2Win, 3: tie

    /**
     * Constructor of the game instance
    */
    public gameInstance(int[] plrLayout, int[] enemyLayout) {
        plrBoardLayout = plrLayout;
        enemyBoardLayout = enemyLayout;
    }

    /**
     * Creates cards for each instance
     */
    public void generateNewCards() {
        for (int pCard : plrBoardLayout) {
            var newCard = new pool[pCard];
        }
    }
    SCREAMING EAGLES!!!!!!!!!!!!!!!! :)
    /**
     * Runs the game and gets the win results
     * 
     * @return  Returns the game result
     */
    public int[] runGame(int[] results) {
        rounds = 0; // Clears preround counter
        winResult = 0; // Clears pre winResult

        boolean plrStarts = ((int) (Math.random() * COMBATANTS) == 0);

        while  (winResult == 0) {
            
        }

    }
    
 }