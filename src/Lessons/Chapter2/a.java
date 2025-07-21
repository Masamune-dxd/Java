package Lessons.Chapter2;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal.");
        } else if (num1 >= num2 && num1 >= num3) {
            if ((num1 == num2) || (num1 == num3)) {
                System.out.println("The largest number is " + num1 + " (two numbers are equal and largest).");
            } else {
                System.out.println("The largest number is " + num1 + ".");
            }
        } else if (num2 >= num1 && num2 >= num3) {
            if ((num2 == num1) || (num2 == num3)) {
                System.out.println("The largest number is " + num2 + " (two numbers are equal and largest).");
            } else {
                System.out.println("The largest number is " + num2 + ".");
            }
        } else {
            if (num3 == num1 || num3 == num2) {
                System.out.println("The largest number is " + num3 + " (two numbers are equal and largest).");
            } else {
                System.out.println("The largest number is " + num3 + ".");
            }
        }
        scanner.close();
    }
}