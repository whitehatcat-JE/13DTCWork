/**
 * Calculates the probabilty of different events in lotto
 * 
 * @author Jayden
 * @version 16/03/21
 */
public class Probability {
    // Constants
    static final int PLRLINES = 20;
    static final int LINELENGTH = 8;
    static final int STRIKEMAX = 4;
    static final int LOTTOCOUNT = 4;
    static final int LOTTOMIN = 3;
    static final double LINECOST = 0.7;

    // Class instances
    static Draw draw = new Draw();

    // Arrays
    static int[][] lines = new int[PLRLINES][LINELENGTH]; // 2D array
    static int[] strikeCounts = new int[STRIKEMAX]; // 0 being first strike etc
    static int[] lottoCounts = new int[LOTTOCOUNT];

    // Variables
    static double money = 0;

    /**
     * Runs the lotto scripts several times and calculates the probabilities
     * @param args String
     */
    public static void main(String[] args) {
        // Class instance setup
        Lotto lotto = new Lotto();
        Strike strike = new Strike();

        // Sets the plr lines
        generateRandomLines();

        int roundCount = 0;
        

        // Probability calculation loop
        while (strikeCounts[STRIKEMAX - 1] == 0) { // -1 as starts at 0
        // while (lottoCounts[LOTTOCOUNT - 1] == 0) {
            // Resets/updates loop variables
            roundCount++;
            money -= LINECOST * (double) LINELENGTH;
            int[] newResults = autoLine();
            
            // Checks if any lines match the new results
            for (int x = 0; x < PLRLINES; x++) {
                int[] line = lines[x];

                // Checks for strikes
                strike.calcStrike(line, newResults);
                if (strike.getStrike() != 0) {
                    strikeCounts[strike.getStrike() - 1]++;
                }

                // Checks for lottery wins
                lotto.calcLotto(line, newResults);
                if (lotto.getLotto() >= LOTTOMIN) {
                    lottoCounts[lotto.getLotto() - LOTTOMIN]++;
                }
            }
        }

        // Returns results
        System.out.println("Done in " + 
            (roundCount * PLRLINES) + " lines");
        System.out.print("Cost $" + (Math.round(-money * 100.0) / 100.0));
        System.out.println("0");
        System.out.println();

        System.out.println("STRIKE INFO");
        for (int y = 0; y < STRIKEMAX; y++) {
            System.out.println("Strike " + (y + 1) + ": " 
                    + strikeCounts[y] + " times");
        }
        System.out.println();

        System.out.println("LOTTO INFO");
        for (int z = 0; z < LOTTOCOUNT; z++) {
            System.out.println("Lotto " + (z + LOTTOMIN) + ": " 
                    + lottoCounts[z] + " times");
        }

    }
    
    /**
     * Automatically creates a line array
     * @return int[] array of line
     */
    public static int[] autoLine() {
        draw.generateDraw();
        return draw.getDraw();
    }

    /**
     * Randomly chooses the players lines
     */
    public static void generateRandomLines() {
        for (int i = 0; i < PLRLINES; i++) {
            lines[i] = autoLine();
        }
    }
}
