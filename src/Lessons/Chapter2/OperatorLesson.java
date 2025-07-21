package Lessons.Chapter2;

public class OperatorLesson {
    public static void main(String[] args) {

        // Arithmetic Operators
        System.out.println(2 + 3); // Addition
        System.out.println(5 - 2); // Subtraction
        System.out.println(4 * 3); // Multiplication
        System.out.println(10 / 2); // Division
        System.out.println(10 % 3); // Modulus

        // Unary Operators
        int i = 5;
        System.out.println(++i); // Pre-increment
        System.out.println(i++); // Post-increment
        System.out.println(--i); // Pre-decrement
        System.out.println(i--); // Post-decrement

        // Relational Operators
        System.out.println(5 > 3); // Greater than
        System.out.println(5 < 3); // Less than
        System.out.println(5 >= 5); // Greater than or equal to
        System.out.println(5 <= 4); // Less than or equal to
        System.out.println(5 == 5); // Equal to
        System.out.println(5 != 4); // Not equal to

        // Logical Operators
        boolean a = true;
        boolean b = false;
        System.out.println(a && b); // Logical AND
        System.out.println(a || b); // Logical OR
        System.out.println(!a);      // Logical NOT

        // shift ops
        System.out.println(2<<2);
        System.out.println(15>>1);
        //0 0 1 0
        //8 4 2 1
        //01 1 1 1 
        System.out.println(+3 + +6);
        int s = 0;
        System.out.println(s++);
        System.out.println(s);//1
        System.out.println(++s);//2
        System.out.println(s);
        short x = 10;
        short y = 30;
        short z =(short) (x*y);
        System.out.println("z="+z);
    }
}