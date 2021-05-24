import java.util.HashMap;
/**
 * Class demonstration of a hashmap that contains countries and capitals
 * @author Jayden
 * @version 25/05/2021
 */
public class CountryCapitals {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, city)
        capitalCities.put("New Zealand", "Wellington");
        capitalCities.put("Australia", "Canberra");
        capitalCities.put("Canada", "Ottowa");
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities);

        // Accessing a value
        System.out.println(capitalCities.get("New Zealand"));

        // Removing a value
        capitalCities.remove("Australia");
        System.out.println(capitalCities);

        // Checking the size of the HashMap
        System.out.println(capitalCities.size());

        // Clear the HashMap
        // capitalCities.clear();
        //
        // System.out.println(capitalCities.size());

        // Loop and return the keys
        for (String country : capitalCities.keySet()) {
            System.out.println(country);
        }

        // Loop and return values
        for (String city : capitalCities.values()) {
            System.out.println(city);
        }

        // Loop and return keys and values
        for (String country : capitalCities.keySet()) {
            System.out.println("Country: " + country + "\tCapital: " + capitalCities.get(country));
        }
    }
}