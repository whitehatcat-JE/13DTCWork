/**
 * The basic card template
 * 
 * @author Jayden
 * @version 29/03/21
 */
public class Card {
    // Initializes the variables
    private int initialHealth;
    private int initialAttack;
    private int health;
    private int attack;

    private boolean windFury;
    private boolean taunt;
    private boolean divineShield;

    private String cardName;
    // Initializes the constants
    private final int MINHEALTH = 0;

    /**
     * Constructor for the individual Card class
     * 
     * @param startHealth
     * @param startAttack
     */
    public Card(String name, int startHealth, int startAttack, boolean attackTwice, boolean taunting,
            boolean hasDivineShield) {
        // Makes initial variables accessible
        initialHealth = startHealth;
        initialAttack = startAttack;
        windFury = attackTwice;
        taunt = taunting;
        divineShield = hasDivineShield;
        cardName = name;

        health = initialHealth;
        attack = initialAttack;
    }

    /**
     * Returns the attack strength
     * 
     * @return
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns current health
     * 
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Damages the card
     * 
     * @param damage
     */
    public void harm(int damage) {
        if (divineShield) {
            useDivineShield();
        } else {
            health -= damage;
        }
    }

    /**
     * Checks if card is dead
     * 
     * @return
     */
    public boolean isDead() {
        if (health <= MINHEALTH) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Says if should attack twice
     * 
     * @return
     */
    public boolean hasWindFury() {
        return windFury;
    }

    /**
     * Checks if taunting
     * 
     * @return
     */
    public boolean hasTaunt() {
        return taunt;
    }

    /**
     * Checks if has divineShield
     */
    public boolean hasDivineShield() {
        return divineShield;
    }

    /**
     * Uses divineShield
     */
    private void useDivineShield() {
        divineShield = false;
    }

    /**
     * Gets cards name
     * 
     * @return
     */
    public String getName() {
        return cardName;
    }

}