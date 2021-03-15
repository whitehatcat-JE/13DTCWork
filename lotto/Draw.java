/**
 * Randomly chooses 6 lotto balls, 1 bonus and 1 powerball
 * 
 * @author Jayden
 * @version 15/03/21
 */
public class Draw {
    // Constants
    private final int BALLSIDES = 40;
    private final int BALLCOUNT = 7; // Includes bonus
    private final int POWERBALLSIDES = 10;

    // Variables
    private int[] drawResults = new int[BALLCOUNT + 1]; // Extra 1 for powerball
    
    /**
     * Generates a new draw, preventing repeating numbers
     */
    public void generateDraw() {
        int[] newDraw = new int[BALLCOUNT + 1]; // Creates fresh draw
        
        // Rolls initial 7 balls without repeating numbers
        for (int i = 0; i < BALLCOUNT; i++) {
            int newBall = 0;
            boolean alreadyDrawn = true;

            // Checks if ball has already been rolled
            while (alreadyDrawn) {
                alreadyDrawn = false;
                newBall = (int) (Math.random() * BALLSIDES);
                for (int x = 0; x < BALLCOUNT; x++) {
                    if (newDraw[x] == newBall) {
                        alreadyDrawn = true;
                    }
                }
            }

            newDraw[i] = newBall; // Adds newBall
        }

        // Rolls and adds powerball
        int powerBall = (int) (Math.random() * POWERBALLSIDES);
        newDraw[BALLCOUNT] = powerBall;
        
        // Updates drawResults with newDraw
        drawResults = newDraw;
    }

    /**
     * Retrieves the currently cached drawResults
     * 
     * @return  Returns the drawResults
     */
    public int[] getDraw() {
        return drawResults;
    }
}
