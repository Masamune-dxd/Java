package GcashApp;

// GcashApp (Project purposes only)
// https://github.com/Masamune-dxd

// This java file is dedicated for viewing transactions

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
// import java.util.*;

public class GcashViewTransactions {


    // Key: Transaction ID, Value: Transaction object
    private static Map<Long, Transaction> transactionLog = new HashMap<>();
    private static long nextTransactionId = 10001; // Simple ID generator for transactions

    // account for balancs 
    private static Map<String, Double> accountBalances = new HashMap<>();

    static {
        // adding dummy accs and initial balances
        accountBalances.put("ACC001", 1500.00);
        accountBalances.put("ACC002", 750.00);
        accountBalances.put("ACC003", 2000.00);

        // Transaction Type: CASH-IN 
        addTransaction(200.00, "User A", "ACC001", "CASH_IN", "ACC001");
        addTransaction(500.00, "User B", "ACC002", "CASH_IN", "ACC002");
        addTransaction(150.00, "User A", "ACC001", "CASH_IN", "ACC001");

        // Transaction Type: TRANSFER 
        addTransaction(100.00, "User A", "ACC001", "ACC001", "ACC002"); 
        addTransaction(50.00, "User B", "ACC002", "ACC002", "ACC003");  
        addTransaction(250.00, "User C", "ACC003", "ACC003", "ACC001"); 
    }

    // a helper method to add transactions for simulation
    private static void addTransaction(double amount, String name, String accountId, String from, String to) {
        String transactionDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Transaction newTransaction = new Transaction(nextTransactionId++, amount, name, accountId, transactionDate, to, from);
        transactionLog.put(newTransaction.getId(), newTransaction);
    }

    // the transaction record
    static class Transaction {
        private long id;
        private double amount;
        private String name; // person related to the transaction (e.g., initiating it)
        private String mainAccountId; // primary acc 
        private String date; 
        private String transferToId; // receiver acc ID for transfers
        private String transferFromId; // sender acc ID for transfers

        public Transaction(long id, double amount, String name, String mainAccountId, String date, String transferToId, String transferFromId) {
            this.id = id;
            this.amount = amount;
            this.name = name;
            this.mainAccountId = mainAccountId;
            this.date = date;
            this.transferToId = transferToId;
            this.transferFromId = transferFromId;
        }

        // getters for trnsctions
        public long getId() { return id; }
        public double getAmount() { return amount; }
        public String getName() { return name; }
        public String getMainAccountId() { return mainAccountId; }
        public String getDate() { return date; }
        public String getTransferToId() { return transferToId; }
        public String getTransferFromId() { return transferFromId; }

        public String getTransactionType() {
            if ("CASH_IN".equals(transferFromId)) {
                return "CASH-IN";
            } else if ("CASH_OUT".equals(transferToId)) { 
                return "CASH-OUT";
            } else {
                return "TRANSFER";
            }
        }
    }

    // class for the View-Transaction functionality
    public static class Transactions {

        // Helper to print table header for viewAll and viewUserAll
        private void printTableHeader(String title) {
            System.out.println("\n" + "=".repeat(85));
            String paddedTitle = String.format("%-83s", " " + title);
            System.out.printf("|%s|\n", paddedTitle);
            System.out.println("=".repeat(85));
            System.out.printf("| %-4s | %-19s | %-9s | %-10s | %-12s | %-12s |\n",
                              "ID", "Date", "Type", "Amount", "From Account", "To Account");
            System.out.println("-".repeat(85));
        }

        // Helper to print table row
        private void printTableRow(Transaction tx) {
            System.out.printf("| %-4d | %-19s | %-9s | %-10.2f | %-12s | %-11s |\n",
                              tx.getId(),
                              tx.getDate(),
                              tx.getTransactionType(),
                              tx.getAmount(),
                              tx.getTransferFromId().equals("CASH_IN") ? "CASH_IN" : tx.getTransferFromId(),
                              tx.getTransferToId().equals("CASH_OUT") ? "CASH_OUT" : tx.getTransferToId());
        }

        public void viewAll() {
            printTableHeader("ALL TRANSACTIONS");
            if (transactionLog.isEmpty()) {
                System.out.printf("|%-83s|\n", " No transactions recorded yet.");
            } else {
                for (Transaction tx : transactionLog.values()) {
                    printTableRow(tx);
                }
            }
            System.out.println("=".repeat(85));
        }

        public void viewUserAll(String userId) {
            printTableHeader("TRANSACTIONS FOR USER: " + userId);
            boolean found = false;
            for (Transaction tx : transactionLog.values()) {
                if (userId.equals(tx.getMainAccountId()) || userId.equals(tx.getTransferFromId()) || userId.equals(tx.getTransferToId())) {
                    printTableRow(tx);
                    found = true;
                }
            }
            if (!found) {
                System.out.printf("|%-83s|\n", " No transactions found for user ID: " + userId + ".");
            }
            System.out.println("=".repeat(85));
        }

        public void viewTransaction(long transactionId) {
            Transaction tx = transactionLog.get(transactionId);
            System.out.println("\n" + "=".repeat(85));
            String title = "TRANSACTION DETAILS (ID: " + transactionId + ")";
            String paddedTitle = String.format("%-83s", " " + title);
            System.out.printf("|%s|\n", paddedTitle);
            System.out.println("=".repeat(85));

            if (tx == null) {
                System.out.printf("|%-83s|\n", " Transaction with ID " + transactionId + " not found.");
            } else {
                System.out.printf("| %-20s: %-59s |\n", "Transaction ID", tx.getId());
                System.out.printf("| %-20s: %-59s |\n", "Date", tx.getDate());
                System.out.printf("| %-20s: %-59s |\n", "Type", tx.getTransactionType());
                System.out.printf("| %-20s: %-59.2f |\n", "Amount", tx.getAmount());
                System.out.printf("| %-20s: %-59s |\n", "Customer Name", tx.getName());
                System.out.printf("| %-20s: %-59s |\n", "Main Account ID", tx.getMainAccountId());
                System.out.printf("| %-20s: %-59s |\n", "Transfer From", tx.getTransferFromId());
                System.out.printf("| %-20s: %-59s |\n", "Transfer To", tx.getTransferToId());
            }
            System.out.println("=".repeat(85));
        }
    }

    public static void main(String[] args) {
        Transactions transactionService = new Transactions();

        // ACTIONS (--- viewing transactions ---)

        // ACT 1: View All Transactions
        System.out.println("\n--- Viewing All Transactions ---");
        transactionService.viewAll();

        // ACT 2: View Transactions for a Specific User
        System.out.println("\n--- Viewing Transactions for User ACC001 ---");
        transactionService.viewUserAll("ACC001");

        System.out.println("\n--- Viewing Transactions for User ACC002 ---");
        transactionService.viewUserAll("ACC002");

        System.out.println("\n--- Viewing Transactions for Non-existent User XYZ ---");
        transactionService.viewUserAll("XYZ");

        // ACT 3: View a Specific Transaction by ID
        System.out.println("\n--- Viewing Specific Transaction (ID: 10001) ---");
        transactionService.viewTransaction(10001);

        System.out.println("\n--- Viewing Specific Transaction (ID: 10004 - a transfer) ---");
        transactionService.viewTransaction(10004);

        System.out.println("\n--- Viewing Non-existent Transaction (ID: 99999) ---");
        transactionService.viewTransaction(99999);
    }
}