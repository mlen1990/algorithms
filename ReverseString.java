/* ReverseString.java */

import java.io.StringWriter;

public class ReverseString {

  /**
   *  To call this method in another method use
   *  "ReverseString.reverseString(str)"
   *
   *  reverseString() reverses the input string.
   *
   *  @param str the string to be reversed.
   *
   *  @return the reversed version of the input string.
   **/
  public static String reverseString(String str) {
    if (str == null) {
      return null;
    }
    StringWriter writer = new StringWriter();
    for (int i = str.length() - 1; i > -1; i--) {
      writer.append(str.charAt(i));
    }
    return writer.toString();
  }
}
