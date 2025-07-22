package GcashApp;

import java.util.Scanner;

public class GcashMainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GcashUserAuthenticationApp.UserAuthentication auth = new GcashUserAuthenticationApp.UserAuthentication();
        GcashCheckBalanceApp.CheckBalance balanceChecker = new GcashCheckBalanceApp.CheckBalance();
        GcashCashIn.CashIn cashInService = new GcashCashIn.CashIn();
        GcashCashTransfer.CashTransfer transferService = new GcashCashTransfer.CashTransfer();
        GcashViewTransactions.Transactions transactionService = new GcashViewTransactions.Transactions();

        long loggedInUserId = -1;
        String loggedInEmail = null;

        while (true) {
            System.out.println("\n=== Welcome to GCash CLI App ===");
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            loggedInUserId = auth.login(email, pin);
            if (loggedInUserId != -1) {
                loggedInEmail = email;
                System.out.println("Hello, " + loggedInEmail + "! You are now logged in.");
                break;
            } else {
                System.out.println("Login failed. Try again.");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("Logged in as: " + loggedInEmail);
            System.out.println("1. Check Balance");
            System.out.println("2. Cash-In");
            System.out.println("3. Transfer");
            System.out.println("4. View My Transactions");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Use loggedInUserId for balance
                    double balance = balanceChecker.checkUserBalance(String.valueOf(loggedInUserId));
                    System.out.printf("Your balance: %.2f\n", balance);
                    break;
                case "2":
                    System.out.print("Enter amount to cash-in: ");
                    double cashInAmount = Double.parseDouble(scanner.nextLine());
                    // Use loggedInUserId and loggedInEmail for account and name
                    cashInService.cashIn(String.valueOf(loggedInUserId), cashInAmount, loggedInEmail);
                    break;
                case "3":
                    System.out.print("Enter receiver Account ID: ");
                    String receiverId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine());
                    transferService.transferCash(String.valueOf(loggedInUserId), receiverId, transferAmount);
                    break;
                case "4":
                    // Use loggedInUserId for transaction view
                    transactionService.viewUserAll(String.valueOf(loggedInUserId));
                    break;
                case "5":
                    auth.logout(loggedInUserId);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

            if (running) {
                System.out.print("\nDo you want another transaction? (y/n): ");
                String again = scanner.nextLine();
                if (!again.equalsIgnoreCase("y")) {
                    auth.logout(loggedInUserId);
                    running = false;
                }
            }
        }

        System.out.println("Thank you for using GCash CLI App!");
        scanner.close();
    }
}