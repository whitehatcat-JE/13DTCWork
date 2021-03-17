public class Dog {
    private String name;
    private int hp;

    /**
     * Constructor for objects of Dog class
     */
    public Dog(String nm) {
        name = nm;
        hp = 120;
    }

    public void wolf() {
        System.out.println("Wolf!");
    }


    /**
     * Getter method for attributes
     */
    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public void hit(int amt) {
        this.hp -= amt;
    }

    public int bite() {
        final int MIN = 1, MAX = 12;
        return (int) (MIN + Math.random() * MAX);
    }

    public boolean isAlive() {
        if (this.hp <= 0) {
            return false;
        } else {
            return true;
        }
    }
}