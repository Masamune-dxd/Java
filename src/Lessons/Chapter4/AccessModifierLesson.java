package Lessons.Chapter4;

import java.util.*;

public class AccessModifierLesson {
  public static void main(String[] args) {
    System.out.println();
  }

  public final /*public, private or protected */ void nap(int hours, int minutes, String bed) throws Exception {
    System.out.println();
  }

  public void walk() {}
  // default void walk2() {} doesn't compile
  // void public walk3() {} doesn't compile
  void walk4() {}

  /* 
   * A/S = ACCESS MODIFIER / optional SPECIFIER
   * S/A = SPECIFIER / ACCESS
   * R = RETURN 
   * M = METHOD
  */

}
