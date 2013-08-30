/* LongestSubstring.java */

import java.lang.StringBuilder;

/*
 *  The purpose of this class is to find the longest substring in a long
 *  string that is the same in reverse. For example, if the input was "I
 *  like racecars that go fast" the substring returned would be "racecar".
 */
public class LongestSubstring {

  /*
   *  To call this method in another method use
   *  "LongestSubstring.reverse(s)"
   *  This helper method reverses the characters in a string. For example,
   *  the string "abcde" in reverse is "edcba".
   *  @param s the input string to be reversed.
   *  @return a string where the characters are in reverse order.
   */
  public static String reverse(String s) {
    StringBuilder rev = new StringBuilder(s.length());
    for (int i = s.length() - 1; i > -1; i--) {
      rev.append(s.charAt(i));
    }
    return rev.toString();
  }

  /*
   *  To call this method in another method use
   *  "LongestSubstring.getSubstring(s1, s2)"
   *  This method computes the longest common substring between two
   *  strings.
   *  @param s1 string1
   *  @param s2 string2
   *  @return the longest common substring between s1 and s2
   */
  public static String getSubstring(String s1, String s2) {
    String l1 = s1.toLowerCase();
    String l2 = s2.toLowerCase();
    int[][] l = new int[s1.length()][s2.length()];
    int z = 0;
    String substring = "";
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        if (l1.charAt(i) == l2.charAt(j)) {
          if (i == 0 || j == 0) {
            l[i][j] = 1;
          } else {
            l[i][j] = l[i - 1][j - 1] + 1;
          }
          if (l[i][j] > z) {
            z = l[i][j];
            substring = l1.substring(i - z + 1, i + 1);
          }
        }
      }
    }
    return substring;
  }

  /*
   *  To compile this program using the command line, type
   *  "javac LongestSubstring.java"
   *  To run this program using the command line, type
   *  "java LongestSubstring <string>", where string is a large block of
   *  text. We want to find the longest substring of the input that is the
   *  same in reverse.
   *  On a successful run, the longest substring of the input string in
   *  reverse will be outputted to stdout.
   *  For example, if the input was "I like racecars that go fast" the
   *  substring outputted to stdout will be "racecar".
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java LongestSubstring <String>");
      return;
    }
    String rev = reverse(args[0]);
    System.out.println(getSubstring(args[0], rev));
  }
}
