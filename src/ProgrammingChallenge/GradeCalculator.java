package ProgrammingChallenge;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Input a grade");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Input the score: ");
                String input = scanner.next();
                try {
                    int score = Integer.parseInt(input);
                    System.out.println("Score: " + score);

                    if (score >= 90) {
                        System.out.println("A grade");
                    } else if (score >= 80) {
                        System.out.println("B grade");
                    } else if (score >= 70) {
                        System.out.println("C grade");
                    } else if (score >= 60) {
                        System.out.println("D grade");
                    } else {
                        System.out.println("F grade");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
        scanner.close();
    }
}