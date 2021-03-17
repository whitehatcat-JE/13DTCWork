/**
 * Where the cats and dogs fight to the death
 * 
 * @author Jayden
 * @version 18/03/21
 */
public class Arena {
    private final int MAXDOGS = 5, MAXCATS = 9;

    // Goes to make arrays of dogs and cats holding objects
    private Dog[] dogs = new Dog[MAXDOGS];
    private Cat[] cats = new Cat[MAXCATS];

    /**
     * Constructor 
     */

    public Arena() {
        this.fillArena();
    }

    /**
     * Fills objects with cats and dogs
     * Barks and meows
     */
    public void fillArena() {
        for (int idx = 0; idx < dogs.length; idx++) {
            dogs[idx] = new Dog("Dog " + Integer.toString(idx+1));
            System.out.print(dogs[idx].getName() + " goes");
            dogs[idx].wolf();
            System.out.println();
        }

        for (int idx = 0; idx < cats.length; idx++) {
            cats[idx] = new Cat("Cat " + Integer.toString(idx+1));
            System.out.print(cats[idx].getName() + " goes");
            cats[idx].meow();
            System.out.println();
        }
    }

    public void dogAttack(Dog dog, Cat cat) {
        System.out.println(dog.getName() + " bites " + cat.getName());
        cat.hit(dog.bite());

        // Check if the cat is still alive
        if (!cat.isAlive()) {
            System.out.println(cat.getName() + " is sleeping, Zzz");
        }
    }

    public void catAttack(Dog dog, Cat cat) {
        System.out.println(cat.getName() + " bites " + dog.getName());
        dog.hit(cat.claw());

        // Check if the cat is still alive
        if (!dog.isAlive()) {
            System.out.println(dog.getName() + " is dead, :O");
        }
    }

    public void fight() {
        do {
            int chosenCat = (int) (Math.random() * MAXCATS);
            int doomedDog = (int) (Math.random() * MAXDOGS);

            if (dogs[doomedDog].isAlive() && cats[chosenCat].isAlive()) {
                catAttack(dogs[doomedDog], cats[chosenCat]);
            }

            int bulliedCat = (int) (Math.random() * MAXCATS);
            int violentDog = (int) (Math.random() * MAXDOGS);

            if (dogs[violentDog].isAlive() && cats[bulliedCat].isAlive()) {
                dogAttack(dogs[violentDog], cats[bulliedCat]);
            }
        } while (checkWinner() == -1);
        
        if (checkWinner() == 1) {
            System.out.println("All cats fall asleep :(");
        } else {
            System.out.println("Dogs dead");
        }
    }

    /**
     * Checks if all the cats or dogs are dead
     * 
     * @return int  0 if cats are all dead, 1 if dogs are dead, -1 if glitched
     */
    public int checkWinner() {
        int catsAlive = MAXCATS, dogsAlive = MAXDOGS;

        for (Cat cat: cats) {
            if (!cat.isAlive()) {
                catsAlive--;
            }
        }

        for (Dog dog: dogs) {
            if (!dog.isAlive()) {
                dogsAlive--;
            }
        }

        if (catsAlive == 0) {
            return 0;
        } else if (dogsAlive == 0) {
            return 1;
        }
        return -1;
    }
}