/**
 * The base card object with all the abilities
 * later will be the clean slate for new cards
 * 
 * @author Jayden,Ev & Norbert
 * @version 25/03/21 
 */

import java.util.ArrayList;
public class MasterCard {
    final int MAXHEALTH, MAXATTACK;
    final int MINHEALTH = 1;
    private boolean windFury = true;

    private boolean reborn = true;

    private boolean divineShield = true;
    private boolean taunt = true;

    int curHealth;
    int curAttack;
    var[] summoning = new var[];

    /**
     * Constructor of the template
     * 
     * @param setHealth     int the amount of health the card should have
     * @param setAttack     int the amount of attack the card should have
     */
    public masterCard(int setHealth, int setAttack) {
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
     * @return windfury
     */
    public void setWindFury() {
        windFury = true;
    }

    /**
     * @return reborn
     */
    public boolean hasReborn() {
        return reborn;
    }
    public void revive() {
        curHealth = MINHEALTH;
        reborn = true;
    }

    public void setDivineShield() {
        divineShield = true;
    }

    public void attackCard(MasterCard enemyCard) {
        int attacks = 1;
        if (windFury())
            attacks++;
        for (int a = 0; a < attacks; a++) {
            enemyCard.takeDamage(curAttack);
        }
    }

    /**
     * This will recieve an int of damage and if divine shield is
     * activated it will ignore the damage and turn it off.
     * 
     * @param damage    int the amount of damage the card should take
     */
    public void takeDamage(int damage) {
        if (this.hasDivineShield())
            this.divineShield = false;
        else
            curHealth -= damage;
    }
}

 




 