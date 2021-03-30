/**
 * Manages the individual game instances
 * @author Jayden
 * @version 30/03/2021
 */
import java.util.ArrayList; // Imports ArrayList library
public class GameExecuter {
    // Constants
    private final int HANDSIZE = 7;
    private final int BOOLLENGTH = 2;
    // Arrays
    private ArrayList<Card> CardPool;
    private ArrayList<Card> setPlr1Cards;
    private ArrayList<Card> setPlr2Cards;
    private ArrayList<Card> plr1Cards;
    private ArrayList<Card> plr2Cards;

    // Variables
    private boolean startingPlayer;

    /**
     * Constructor, generates cardPool and hands
     */
    public GameExecuter() {
        // Generates base
        createPool();
        setPlr1Cards = setHand();
        setPlr2Cards = setHand();
    }

    /**
     * Sends back the plr1 cards selected
     * @return
     */
    public ArrayList<Card> getPlr1Cards() {
        return setPlr1Cards;
    }

    /**
     * Sends back the plr2 cards selected
     * @return
     */
    public ArrayList<Card> getPlr2Cards() {
        return setPlr2Cards;
    }

    /**
     * Runs a individual game instance
     */
    public int runGame() {
        // Sets instance variables
        plr1Cards = generateHand(setPlr1Cards);
        plr2Cards = generateHand(setPlr2Cards);
        ArrayList<Card> hand1;
        ArrayList<Card> hand2;

        // Selects the starting plr
        startingPlayer = ((int) (Math.random() * BOOLLENGTH) == 0);
        if (startingPlayer) {
            hand1 = plr1Cards;
            hand2 = plr2Cards;
        } else {
            hand1 = plr2Cards;
            hand2 = plr1Cards;
        }

        // 0: Still running, 1: Plr1 Wins, 2: Plr2 Wins, 3: Tie
        int winner = 0;
        // Cards that have already attacked this loop
        ArrayList<Integer> hand1CardsUsed = new ArrayList<Integer>();
        ArrayList<Integer> hand2CardsUsed = new ArrayList<Integer>();
        // Loops until team wins
        while (winner == 0) {
            // Checks if all cards have attacked
            if (hand1CardsUsed.size() == hand1.size()) { // Hand1
                hand1CardsUsed = new ArrayList<Integer>();
            }

            if (hand2CardsUsed.size() == hand2.size()) { // Hand2
                hand2CardsUsed = new ArrayList<Integer>();
            }

            // Initializes attacker/defender
            int AttackerIndex;
            Card defender = chooseDefender(hand2);
            
            // Selects hand1 attacker
            do { // Loops until a card unused this loop is chosen
                AttackerIndex = (int) (Math.random() * hand1.size());
            } while (hand1CardsUsed.contains(AttackerIndex));
            // Records card index so it's not chosen again
            hand1CardsUsed.add(AttackerIndex);

            fight(hand1.get(AttackerIndex), defender); // Attacks card
            
            // Stops script if hand loses, as lower script would break
            winner = checkWin();
            if (winner != 0) {
                System.out.println("END!");
                continue;
            }
            
            // Runs script but for second hand
            defender = chooseDefender(hand1);
            
            // Selects hand2 attacker
            do { // Loops until a card unused this loop is chosen
                AttackerIndex = (int) (Math.random() * hand2.size());
                System.out.println(hand2CardsUsed.size());
                System.out.println(hand2.size());
            } while (hand2CardsUsed.contains(AttackerIndex));
            // Records card index so it's not chosen again
            hand2CardsUsed.add(AttackerIndex);

            fight(defender, hand2.get(AttackerIndex)); // Attacks card
            
            winner = checkWin();
        }
        return winner;

    }

    /**
     * Gets what the current winstate is
     * @return
     */
    private int checkWin() {
        // Checks if plrs are disqualified
        boolean p1Out = (plr1Cards.size() == 0);
        boolean p2Out = (plr2Cards.size() == 0);

        // Calculates winstate
        if (p1Out && p2Out) 
            return 3;
        else if (p1Out)
            return 2;
        else if (p2Out)
            return 1;
        else
            return 0;

    }
    /**
     * Chooses attackable cards based on taunting
     * @param hand
     * @return
     */
    private Card chooseDefender(ArrayList<Card> hand) {
        ArrayList<Card> taunters = new ArrayList<Card>();
        for (Card card : hand) {
            if (card.hasTaunt()) {
                taunters.add(card);
            }
        }

        if (taunters.size() == 0) {
            return hand.get((int) (Math.random() * hand.size()));
        } else {
            return taunters.get((int) (Math.random() * taunters.size()));
        }
    }

    /**
     * Pits given plr1Card against plr2Card
     * @param plr1Card
     * @param plr2Card
     */
    private void fight(Card plr1Card, Card plr2Card) {
        plr1Card.harm(plr2Card.getAttack());
        if (plr1Card.hasWindFury())
            plr1Card.harm(plr2Card.getAttack());

        plr2Card.harm(plr1Card.getAttack());
        if (plr2Card.hasWindFury())
            plr2Card.harm(plr1Card.getAttack());

        if (plr1Card.getHealth() <= 0)
            plr1Cards.remove(plr1Card);
        if (plr2Card.getHealth() <= 0)
            plr2Cards.remove(plr2Card);
    }

    /**
     * Chooses the cards for each hand
     * 
     * @return
     */
    private ArrayList<Card> setHand() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        // Randomly chooses cards from the pool
        for (int i = 0; i < HANDSIZE; i++) {
            int cloneIndex = (int) (Math.random() * CardPool.size());
            Card cloneCard = CardPool.get(cloneIndex);
            // Shallow clones given card
            newHand.add(cloneCard);
        }
        return newHand;
    }

    /**
     * Creates a fresh hand
     * 
     * @return newHand      the deck of cards
     */
    private ArrayList<Card> generateHand(ArrayList<Card> cloneHand) {
        ArrayList<Card> newHand = new ArrayList<Card>();
        // deep clones each card in the arrayList
        for (Card cloneCard : cloneHand) {
            newHand.add(duplicateCard(cloneCard));
        }
        return newHand;
    }

    /**
     * Deep clones a given card
     * 
     * @param masterCard
     * @return newCard      duplicated card
     */
    private Card duplicateCard(Card masterCard) {
        // Gets original cards data
        String name = masterCard.getName();
        int health = masterCard.getHealth();
        int attack = masterCard.getAttack();
        boolean windFury = masterCard.hasWindFury();
        boolean taunting = masterCard.hasTaunt();
        boolean divine = masterCard.hasDivineShield();
        // Creates new card based off data
        Card newCard = new Card(name, health, attack, windFury, taunting, divine);
        return newCard;
    }

    /**
     * Generates the different cards data
     */
    private void createPool() {
        CardPool = new ArrayList<Card>();
        // 0: name, 1: health, 2: attack, 3: windFury, 4: taunt, 5: divineShield
        CardPool.add(new Card("AlleyCat", 20, 20, true, true, true));
        CardPool.add(new Card("Scavenging Hyena", 2, 2, false, false, false));
        CardPool.add(new Card("Vulgar Homunculus", 2, 4, false, true, false));
        CardPool.add(new Card("Wrath Weaver", 1, 3, false, false, false));
        CardPool.add(new Card("Dragonspawn Lieutenant", 2, 3, false, true, false));
        CardPool.add(new Card("Red Whelp", 1, 2, false, false, false));
        CardPool.add(new Card("Refreashin Anomaly", 1, 3, false, false, false));
        CardPool.add(new Card("Sellemental", 2, 2, false, false, false));
        CardPool.add(new Card("Micro Machine", 1, 2, false, false, false));
        CardPool.add(new Card("Micro Mummy", 1, 2, false, false, false));
        CardPool.add(new Card("Murloc Tidecaller", 1, 2, false, false, false));
        CardPool.add(new Card("Murloc Tidehunter", 2, 1, false, false, false));
        CardPool.add(new Card("Rockpool Hunter", 2, 3, false, false, false));
        CardPool.add(new Card("Deck Swabble", 2, 2, false, false, false));
        CardPool.add(new Card("Scallywag", 2, 1, false, false, false));
        CardPool.add(new Card("Acolyte of C'thun", 2, 2, false, false, false));
        CardPool.add(new Card("Infested Wolf", 3, 3, false, false, false));
        CardPool.add(new Card("Monstrous Macaw", 4, 3, false, false, false));
        CardPool.add(new Card("Houndmaster", 4, 3, false, false, false));
        CardPool.add(new Card("Rat Pack", 2, 2, false, false, false));
        CardPool.add(new Card("Imp Gang Boss", 2, 4, false, false, false));
        CardPool.add(new Card("Crystalweaver", 5, 4, false, false, false));
        CardPool.add(new Card("Soul Devourer", 3, 3, false, false, false));
        CardPool.add(new Card("Soul Juggler", 3, 3, false, false, false));
        CardPool.add(new Card("Bronze Warden", 2, 1, false, false, true));
        CardPool.add(new Card("Hangry Dragon", 4, 4, false, false, false));
        CardPool.add(new Card("Twilight Emissary", 4, 4, false, true, false));
        CardPool.add(new Card("Arcane Assistant", 3, 3, false, false, false));
        CardPool.add(new Card("Crackling Cyclone", 4, 1, true, false, true));
        CardPool.add(new Card("Stasis Elemental", 4, 4, false, false, false));
        CardPool.add(new Card("Deflect-o-Bot", 3, 2, false, false, true));
        CardPool.add(new Card("Iron Sensei", 2, 2, false, false, false));
        CardPool.add(new Card("Piloted Shredder", 4, 3, false, false, false));
        CardPool.add(new Card("Screjank Clunker", 2, 5, false, false, false));
        CardPool.add(new Card("Replicating Menace", 3, 1, false, false, false));
        CardPool.add(new Card("Coldlight Seer", 2, 3, false, false, false));
        CardPool.add(new Card("Felfin Navigator", 4, 4, false, false, false));
        CardPool.add(new Card("Bloodsail Cannoneer", 4, 3, false, false, false));
        CardPool.add(new Card("Salty Looter", 4, 4, false, false, false));
        CardPool.add(new Card("Southsea Strongarm", 4, 3, false, false, false));
        CardPool.add(new Card("Arm of the Empire", 4, 5, false, false, false));
        CardPool.add(new Card("Khadgar", 2, 2, false, false, false));
        CardPool.add(new Card("Warden of Old", 3, 3, false, false, false));
        CardPool.add(new Card("Ring Matron", 6, 4, false, true, false));
        CardPool.add(new Card("Siegebreaker", 5, 8, false, true, false));
        CardPool.add(new Card("Annor-o-Module", 2, 4, false, true, true));
        CardPool.add(new Card("Bolvar. Fireblood", 1, 7, false, false, true));
        CardPool.add(new Card("Voidlord", 3, 9, false, true, false));
        CardPool.add(new Card("Seabreaker Goliath", 6, 7, true, false, false));
        CardPool.add(new Card("Gentle Djinni", 4, 5, false, true, false));
        CardPool.add(new Card("Lieutenant Garr", 5, 1, false, true, false));
        CardPool.add(new Card("Zapp Slywick", 7, 2, true, false, false));
        CardPool.add(new Card("Tormented Ritualist", 2, 3, false, true, false));
        CardPool.add(new Card("Unstable Ghoul", 1, 3, false, true, false));
        CardPool.add(new Card("Yo-Ho-Ogre", 2, 6, false, true, false));
        CardPool.add(new Card("Molten Rock", 2, 4, false, true, false));
        CardPool.add(new Card("Imprisoner", 3, 3, false, true, false));
    }
}

