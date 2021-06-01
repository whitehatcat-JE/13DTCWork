import java.util.ArrayList;
public class SortedJava {
    public static String[] sortStringArray(String[] array) {
        if(array.length != 0) { 
            // Compare each string in the array with the next. 
            for (int i = 0; i < array.length - 1; i++) {
                String temp = array[i]; // If the current string is less than the next, swap them. 
                if (temp.compareTo(array[i + 1]) < 0) {
                    temp = array[i + 1];array[i + 1] = temp;
                }
            } return array; 
        } return null; 
    }

    public static void main(String[] args) {
        String[] strings = new String[6];
        strings[0] = "hello";
        strings[1] = "I";
        strings[2] = "am";
        strings[3] = "an";
        strings[4] = "AI";
        strings[5] = "robot";
        String[] orderedString = sortStringArray(strings);
        for (String string : orderedString) {
            System.out.println(string);
        }
    }
}
