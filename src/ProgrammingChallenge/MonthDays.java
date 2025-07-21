package ProgrammingChallenge;

import java.util.Scanner;

public class MonthDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Input month number");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Enter month number (1-12): ");
                int month;
                try {
                    month = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 12.");
                    scanner.nextLine(); // clear invalid input
                    continue;
                }
                int numDays;
                switch (month) {
                    case 1: // January
                    case 3: // March
                    case 5: // May
                    case 7: // July
                    case 8: // August
                    case 10: // October
                    case 12: // December
                        numDays = 31;
                        break;
                    case 2: // February
                        numDays = 28;
                        break;
                    case 4: // April
                    case 6: // June
                    case 9: // September
                    case 11: // November
                        numDays = 30;
                        break;
                    default:
                        numDays = -1; // invalid month
                        break;
                }

                if (numDays != -1) {
                    System.out.println("Number of days: " + numDays);
                } else {
                    System.out.println("Invalid month number.");
                }
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }

        scanner.close();
    }
}