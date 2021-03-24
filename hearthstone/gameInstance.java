/**
 * Runs a game, returning winner and needs plrboard and enemyboard
 * 
 * @author Jayden & co
 * @version 25/03/21
 */

 public class gameInstance {
    // Variables
    int[] plrBoardLayout;
    int[] enemyBoardLayout;

    int[] plrCards;
    int[] enemyCards;

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
     * Runs the game and gets the win results
     * 
     * @return  Returns the game result
     */
    public int[] runGame() {
        
    }
    
 }