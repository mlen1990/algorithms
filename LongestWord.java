/* LongestWord.java */

public class LongestWord {

  /**
   *  To call this method in another method use
   *  "LongestWord.longestWord(sen)"
   *
   *  longestWord() finds the longest word in a sentence.
   *
   *  @param sen a string representation of a sentence.
   *
   *  @return the longest word in the sentence. Returns null if sen is
   *  null.
   *
   *  Example:
   *  input: "fun!!; time" -> output: "time"
   *  input: "That was awesome." -> output: "awesome"
   **/
  public static String longestWord(String sen) {
    if (sen == null) {
      return null;
    }
    String filtered = sen.replaceAll("[^a-zA-Z ]", "");
    String[] words = filtered.split(" ");
    String current = "";
    for (String word : words) {
      if (word.length() > current.length()) {
        current = word;
      }
    }
    return current;
  }
}
