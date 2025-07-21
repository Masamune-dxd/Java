package Tasks.Task113;

public class PrintOddEven {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {

                System.out.println(i + " is Even Number");

            } else {

                System.out.println(i + " is Odd Number");

            }
        }
    }
}