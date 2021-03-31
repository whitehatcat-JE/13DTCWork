/**
 * Calculates the Probability
 * @author Jayden
 * @version 30/03/21
 */
import java.util.ArrayList;
public class Simulation {
    // Constants
    static final int GAMES = 1;

    // variables
    static int wins;
    static int losses;
    static int ties;

    public static void main(String[] args) {
        GameExecuter masterGame = new GameExecuter();
        for (int gameIdx = 0; gameIdx < GAMES; gameIdx++) {
            int winResult = masterGame.runGame();

            if (winResult == 1)
                wins++;
            else if (winResult == 2)
                losses++;
            else
                ties++;
        }

        returnResults(masterGame.getPlr1Cards(), masterGame.getPlr2Cards());
    }

    public static void returnResults(ArrayList<Card> p1Deck, ArrayList<Card> p2Deck) {
        System.out.println("Wins: " + (wins / GAMES) + "%");
        System.out.println("Ties: " + (ties / GAMES) + "%");
        System.out.println("Losses: " + (losses / GAMES) + "%");
    }
}
