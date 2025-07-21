package ProgrammingChallenge;

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.println(inputString.length());
        System.out.println(inputString.toUpperCase());
        System.out.println(inputString.toLowerCase());
        System.out.println(inputString.charAt(0));
        System.out.println(inputString.charAt(inputString.length() - 1));

        if (inputString.length() >= 5) {
            System.out.println(inputString.substring(1, 5));
        } else if (inputString.length() > 1) {
            System.out.println(inputString.substring(1));
        } else {
            System.out.println(""); 
        }

        scanner.close();
    }
}