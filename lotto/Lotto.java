/**
 * Checks what the lotto result is of given line and result
 * 
 * @author Jayden
 * @version 15/03/21
 */
public class Lotto {
    // Constants
    private final int LOTTOLENGTH = 6;

    // Variables
    private int winAmt = 0;

    /**
     * Calculates the lotto amount won
     * 
     * @param   lineArr Line chosen
     * @param   resultsArr Results selected
     */
    public void calcLotto(int[] lineArr, int[] resultsArr) {
        // Seperates irrelevent balls from arrays
        int[] lineBalls = new int[LOTTOLENGTH];
        int[] resultBalls = new int[LOTTOLENGTH];

        for (int z = 0; z < LOTTOLENGTH; z++) {
            lineBalls[z] = lineArr[z];
            resultBalls[z] = resultsArr[z];
        }

        winAmt = 0; // Clears win count

        // Scans for any ball matches
        for (int x = 0; x < LOTTOLENGTH; x++) {
            for (int y = 0; y < LOTTOLENGTH; y++) {
                if (lineBalls[x] == resultBalls[y]) {
                    winAmt++;
                }
            }
        }
    }
    
    /**
     * 
     */
    
    /**
     * Returns the lotto amount won
     * 
     * @return  Returns the winAmt
     */
    public int getLotto() {
        return winAmt;
    }
}
