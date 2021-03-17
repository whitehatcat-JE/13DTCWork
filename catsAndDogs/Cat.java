public class Cat {
    private String name;
    private int hp;

    /**
     * Constructor for objects of Cat class
     */
    public Cat(String nm) {
        name = nm;
        hp = 100;
    }

    public void meow() {
        System.out.println("Mew!");
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

    public int claw() {
        final int MIN = 5, MAX = 20;
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