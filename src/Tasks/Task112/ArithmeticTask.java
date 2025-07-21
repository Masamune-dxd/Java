package Tasks.Task112;

public class ArithmeticTask {

    public static void main(String[] args) {

        int a = 2;
        int b = 5;
        int c = 7;
        int d = 2;

        // Add
        int sum = a + b;

        System.out.println("Sum: " + sum);

         // Subtract
        int difference = a - b;

        System.out.println("Difference: " + difference);

        // Multiply
        int product = a * b;

        System.out.println("Product: " + product);

        // Divide
        if (b != 0) {
            int quotient = a / b;

            System.out.println("Quotient: " + quotient);

        } else {
            System.out.println("Division by zero is not allowed.");

        }

        // Modulus
        int modulus = a % b; 
            System.out.println("Remainder: " + modulus);

        // Shift operator
        int shift = c >> a;
            System.out.println("Shift >>: " + shift);

        int shift2 = c << a;
            System.out.println("Shift <<: " + shift2);

        // Less than 
        if (b < a) {
            System.out.println( b + " is less than " + a);
        } else {
            System.out.println("It is not less than " + a + ".");
        }
        // Greater than 
        if (b < c) {
            System.out.println( b + " is greater than " + a);
        } else {
            System.out.println("It is not greater than " + a + ".");
        }

        // Equal to 
        if (a == b) {
            System.out.println(a + " is equal to " + b);
        } else if (a == c) {
            System.out.println(a + " is equal to " + c);
        } else if (a == d) {
            System.out.println(a + " is equal to " + d);
        } else {
            System.out.println(a + " is not equal to any.");
        }

        // Ternary 
        int max = (a > b) ? a : b;
        System.out.println("Maximum No.: " + max);
        int min = (a < b) ? a : b;
        System.out.println("Minimum No.: " + min);  
    } 
}