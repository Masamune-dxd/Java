package ProgrammingChallenge;

import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (or type X to exit): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("X")) {
                System.out.println("Exiting...");
                break;
            }
            try {
                int number = Integer.parseInt(input);

                if (number == 0) {
                    System.out.println("The number is zero.");
                } else {
                    if (number > 0) {
                        System.out.println("The number is positive.");
                    } else {
                        System.out.println("The number is negative.");
                    }
                    if (number % 2 == 0) {
                        System.out.println("The number is even.");
                    } else {
                        System.out.println("The number is odd.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'X' to exit.");
            }
        }
        scanner.close();
    }
}