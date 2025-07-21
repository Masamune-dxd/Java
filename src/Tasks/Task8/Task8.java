package Tasks.Task8;
public class Task8 {    
    public static void main(String[] args) {
        int totalSum = 0;
        
        System.out.println("Numbers 1 to 3:");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
            totalSum += i;
        }
        System.out.println("\nTotal sum of numbers 1 to 3: " + totalSum);
        
        System.out.println("\nNumbers 1 to 6:");
        int secondSum = 0;
        for (int j = 1; j <= 6; j++) {
            System.out.print(j + " ");
            secondSum += j;
        }
        System.out.println("\nTotal sum of numbers 1 to 6: " + secondSum);
        totalSum += secondSum;
        
        System.out.println("\nNumbers 1 to 4:");
        int thirdSum = 0;
        for (int k = 1; k <= 4; k++) {
            System.out.print(k + " ");
            thirdSum += k;
        }
        System.out.println("\nTotal sum of number 1 to 4: " + thirdSum);
        totalSum += thirdSum;
        
        System.out.println("\nTotal of all sums: " + totalSum);
    }
}

class sumsVarArgs {

    public static void main(String[] args) {
        numbersToSum(4, 5, 10);
        numbersToSum(1, 2, 3, 4);
        numbersToSum(1, 2, 3, 4, 5);
        numbersToSum(1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10);
    }

    public static int numbersToSum(int... numbers) {
        int totalSum = 0;
        System.out.println();
        System.out.println(" The Numbers: ");

        for (int number : numbers) {
            totalSum += number;
            int sumsAll = 0;
            for (int i = 1; i <= number; i++) {
                sumsAll += i;
            }
            System.out.println("   The Number: " + number + ", Total sum of (1 to " + number + "): " + sumsAll);
        }

        System.out.println(" Total sum of all Numbers: " + totalSum);
        System.out.println();
        return totalSum;
    }
}
