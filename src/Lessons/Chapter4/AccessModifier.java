package Lessons.Chapter4;

import java.util.Scanner;

public class AccessModifier {
    public void greetMe(){
        System.out.println("Hello from JAVA people");
    }
    private void greetMe2(){
        System.out.println("Hello from JAVA private person");
    }
    protected void greetMe3(){
        System.out.println("Hello from JAVA protected person");
    }
    void greetMe4(){
        System.out.println("Hello from JAVA default person");
    }
    public static void main(String[] args) {
        AccessModifier acm1 = new AccessModifier();
        acm1.greetMe();
        acm1.greetMe2();
        acm1.greetMe3();
        acm1.greetMe4();
    }
}
class ClassZ {
    public static void main(String[] args) {
        AccessModifier acm1 = new AccessModifier();
        acm1.greetMe();
        // acm1.greetMe2();
        acm1.greetMe3();
        acm1.greetMe4();
    }

    public void asdas() {}
    public final void asdsas() {}
    public static final void asdasas() {}
    public /*modifier*/ void asasas() {}
    public void /*final*/ asdass() {}
    final public void /*final*/ asdaqws() {}
    void as2daqws() {}

    /* 
    * ACCESS MOD
    * SPECIFIER
    * RETURN TYPE
    * MODIFIER
    */

    public void kjasj() {}
    public void kjasasj() {return;}
    public String jm32j() {return "";}
    // public String kj() {} doesn't compile, missing return
    // public kjas21212j() {} doesn't compile, missing return

    Boolean waasdka(int a) {
        if (a == 4) 
        return true;
        else return false;
    } 

    // String waas12dka(int a) {
    //     if (a==4) 
    //     return " ";

    // } 

    public void waasda() {}
    // public void waaa {} // no paranthesis on method name
    public void waasda(int a) {}
    // public void asda(int a; int b) {} // parameters separated by comma aint semi colon
    public void waasaada(int a, int b) {}

    public void zeroException() {}
    public void oneException() throws IllegalArgumentException{}
    public void twoException() throws IllegalArgumentException, InterruptedException{}

    public void kajs12() {}
    // public void kajs12; // semi colon on method name, no (), no curly
    public void kajs12(int a) {
        int name =5;
        // a= 587676;
    }
    
}
class SSS {
    public static void main(String[] args) {
     
    }
}



 class ArithmeticOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticOperations ops = new ArithmeticOperations();

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.println("Addition: " + ops.add(num1, num2));
        System.out.println("Subtraction: " + ops.subtract(num1, num2));
        System.out.println("Multiplication: " + ops.multiply(num1, num2));
        System.out.println("Division: " + ops.divide(num1, num2));
    }
 }