/* LetterChanges.java */

import java.util.HashMap;
import java.io.StringWriter;

public class LetterChanges {

  public final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  public final static String SHIFTED = "bcdEfghIjklmnOpqrstUvwxyzA";

  /**
   *  To call this method in another method use
   *  "LetterChanges.letterChanges(str)"
   *
   *  letterChanges() modifies the input string by replacing every letter
   *  in the string with the letter following it in the alphabet and
   *  capitalizes every vowel in the new string.
   *
   *  @param str the string to be shifted.
   *
   *  @return a string shifted by 1 in the alphabet. Vowels are
   *  capitalized.
   **/
  public static String letterChanges(String str) {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    for (int i = 0; i < ALPHABET.length(); i++) {
      map.put(ALPHABET.charAt(i), SHIFTED.charAt(i));
    }
    StringWriter ret = new StringWriter();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) {
        ret.append(map.get(str.charAt(i)));
      } else {
        ret.append(str.charAt(i));
      }
    }
    return ret.toString();
  }
}
