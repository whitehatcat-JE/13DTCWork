/**
 * Stores the card pool, runs the instances and returns the probabilities
 * 
 * @author Jayden & co
 * @version 25/03/21
 */

import java.util.ArrayList;
public class simulation {
    final int GAMES = 10000;
    int php1 = 40;
    int php2 = 40;
    private boolean php1Win = false;
    private boolean php1Lose = false;
    int lose = 0;
    int win = 0;
    final int PERCENTAGE = 100;
    float winPercent = 0;
    float losePercent = 0;
    final static int POOLSIZE = 15;
    static var[] pool = new var[POOLSIZE];

    // Info given: Round count, win/lose/tie
    public static void generatePool() {
        var cat = new cat();
        pool.push(cat);
    }

    public static void () {
        
    }

    public void getPercentage() {
        winPercent = (win / (float) GAMES) * PERCENTAGE;
        losePercent = (lose / (float) GAMES) * PERCENTAGE;
        return winPercent, losePercent;
    }
}