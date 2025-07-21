package ProgrammingChallenge;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Input a day number");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.next();

            if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Enter day number (1-7): ");
                String input = scanner.next();
                int dayNumber;
                try {
                    dayNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    continue;
                }
                String dayName;
                switch (dayNumber) {
                    case 1:
                        dayName = "Monday";
                        break;
                    case 2:
                        dayName = "Tuesday";
                        break;
                    case 3:
                        dayName = "Wednesday";
                        break;
                    case 4:
                        dayName = "Thursday";
                        break;
                    case 5:
                        dayName = "Friday";
                        break;
                    case 6:
                        dayName = "Saturday";
                        break;
                    case 7:
                        dayName = "Sunday";
                        break;
                    default:
                        dayName = "Invalid input";
                        break;
                }
                System.out.println(dayName);
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
        scanner.close();
    }
}