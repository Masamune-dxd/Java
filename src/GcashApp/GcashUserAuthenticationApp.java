package GcashApp;

// GcashApp (ZZZ EDITION)
// Project purposes only
// https://github.com/Masamune-dxd

// This java file is dedicated for user authentication and registration

import java.util.HashMap;
import java.util.Map;

public class GcashUserAuthenticationApp {

    private static Map<String, User> usersDatabase = new HashMap<>();
    private static long nextUserId = 1001; // for ID generator

    // aka the user
    static class User {
        private long id;
        private String name;
        private String email;
        private String number; // Phone number in string format
        private String pin; 

        public User(long id, String name, String email, String number, String pin) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.number = number;
            this.pin = pin;
        }

        // getters
        public long getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getNumber() { return number; }
        public String getPin() { return pin; }

        // setter for PIN also for changePin method
        public void setPin(String pin) {
            this.pin = pin;
        }
    }

    // the class that handles all user authentication logic
    public static class UserAuthentication {

        public boolean register(String name, String email, String number, String pin) {
            // Simple validation
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Registration Failed: Name cannot be empty.");
                return false;
            }
            if (email == null || !email.contains("@") || !email.contains(".")) {
                System.out.println("Registration Failed: Invalid email format.");
                return false;
            }
            if (number == null || number.length() < 10) { // Basic phone number length check
                System.out.println("Registration Failed: Invalid phone number.");
                return false;
            }
            if (pin == null || pin.length() != 4 || !pin.matches("\\d+")) { // 4-digit PIN
                System.out.println("Registration Failed: PIN must be 4 digits.");
                return false;
            }

            // check if email already exists
            if (usersDatabase.containsKey(email)) {
                System.out.println("Registration Failed: Email already registered.");
                return false;
            }

            // if all validations pass, create and store user
            User newUser = new User(nextUserId++, name, email, number, pin);
            usersDatabase.put(email, newUser);
            System.out.println("Registration Success! User ID: " + newUser.getId());
            return true;
        }

        public long login(String email, String pin) {
            User user = usersDatabase.get(email);
            if (user == null) {
                System.out.println("Login Failed: User not found (Email not registered).");
                return -1; // User not found
            }
            if (!user.getPin().equals(pin)) {
                System.out.println("Login Failed: Incorrect PIN for " + email + ".");
                return -1; // Incorrect PIN
            }

            System.out.println("Login Success! Welcome, " + user.getName() + " (ID: " + user.getId() + ")");
            return user.getId();
        }

        public boolean changePin(long userId, String oldPin, String newPin) {
            User userToUpdate = null;

            for (User user : usersDatabase.values()) {
                if (user.getId() == userId) {
                    userToUpdate = user;
                    break;
                }
            }

            if (userToUpdate == null) {
                System.out.println("Change PIN Failed: User ID not found.");
                return false;
            }
            if (!userToUpdate.getPin().equals(oldPin)) {
                System.out.println("Change PIN Failed: Old PIN is incorrect.");
                return false;
            }
            if (newPin == null || newPin.length() != 4 || !newPin.matches("\\d+")) {
                System.out.println("Change PIN Failed: New PIN must be 4 digits.");
                return false;
            }
            userToUpdate.setPin(newPin);
            System.out.println("Change PIN Success for user " + userToUpdate.getEmail() + ".");
            return true;
        }

        public void logout(long userId) {
            User loggedOutUser = null;
            for (User user : usersDatabase.values()) {
                if (user.getId() == userId) {
                    loggedOutUser = user;
                    break;
                }
            }
            if (loggedOutUser != null) {
                System.out.println("Logout Success for user ID: " + userId + " (" + loggedOutUser.getEmail() + ").");
            } else {
                System.out.println("Logout attempted for unknown user ID: " + userId + ".");
            }
        }
    }

    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();

        // --- for testing userAuthentication ---
        System.out.println("\n====================================================================================");
        System.out.println("                                 USER AUTHENTICATION                                ");
        System.out.println("====================================================================================");

        // Act 1: Successful Registration
        System.out.println("\n--- ACT 1: Successful Registration ---");
        auth.register("Jane Doe", "janedoeisthicc@engmail.com", "09171234567", "1234");
        auth.register("Yixuan", "iamyixuan69@ecngmail.com", "09209876543", "5678");

        // Act 2: Failed Registration (Invalid Email, Existing Email, Invalid PIN)
        System.out.println("\n--- ACT 2: Failed Registrations ---");
        auth.register("Hoshimi Miyabi", "miyamiyabijpgmail.com", "09123456789", "9999"); // Invalid email
        auth.register("Soldier 11", "unknownhacker@godgmail.com", "09171234568", "2222"); // Existing email
        auth.register("Nicole Demara", "goddessnicole@engmail.com", "09151112222", "abc");   // Invalid PIN

        // Act 3: Successful Login
        System.out.println("\n--- ACT 3: Successful Login ---");
        long juanId = auth.login("hungergamesinafrica@example.com", "1234");

        // ACT 4: Failed Login (Incorrect PIN, User Not Found)
        System.out.println("\n--- ACT 4: Failed Logins ---");
        auth.login("hungergamesinafrica@example.com", "9999");      // Incorrect PIN
        auth.login("unknownhackker@example.com", "1111"); // User not found

        // ACT 5: Change PIN
        System.out.println("\n--- ACT 5: Change PIN ---");
        if (juanId != -1) {
            auth.changePin(juanId, "1234", "0000"); // Successful change
            auth.changePin(juanId, "1234", "0000"); // Failed (old PIN incorrect now)
            auth.changePin(juanId, "0000", "ABCD"); // Failed (new PIN invalid)
        }

        // ACT 6: Logout
        System.out.println("\n--- ACT 6: Logout ---");
        if (juanId != -1) {
            auth.logout(juanId);
        }
        auth.logout(9999); // Logout for non-existent user

        System.out.println("\n======================================================================================");
        System.out.println("|                              REGISTERED USERS DATABASE                             |");
        System.out.println("======================================================================================");
        System.out.printf("| %-4s | %-20s | %-26s | %-15s | %-5s |\n", "ID", "Name", "Email", "Number", "PIN");
        System.out.println("======================================================================================");

        if (usersDatabase.isEmpty()) {
            System.out.println("|                          No users registered yet.                              |");
        } else {
            for (User user : usersDatabase.values()) {
                System.out.printf("| %-4d | %-20s | %-26s | %-15s | %-5s |\n",
                        user.getId(), user.getName(), user.getEmail(), user.getNumber(), user.getPin());
            }
        }
        System.out.println("======================================================================================");
    }
}