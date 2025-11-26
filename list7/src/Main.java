import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ex2();
    }

    public static void ex2 (){
        //ex2a();
        //ex2b();
        //ex2c();
    }

    public static void ex2a () {
        //2a
        ArrayList<String> names = new ArrayList<>(
                Arrays.asList("George", "John", "Ferdynand", "Marek", "Ola"));
        int length = names.size();
        for (int i = 0; i < length; i++) {
            for (String name : names) {
                System.out.println(name);
        }
            System.out.println();
            names.remove(0);
        }
    }

    public static void ex2b () {
        int n = InputHelper.readInt("Length of an array: ");
        ArrayList<Integer> names = new ArrayList<>();
        Random rn = new Random();
        //populate array
        for (int i = 0; i < n; i++) {
            names.add(rn.nextInt(10)+1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i));
        }

        System.out.println("Reverse order:");
        ArrayList<Integer> reversed = ex2bReverse(names);
        for (int num: reversed) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> ex2bReverse(ArrayList<Integer> numbers) {
        ArrayList<Integer> reversed = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }
        return reversed;
    }

    public static void ex2c() {
        ArrayList<String> words = new ArrayList<>(
                Arrays.asList("John", "went", "to", "school", "today")
        );
        String sentence = ex2cBuildSentence(words);
        System.out.println(sentence);
    }

    public static String ex2cBuildSentence(ArrayList<String> words) {
        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            sentence.append(word);
            sentence.append(" ");
        }
        return sentence.toString();
    }

    public static void ex2d() {}
}