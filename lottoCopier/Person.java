/**
 * Write a description of class StrikeTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person {
    private final int STRIKESIZE = 4;

    private StrikeTicket strikeTicket;
    private LottoDraw newDraw;

    /**
     * Constructor for objects of class Person
     */
    public Person() {
    }

    /**
     * One draw to check against
     */
    public int[] watchDraw() {
        LottoDraw newDraw = new LottoDraw();
        return newDraw.getLine();
    }

    /**
     * Check Strike Ticket
     */
    public int checkStrikeTicket(int[] array1, int[] array2) {
        int counter = 0;

        for (int idx = 0; idx < STRIKESIZE; idx++) {
            if (array1[idx] == array2[idx]) {
                System.out.println("Match pos " + (idx+1));
                counter++;
            }
        }
        
        return counter;
    }

    /**
     * Main Routine
     */
    public static void main(String[] args) {
        Person p = new Person();
        int[] draw;

        draw = p.watchDraw(); // Get draw
        int matches = 0;
        long counter = 0L;

        // Check the ticket
        do {
            StrikeTicket ticketLine = new StrikeTicket(); // Create new ticket object

            matches = p.checkStrikeTicket(ticketLine.getLine(), draw);
            counter++;
            System.out.println("Ticket: " + counter + " Matches: " + matches);

            ticketLine = null;
            System.gc();
        }  while (matches != p.STRIKESIZE);
    }
}