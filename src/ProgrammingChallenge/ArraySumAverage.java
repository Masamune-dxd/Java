package ProgrammingChallenge;

import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Input numbers and calculate sum and average");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            } else if (choice.equals("1")) {
                System.out.print("How many numbers do you want to input? ");
                int n;
                try {
                    n = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                    continue;
                }
                if (n <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                int[] numbers = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    try {
                        numbers[i] = Integer.parseInt(scanner.nextLine());
                        sum += numbers[i];
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        i--; // repeat this iteration
                    }
                }
                double average = (double) sum / n;
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
        scanner.close();
    }
}