/**
 * The base card object with all the abilities
 * later will be the clean slate for new cards
 * 
 * @author Jayden,Ev & Norbert
 * @version 25/03/21 
 */

public class MasterCard {
    final int MAXHEALTH, MAXATTACK;
    private boolean windFury = true;
    private boolean battleCry = true;
    private boolean deathRattle = true;
    private boolean reborn = true;
    private boolean summoner = true;
    private boolean divineShield = true;
    int curHealth;
    int curAttack;
    int attackAmt;

    /**
     * Constructor of the template
     * 
     * @param setHealth     int the amount of health the card should have
     * @param setAttack     int the amount of attack the card should have
     */
    public masterCard(int setHealth, int setAttack, int setAttackAmt) {
        // Setup health and attack
        curAttack = setAttack;
        curHealth = setHealth;
        attackAmt = setAttackAmt;
        MAXHEALTH = setHealth;
        MAXATTACK = setAttack;

    }

    /**
     * @return curHealth    int returns the current health
     */
    public int getHealth(boolean maxHealth = false) {
        return curHealth;
    }
    /**
     *@return curAttack     int returns the current attack
     */
    public int getAttack(boolean maxAttack = false) {
        if (maxAttack)
            return MAXATTACK;
        else
            return curAttack;
    }
    /**
     * @return attackAmt    int returns the current attacks
     */
    public int getAttackAmt() {
        return attackAmt;
    }

    /**
     * @param damage    int the amount of damage the card should take
     */
    public void takeDamage(int damage) {
        curHealth -= damage;
    }
    /**
     * @param health    int the amount of health the card should heal
     */
    public void healthUp(int health) {
        curHealth += health;
    }
    
    /**
     * @param buffAmt    int the amount the attack should increase by
     */
    public void buffAttack(int buffAmt) {
        curAttack += buffAmt;
    }
    /**
     * @param deBuffAmt    int the amount the attack should decrease by
     */
    public void buffAttack(int deBuffAmt) {
        curAttack -= deBuffAmt;
    }
    
    /**
     * @return battlecry
     */
    public boolean hasBattleCry() {
        return battleCry;
    }

    /**
     * @return deathrattle
     */
    public boolean hasDeathRattle() {
        return deathRattle;        
    }

    /**
     * @return windfury
     */
    private boolean hasWindFury() {
        return windFury;
    }

    /**
     * @return reborn
     */
    public boolean hasReborn() {
        return reborn;
    }

    /**
     * @return summoner
     */
    public boolean canSummon() {
        return summon;
    }
    
    /**
     * @return divineshield
     */
    private boolean hasDivineShield() {
        return divineshield;
    }

    public void attackCard(MasterCard enemyCard) {
        int attacks = this.getAttackAmt();
        if (this.hasWindFury())
            attacks++;
        for (int a = 0; a < attacks; a++) {
            enemyCard.TakeDamage(this.getAttack());
        }
    }
}

 




 