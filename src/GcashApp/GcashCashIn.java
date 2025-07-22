package GcashApp;

// GcashApp (Project purposes only)
// https://github.com/Masamune-dxd

// This java file is dedicated for cash in functionality

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.HashMap;
// import java.util.Map;
import java.util.*;

public class GcashCashIn {
    // Key: account_ID, Value: current balance
    private static Map<String, Double> accountBalances = new HashMap<>();

    // Key: Transaction ID, Value: Transaction object
    private static Map<Long, Transaction> transactionLog = new HashMap<>();
    private static long nextTransactionId = 1; // for ID generator for transactions

    static {
        // add dummy accounts and initial balances for output
        accountBalances.put("ACC001", 1000.00);
        accountBalances.put("ACC002", 500.00);
    }

    // the transaction record
    static class Transaction {
        private long id;
        private double amount;
        private String name; // the person making the transaction
        private String accountId;
        private String date; 
        private String transferToId; 
        private String transferFromId; 

        public Transaction(long id, double amount, String name, String accountId, String date, String transferToId, String transferFromId) {
            this.id = id;
            this.amount = amount;
            this.name = name;
            this.accountId = accountId;
            this.date = date;
            this.transferToId = transferToId;
            this.transferFromId = transferFromId;
        }

        // getters for the transaction details
        public long getId() { return id; }
        public double getAmount() { return amount; }
        public String getName() { return name; }
        public String getAccountId() { return accountId; }
        public String getDate() { return date; }
        public String getTransferToId() { return transferToId; }
        public String getTransferFromId() { return transferFromId; }
    }

    // the class for the Cash-in functionality
    public static class CashIn {
        public boolean cashIn(String accountId, double amount, String customerName) {
            if (amount <= 0) {
                System.out.printf("|%-82s|\n", " Cash-in Failed: Amount must be positive.");
                return false;
            }
            if (!accountBalances.containsKey(accountId)) {
                System.out.printf("|%-82s|\n", " Cash-in Failed: Account ID " + accountId + " not found.");
                return false;
            }

            // update balance
            double currentBalance = accountBalances.get(accountId);
            accountBalances.put(accountId, currentBalance + amount);

            // record the transaction
            String transactionDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Transaction newTransaction = new Transaction(nextTransactionId++, amount, customerName, accountId, transactionDate, accountId, "CASH_IN"); // bts, transferToId is self, transferFromId is source
            transactionLog.put(newTransaction.getId(), newTransaction);

            System.out.printf("|%-82s|\n", " Cash-in Successful! Account " + accountId + " new balance: " + String.format("%.2f", accountBalances.get(accountId)));
            return true;
        }
    }

    public static void main(String[] args) {
        CashIn cashInService = new CashIn();
    
        System.out.println();
        System.out.println("====================================================================================");
        System.out.println("|                                                                                  |");
        System.out.println("|                                GCASH APP - CASH-IN                               |");
        System.out.println("|                                                                                  |");
        System.out.println("|==================================================================================|");
        System.out.println("|                                 INITIAL BALANCES                                 |");
        System.out.println("|==================================================================================|");
        System.out.printf("| %-15s | %-20s | %-39s |\n", "Account ID", "Original Balance", "Current Balance");
        System.out.println("|==================================================================================|");
        for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
            System.out.printf("| %-15s | %-20.2f | %-39.2f |\n", entry.getKey(), entry.getValue(), entry.getValue());
        }

        System.out.println("|==================================================================================|");
        System.out.println("|                                CASH-IN TRANSACTIONS                              |");
        System.out.println("|==================================================================================|");
        // First transaction: cash-in 200 for ACC001
        System.out.println("| Attempting Cash-in: ACC001, Amount: 200.00, Customer: Tsukishiro Yanagi          |");
        cashInService.cashIn("ACC001", 200.00, "Tsukishiro Yanagi ");
        System.out.println("|==================================================================================|");
        // Second transaction: cash-in 300 for ACC002
        System.out.println("| Attempting Cash-in: ACC002, Amount: 300.00, Customer: John Smith                 |");
        cashInService.cashIn("ACC002", 300.00, "Nicole Demera");
        System.out.println("|==================================================================================|");
        // Trial by combat: Cash-in to non-chalant account
        System.out.println("| Attempting Cash-in: ACC999, Amount: 100.00, Customer: Invalid User               |");
        cashInService.cashIn("ACC999", 100.00, "Invalid User");
        System.out.println("|==================================================================================|");
        // Trial by combat: Cash-in with negative amount value
        System.out.println("| Attempting Cash-in: ACC001, Amount: -50.00, Customer: Tsukishiro Yanagi          |");
        cashInService.cashIn("ACC001", -50.00, "Tsukishiro Yanagi ");
        System.out.println("|==================================================================================|");
        System.out.println("|                                  FINAL BALANCES                                  |");
        System.out.println("|==================================================================================|");
        System.out.printf("| %-38s | %-39s |\n", "Account ID", "Final Balance");
        System.out.println("|==================================================================================|");
        for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
            System.out.printf("| %-38s | %-39.2f |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("|==================================================================================|");
        System.out.println("|                                TRANSACTION LOG                                   |");
        System.out.println("|==================================================================================|");
        System.out.printf("| %-5s | %-10s | %-17s | %-16s | %-20s |\n",
                          "ID", "Amount", "Account ID", "Source", "Date/Time");
        System.out.println("|==================================================================================|");

        if (transactionLog.isEmpty()) {
            System.out.println("|                               No transactions recorded.                          |");
        } else {
            for (Transaction tx : transactionLog.values()) {
                System.out.printf("| %-5d | %-10.2f | %-17s | %-16s | %-20s |\n",
                                  tx.getId(), tx.getAmount(), tx.getAccountId(), tx.getTransferFromId(), tx.getDate());
            }
        }
        System.out.println("====================================================================================");
        System.out.println();
    }
}