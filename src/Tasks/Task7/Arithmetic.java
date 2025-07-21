package Tasks.Task7;

import java.util.Scanner;

public class Arithmetic {

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    float divide(float a, float b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }
        return (float) a / b;
    }
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("| Welcome to Arithmetic Operations           |");
        System.out.println("==============================================");
        System.out.println("| Enter first number:                        |");
        double num1 = scanner.nextDouble();
        System.out.println("==============================================");
        System.out.println("| Enter second number:                       |");
        double num2 = scanner.nextDouble();
        System.out.println("==============================================");

        System.out.println();
        System.out.println("==============================================");
        System.out.println("Addition = " + arithmetic.add(num1, num2));
        System.out.println("Substraction = " + arithmetic.subtract(num1, num2));
        System.out.println("Multiplication = " + arithmetic.multiply(num1, num2));
        System.out.println("Division = " + (float)(num1/num2));
        System.out.println("==============================================");
        System.out.println();
        
        scanner.close();
    }
}