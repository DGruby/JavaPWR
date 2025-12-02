import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ex2a();
        ex2b();
        ex2c();
        ex2d();
        ex2e();
        ex2f();
        ex2g();
        System.out.println(countVowels("aoe035eeecdg"));
        System.out.println(isPrime(4));
        //exk
        int[] nums = {5, 9, 2, 9, 1};
        System.out.println(findSecondLargest(nums));
    }


    public static void ex2a() {
        //2a
        ArrayList<String> names = new ArrayList<>(
                Arrays.asList("George", "John", "Ferdynand", "Marek", "Ola"));
        int length = names.size();
        for (int i = 0; i < length; i++) {
            for (String name : names) {
                System.out.println(name);
            }
            System.out.println();
            names.removeFirst();
        }
    }

    public static void ex2b() {
        int n = InputHelper.readInt("Length of an array: ");
        ArrayList<Integer> names = new ArrayList<>();
        Random rn = new Random();
        //populate array
        for (int i = 0; i < n; i++) {
            names.add(rn.nextInt(10) + 1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i));
        }

        System.out.println("Reverse order:");
        ArrayList<Integer> reversed = ex2bReverse(names);
        for (int num : reversed) {
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

    public static void ex2d() {
        var linkedList = createLinkedList(1000000);
        var arrayList = createArrayList(1000000);
        System.out.println("Linked list time: " + timeLinkedListAccess(linkedList, 10000) + "ms");
        System.out.println("Array list time: " + timeArrayListAccess(arrayList, 10000) + "ms");

    }

    //create an array list of specified length populated with random integers from 1-100
    public static ArrayList<Integer> createArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100) + 1);
        }
        return list;
    }

    //create a linked list of specified length populated with random integers 1-100
    public static LinkedList<Integer> createLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100) + 1);
        }
        return list;
    }

    //two methods for timing linked lists and array lists (returns time in ms)
    public static int timeArrayListAccess(ArrayList<Integer> list, int numQueries) {
        Random random = new Random();
        int listSize = list.size();
        int tempVariable = 0;
        long initialTime = System.currentTimeMillis();

        for (int i = 0; i < numQueries; i++) {
            tempVariable = list.get(random.nextInt(0, listSize));
        }
        long endTime = System.currentTimeMillis();
        return (int) (endTime - initialTime);
    }

    public static int timeLinkedListAccess(LinkedList<Integer> list, int numQueries) {
        Random random = new Random();
        int listSize = list.size();
        int tempVariable = 0;
        long initialTime = System.currentTimeMillis();

        for (int i = 0; i < numQueries; i++) {
            tempVariable = list.get(random.nextInt(0, listSize));
        }
        long endTime = System.currentTimeMillis();
        return (int) (endTime - initialTime);
    }

    public static void ex2e() {
        var linkedList = createLinkedList(1000000);
        var arrayList = createArrayList(1000000);

        //timing a linked list:
        long startTimeLinked = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.addFirst(i);
        }
        long endTimeLinked = System.currentTimeMillis();
        System.out.println("Time linkedList: " + (endTimeLinked - startTimeLinked) + "ms");

        long startTimeArray = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.addFirst(i);
        }
        long endTimeArray = System.currentTimeMillis();
        System.out.println("Time array: " + (endTimeArray - startTimeArray) + "ms");
    }

    public static void ex2f() {
        var linkedList = createLinkedList(1000000);
        var arrayList = createArrayList(1000000);
        Random random = new Random();

        long startTimeLinked = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(random.nextInt(linkedList.size() + 1), i);
        }
        long endTimeLinked = System.currentTimeMillis();
        System.out.println("Time linkedList: " + (endTimeLinked - startTimeLinked) + "ms");

        long startTimeArray = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextInt(arrayList.size() + 1), i);
        }
        long endTimeArray = System.currentTimeMillis();
        System.out.println("Time array: " + (endTimeArray - startTimeArray) + "ms");
    }

    //removing from the beginning:
    public static void ex2g() {
        var linkedList = createLinkedList(1000000);
        var arrayList = createArrayList(1000000);
        Random random = new Random();

        long startTimeLinked = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.removeFirst();
        }
        long endTimeLinked = System.currentTimeMillis();
        System.out.println("Time linkedList: " + (endTimeLinked - startTimeLinked) + "ms");

        long startTimeArray = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.removeFirst();
        }
        long endTimeArray = System.currentTimeMillis();
        System.out.println("Time array: " + (endTimeArray - startTimeArray) + "ms");
    }

    /*
    ex2h - The differences in time have to do with different implementations of both LinkedList and ArrayList
    data structures. Linked list is made up of containers, that each stores one value and a link to the next
    item. This means, that in order do access any element, we cannot access it directly by its index,
    but iterate over the whole structure until we find the right container. On the other hand, adding items
    at the beginning is faster, because you only have to adjust a few references.
    An array list consists of a few sequentially placed memory adresses, so accessing and removing/adding
    items with a given index is much faster, but placing an item in the beginnning or the middle, requires
    shifting all of the items, which takes more time than a linked list.
   */

    //ex2i
    public static int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

}