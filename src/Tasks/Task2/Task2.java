package Tasks.Task2;

public class Task2 {
    public static void main(String[] args) {

        // H3110 w0r1d 2.0 true
        
        char charH = 'H';
        char charW = 'W';
        char charR = 'R';
        char charD = 'D';
        byte byteThree = 3;
        short shortOne = 1;
        int intZero = 0;
        float floatValue = 2.0f;
        boolean booleanValue = true;

        String outputString = charH +
                              String.valueOf(byteThree) +
                              String.valueOf(shortOne) +
                              String.valueOf(shortOne) +
                              String.valueOf(intZero) +
                              " " +
                              String.valueOf(charW).toLowerCase() +
                              String.valueOf(intZero) +
                              String.valueOf(charR).toLowerCase() +
                              String.valueOf(shortOne) +
                              String.valueOf(charD).toLowerCase() + " " +
                              String.valueOf(floatValue) +
                              " " +
                              String.valueOf(booleanValue);

        System.out.println(outputString);

        System.out.println(String.valueOf(charH) + String.valueOf(byteThree) + String.valueOf(shortOne) + String.valueOf(shortOne) + intZero + " " + String.valueOf(charW).toLowerCase() + intZero + String.valueOf(charR).toLowerCase() + shortOne + String.valueOf(charD).toLowerCase() + " " + floatValue + " " + booleanValue);

        System.out.println("H3110 w0r1d 2.0 true");
    }
}