/**
 * 
 * @author Jayden
 * @version 25/05/2021
 */
import java.util.HashMap;

public class People {
    public static void main(String[] args) {
        HashMap<String, Integer> peopleAges = new HashMap<String, Integer>();

        // Add keys and values (Name, Age)
        peopleAges.put("John", 32);
        peopleAges.put("Sasha", 16);
        peopleAges.put("Elizabeth", 95);

        for (String name : peopleAges.keySet()) {
            System.out.println("Name: " + name + "\tAge: " + peopleAges.get(name));
        }
    }
}