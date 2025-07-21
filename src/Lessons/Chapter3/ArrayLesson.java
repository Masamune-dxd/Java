package Lessons.Chapter3;

import java.util.Arrays;

/**
 * Demonstrates basic array operations in Java.
 */
public class ArrayLesson {
    public static void main(String[] args) {
        // 1. Declaring and initializing arrays
        int[] emptyArray = new int[3]; // Array of 3 integers, all initialized to 0
        int[] numbers2 = new int[]{1, 54, 75}; // Explicit initialization
        int[] numbers3 = {1, 54, 75}; // Shorthand initialization

        // 2. Array of objects
        Student[] batch2 = {
            new Student(), new Student(), new Student(), new Student(), null
        };

        // 3. Iterating through an array using a for loop
        System.out.println("numbers3 contents:");
        for (int j = 0; j < numbers3.length; j++) {
            System.out.println(numbers3[j]);
        }

        // 4. Sorting and searching in arrays
        int[] numbers4 = {1, 54, 75, 5, 76, 34, 7, 3, 8, 10, 34};
        Arrays.sort(numbers4);
        System.out.println("\nnumbers4 sorted:");
        for (int number : numbers4) {
            System.out.print(number + ", ");
        }

        int searchNum = 9;
        int searchResult = Arrays.binarySearch(numbers4, searchNum);
        System.out.println("\nSearch for " + searchNum + ": " + searchResult);

        // 5. String array sorting and searching
        String[] numbersString = {"1", "a", "54", "75", "5", "76", "34", "7", "3", "8", "10", "34"};
        String stringSearch = "A";
        Arrays.sort(numbersString);
        System.out.println("\nnumbersString sorted:");
        for (String s : numbersString) {
            System.out.print(s + ", ");
        }
        int stringSearchResult = Arrays.binarySearch(numbersString, stringSearch);
        System.out.println("\nSearch for \"" + stringSearch + "\": " + stringSearchResult);

        // 6. Multidimensional arrays (jagged arrays)
        int[][] diffsize = {
            {1, 2},
            {3},
            {9, 8, 7}
        };
        // Accessing elements in a jagged array
        System.out.println("\ndiffsize[2][2]: " + diffsize[2][2]); // prints 7
    }
}

/**
 * Simple Student class for demonstration.
 */
class Student {
    String fullname;
    int age;
    String address;
    String course;
    int yearLevel;
}