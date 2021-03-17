
/**
 * The ticket stuff
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StrikeTicket
{
    private int[] line;
    
    private final int MAXSTRIKESIZE = 4;
    private final int MAXNUM = 40;
    private final int MINNUM = 1;
    
    /**
     * Constructor for object of class StrikeLine
     * Populate the line with four random numbers
     */
    public StrikeTicket() {
        // fill array
        fillArray();
    }
    
    public void fillArray() {
        // initialise the with 4 ints
        line = new int[MAXSTRIKESIZE];
        int num;
        
        for (int idx = 0; idx < MAXSTRIKESIZE; idx++) {
            do {
                num = (int) (MINNUM + Math.random() * MAXNUM);
            } while (contains(line, num));
            line[idx] = num;
        }
    }

    /**
     * Checks array if a value exists
     * @param array
     * @param v
     * @return
     */
    public boolean contains(int[] array, int v) {
        for (int num : array) {
            if (num == v) {
                return true;
            }
        }

        return false;
    }

    /**
     * Retirms the ticketLine array
     */
    public int[] getLine() {
        return line;
    }
}
