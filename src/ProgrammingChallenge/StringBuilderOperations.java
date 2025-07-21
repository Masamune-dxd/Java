package ProgrammingChallenge;

import java.util.Scanner;

public class StringBuilderOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Enter a string (at least 10 characters)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("2")) {
                System.out.println("Exiting...");
                break;
            } else if (choice.equals("1")) {
                String input;
                while (true) {
                    System.out.print("Enter a string (at least 10 characters): ");
                    input = scanner.nextLine();
                    if (input.length() >= 10) {
                        break;
                    } else {
                        System.out.println("Input must be at least 10 characters long. Please try again.");
                    }
                }
                StringBuilder sb = new StringBuilder(input);

                System.out.println(sb.length());
                System.out.println(sb.charAt(0));
                System.out.println(sb.charAt(sb.length() - 1));
                System.out.println(sb.indexOf("a"));
                if (sb.length() >= 7) {
                    System.out.println(sb.substring(3, 7));
                } else if (sb.length() > 3) {
                    System.out.println(sb.substring(3));
                } else {
                    System.out.println("");
                }
                sb.append("123");
                System.out.println(sb);
                if (sb.length() >= 4) {
                    sb.insert(4, "xyz");
                }
                System.out.println(sb);
                if (sb.length() >= 5) {
                    sb.delete(2, 5);
                }
                System.out.println(sb);
                if (sb.length() > 8) {
                    sb.deleteCharAt(8);
                }
                System.out.println(sb);
                sb.reverse();
                System.out.println(sb);
            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }

        scanner.close();
    }
}