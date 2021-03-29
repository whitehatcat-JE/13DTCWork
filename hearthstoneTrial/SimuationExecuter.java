import java.util.ArrayList;

public class SimuationExecuter {
    private final int HANDSIZE = 7;

    private ArrayList<Card> CardPool;
    private ArrayList<Card> plr1Cards;
    private ArrayList<Card> plr2Cards;
    
    public SimuationExecuter() {
        createPool();
        plr1Cards = generateHand();
        plr2Cards = generateHand();
    }
    
    private ArrayList<Card> generateHand() {
        for (int i = 0; i < HANDSIZE; i++) {
            
        }
    }

    private void createPool() {
        CardPool = new ArrayList<Card>();
        // 0: name, 1: health, 2: attack, 3: windFury, 4: taunt, 5: divineShield
        CardPool.add(new Card("AlleyCat", 1, 1, false, false, false));
        CardPool.add(new Card("Scavenging Hyena", 2, 2, false, false, false));
        CardPool.add(new Card("Vulgar Homunculus", 2, 4, false, true, false));
        CardPool.add(new Card("Wrath Weaver", 1, 3, false, false, false));
        CardPool.add(new Card("Dragonspawn Lieutenant", 2, 3, false, true, false));
        CardPool.add(new Card("Red Whelp", 1, 2, false, false, false));
        CardPool.add(new Card("Refreashin Anomaly", 1, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        CardPool.add(new Card("Greg", 2, 3, false, false, false));
        
    }
}
