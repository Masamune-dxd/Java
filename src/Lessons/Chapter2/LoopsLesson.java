package Lessons.Chapter2;

public class LoopsLesson { 
    
    public static void main(String[] args) {
        byte a = 1;
        while(a<=10)
            System.out.println("a = "+a++);

        do {
            System.out.println("a = "+a--);
        } while(a>0);
    }
}