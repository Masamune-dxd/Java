package Tasks.Task9;

import static java.lang.Math.*;

public class Task9 {

    public static int add(int a, int b) {
        return addExact(a, b);
    }

    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }

    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

    public static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide zero.");
						throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return floorDiv(a, b);
    }

    public static void main(String[] args) {
        int num1 = 120;
        int num2 = 80;
        int num3 = 40;
        int num4 = 8;
				int num5 = 0;

				System.out.println();
        System.out.println("Performing Basic Math Operations:");
				System.out.println();

        // Add
				System.out.println("Addition:");
        System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
        System.out.println(num3 + " + " + num4 + " = " + add(num3, num4));
        System.out.println(num1 + " + " + num3 + " = " + add(num1, num3));
        System.out.println(num1 + " + " + num4 + " = " + add(num1, num4));
				System.out.println();
        // Subtract
				System.out.println("Subtraction:");
        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));
        System.out.println(num2 + " - " + num3 + " = " + subtract(num2, num3));
        System.out.println(num3 + " - " + num4 + " = " + subtract(num3, num4));
        System.out.println(num1 + " - " + num4 + " = " + subtract(num1, num4));
				System.out.println();
        // Multiply
				System.out.println("Multiplication:");
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
        System.out.println(num2 + " * " + num3 + " = " + multiply(num2, num3));
        System.out.println(num3 + " * " + num4 + " = " + multiply(num3, num4));
        System.out.println(num4 + " * " + num1 + " = " + multiply(num4, num1));
				System.out.println();
        // Divide
				System.out.println("Division:");
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
        System.out.println(num2 + " / " + num3 + " = " + divide(num2, num3));
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
        System.out.println(num1 + " / " + num4 + " = " + divide(num1, num4));
        System.out.println(num1 + " / " + num5 + " = " + divide(num1, num5)); 
				System.out.println();
    }
}