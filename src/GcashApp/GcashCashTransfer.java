package GcashApp;

// GcashApp (Project purposes only)
// https://github.com/Masamune-dxd

// This java file is dedicated for cash transfer functionality

import java.util.HashMap;
import java.util.Map;

public class GcashCashTransfer {


    // Key: account_ID, Value: current balance
    private static Map<String, Double> accountBalances = new HashMap<>();

    static {
        // add some dummy accounts and initial balances
        accountBalances.put("USER001", 1000.00); // sender
        accountBalances.put("USER002", 500.00);  // receiver
        accountBalances.put("USER003", 200.00);  // another user
    }

    // class that handles the cash-transfer functionality
    public static class CashTransfer {

        public boolean transferCash(String senderAccountId, String receiverAccountId, double amount) {
            System.out.println("\nAttempting transfer from " + senderAccountId + " to " + receiverAccountId + " of " + String.format("%.2f", amount));

            // Condition 1: amount must be positive
            if (amount <= 0) {
                System.out.println("Transfer Failed: Amount must be greater than zero.");
                return false;
            }

            // Condition 2: sender and receiver accs must exist
            if (!accountBalances.containsKey(senderAccountId)) {
                System.out.println("Transfer Failed: Sender account " + senderAccountId + " not found.");
                return false;
            }
            if (!accountBalances.containsKey(receiverAccountId)) {
                System.out.println("Transfer Failed: Receiver account " + receiverAccountId + " not found.");
                return false;
            }

            // Condition 3: cant transfer money to same acc
            if (senderAccountId.equals(receiverAccountId)) {
                System.out.println("Transfer Failed: Cannot transfer to the same account.");
                return false;
            }

            double senderCurrentBalance = accountBalances.get(senderAccountId);

            // Condition 4: no money
            if (senderCurrentBalance < amount) {
                System.out.println("Transfer Failed: Insufficient funds in " + senderAccountId + ".");
                System.out.println("    Current balance: " + String.format("%.2f", senderCurrentBalance) + ", Needed: " + String.format("%.2f", amount));
                return false;
            }

            // transfer if conditions are good
            double receiverCurrentBalance = accountBalances.get(receiverAccountId);

            accountBalances.put(senderAccountId, senderCurrentBalance - amount);
            accountBalances.put(receiverAccountId, receiverCurrentBalance + amount);

            System.out.println("Transfer Successful!");
            System.out.println("    Sender " + senderAccountId + " new balance: " + String.format("%.2f", accountBalances.get(senderAccountId)));
            System.out.println("    Receiver " + receiverAccountId + " new balance: " + String.format("%.2f", accountBalances.get(receiverAccountId)));
            return true;
        }
    }

    public static void main(String[] args) {
        CashTransfer transferService = new CashTransfer();
        System.out.println("========================================================================================");
        System.out.println("|                                                                                      |");
        System.out.println("|                                GCASH APP - CASH TRANSFER                             |");
        System.out.println("|                                                                                      |");
        System.out.println("|======================================================================================|");
        System.out.println("|                                   INITIAL BALANCES                                   |");
        System.out.println("|======================================================================================|");
        System.out.printf("| %-40s | %-41s |\n", "Account ID", "Balance");
        System.out.println("|======================================================================================|");
        for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
            System.out.printf("| %-40s | %-41.2f |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("|======================================================================================|");

        // ---ACTS (Tests for Cash-Transfer) ---

        // ACT 1: Successful Transfer
        transferService.transferCash("USER001", "USER002", 150.00);

        // ACT 2: Insufficient Funds
        transferService.transferCash("USER003", "USER001", 300.00); // USER003 only has 200

        // ACT 3: Transfer to Non-existent Account
        transferService.transferCash("USER001", "NONEXIST", 50.00);

        // ACT 4: Transfer from Non-existent Account
        transferService.transferCash("NONEXIST", "USER002", 50.00);

        // ACT 5: Transfer Zero Amount
        transferService.transferCash("USER001", "USER003", 0.00);

        // ACT 6: Transfer Negative Amount
        transferService.transferCash("USER002", "USER001", -20.00);

        // ACT 7: Transfer to Self
        transferService.transferCash("USER001", "USER001", 10.00);

        System.out.println("|======================================================================================|");
        System.out.println("|                                    FINAL BALANCES                                    |");
        System.out.println("|======================================================================================|");
        System.out.printf("| %-40s | %-41s |\n", "Account ID", "Final Balance");
        System.out.println("|======================================================================================|");
        for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
            System.out.printf("| %-40s | %-41.2f |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("|======================================================================================|");
    }
}