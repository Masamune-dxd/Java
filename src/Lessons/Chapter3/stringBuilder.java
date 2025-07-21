package Lessons.Chapter3;

public class stringBuilder {
  public static void main(String[] args) {
    StringBuilder alpha = new StringBuilder();
    for (char current = 'a'; current <= 'z'; current++) {
      alpha.append(current);
      System.out.println(alpha);
    }

    StringBuilder sb = new StringBuilder("start");
    sb.append(" middle");
    StringBuilder sb2 = new StringBuilder(" end");
    sb.append(sb2);
    System.out.println(sb);

    StringBuilder a = new StringBuilder("abc");
    StringBuilder b = a.append("de");
    b = b.append("f").append("g");
    System.out.println("a = " + a);
    System.out.println("b = " + b);

    
  }
}
class StringBuilderLesson {
    public static void main(String[] args){
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello ");
        System.out.println(sb1);
        String greetMe = "Hello ";
        System.out.println(sb1.toString()==greetMe);
    }
}