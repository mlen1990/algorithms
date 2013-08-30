/* EditDistance.java */

public class EditDistance {

  /*
   *  To call this method in another method use "EditDistance.dist(s1, s2)"
   *  Compute the edit distance of two strings using dynamic programming.
   *  @param s1 the first string.
   *  @param s2 the second string.
   *  @return an integer representing the edit distance between s1 and s2.
   *  Running time: O(nm), where n is the size of s1 and m is the size of
   *  s2.
   */
  public static int dist(String s1, String s2) {
    int[][] d = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i < s1.length() + 1; i++) {
      d[i][0] = i;
    }
    for(int j = 0; j < s2.length() + 1; j++) {
      d[0][j] = j;
    }
    for (int i = 1; i < s1.length() + 1; i++) {
      for (int j = 1; j < s2.length() + 1; j++) {
        int k = Math.min(1 + d[i-1][j], 1 + d[i][j-1]);
        int diff = d[i - 1][j - 1];
        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
          diff += 1;
        }
        d[i][j] = Math.min(k, diff);
      }
    }
    return d[s1.length()][s2.length()];
  }

  /*
   *  To compile this program using the command line, type
   *  "javac EditDistance.java"
   *  To run this program using the command line, type
   *  "java EditDistance <String1> <String2>"
   *  On a successful run, the edit distance between String1 and String2
   *  is outputted to stdout.
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java EditDistance <String1> <String2>");
      return;
    }
    System.out.println(dist(args[0], args[1]));
  }
}
