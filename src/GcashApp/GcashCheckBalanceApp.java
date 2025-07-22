package GcashApp;   

// GcashApp (Project purposes only)
// https://github.com/Masamune-dxd

// This java file is dedicated for checking user balances

import java.util.HashMap;
import java.util.Map;
// import java.util.*;

public class GcashCheckBalanceApp {

    private static Map<String, Double> balanceDatabase = new HashMap<>();

    static {
        // ID, amount, user_ID (user_ID is the key)
        balanceDatabase.put("user123", 1500.75); // User ID: user123, Balance: 1500.75
        balanceDatabase.put("user456", 250.20);  // User ID: user456, Balance: 250.20
        balanceDatabase.put("user789", 5000.00); // User ID: user789, Balance: 5000.00
    }

    // this class checks the user's balance
    public static class CheckBalance {
        public double checkUserBalance(String userId) {
            return balanceDatabase.getOrDefault(userId, 0.0);
        }
    }

    public static void main(String[] args) {
        CheckBalance balanceChecker = new CheckBalance();

        // test user IDs
        String[] testUserIds = {"user123", "user456", "user789", "unknownUser"};

        System.out.println();
        System.out.println("=========================================");
        System.out.println("|           BALANCE INQUIRY             |");
        System.out.println("=========================================");
        System.out.println("| User ID       | Current Balance       |");
        System.out.println("=========================================");

        // loop and display balances
        for (String userId : testUserIds) {
            double balance = balanceChecker.checkUserBalance(userId);
            System.out.printf("| %-13s | %-21.2f |\n", userId, balance);
        }

        System.out.println("=========================================");
        System.out.println();
    }
}