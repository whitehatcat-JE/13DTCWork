public class Probability {
    static final int PLRLINES = 4;
    static final int LINELENGTH = 8;
    static final int STRIKEMAX = 4;
    static final double LINECOST = 0.7;

    static int[][] lines = new int[PLRLINES][LINELENGTH]; // 2D array
    static int[] strikeCounts = new int[STRIKEMAX]; // 0 being first strike etc

    static double money = 0;

    public static void main(String[] args){
        Draw draw = new Draw();
        Lotto lotto = new Lotto();
        Strike strike = new Strike();

        for (int i = 0; i < PLRLINES; i++){
            draw.generateDraw();
            lines[i] = draw.getDraw();
        }

        int roundCount = 0;

        while (strikeCounts[STRIKEMAX-1] == 0){ // -1 as starts at 0
            roundCount++;
            money -= LINECOST * LINELENGTH;
            draw.generateDraw();
            int[] newResults = draw.getDraw();
            
            for (int x = 0; x < PLRLINES; x++) {
                int[] line = lines[x];
                
                strike.calcStrike(line, newResults);
                if (strike.getStrike() != 0) {
                    strikeCounts[strike.getStrike()-1]++;
                }
            }
        }

        System.out.println("Completed in " + roundCount + " rounds");
        System.out.println("Spent $" + (-money));
        
        for (int y = 0; y < STRIKEMAX; y++){
            System.out.println("Strike " + (y + 1) + ": " + strikeCounts[y] + " times");
        }
    }
}
