/**
 * Calculates the strike count of a given draw and lotto
 *
 * @author Jayden
 * @version 15/03/21
 */
public class Strike
{
    // Constants
    private final int MAXSTRIKE = 4; // In case the strike boundary changes

    // Variables
    private int strikeCnt;

    /**
     * Calculates the strike number and stores it as strikeCnt
     * 
     * @param   lineArr Line selected by the user
     * @param   resultsArr Lotto results
     */
    public void calcStrike(int[] lineArr, int[] resultsArr) {
        strikeCnt = 0; // Clears the previous strike count
        
        for (int i = 0; i < MAXSTRIKE; i++) {
            if (lineArr[i] == resultsArr[i]) {
                strikeCnt++;
            } 
            else {
                break;
            }
        }
    }

    /**
     * Retrieves the strikeCnt
     * 
     * @return  Returns strikeCnt
     */
    public int getStrike() {
        return strikeCnt;
    }
}
