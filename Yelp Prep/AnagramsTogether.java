// A Java program to print all anagrams together
import java.util.*;

// class for each word of duplicate array
class Word {
    String str;  // to store word itself
    int index; // index of the word in the original array
     
    // constructor
    Word(String str, int index) {
        this.str = str;
        this.index = index;
    }

    public String toString() {
        return "String: " + this.str + ", index: " + this.index;
    }
}

// class to represent duplicate array.
class DupArray {
    Word[] array;  // Array of words
    int size;   // Size of array
     
    // constructor
    public DupArray(String[] str) {
        this.size = str.length;
        array = new Word[str.length];
         
        // One by one copy words from the 
        // given wordArray to dupArray
        for (int i = 0; i < str.length; ++i) {
            // create a word Object with the 
            // str[i] as str and index as i
            array[i] = new Word(str[i], i);
        }
         
    }

    public String toString() {
        return Arrays.toString(this.array);
    }
}
  
// Compare two words. Used in Arrays.sort() for 
// sorting an array of words
class compStr implements Comparator<Word> {
    public int compare(Word a, Word b) {
        return a.str.compareTo(b.str);
    }
}

public class AnagramsTogether {
     
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String wordArr[]) {
        // Step 1: Create a copy of all words present
        // in given wordArr. The copy will also have 
        // original indexes of words
        DupArray dupArray = new DupArray(wordArr);
        // Step 2: Iterate through all words in 
        // dupArray and sort individual words.
        for (int i = 0; i < wordArr.length; i++) {
            char[] char_arr  = dupArray.array[i].str.toCharArray();
            Arrays.sort(char_arr);
            dupArray.array[i].str = new String(char_arr);
        }
      
        // Step 3: Now sort the array of words in 
        // dupArray
        Arrays.sort(dupArray.array, new compStr());
         
        // Step 4: Now all words in dupArray are together,
        // but these words are changed. Use the index 
        // member of word struct to get the corresponding
        // original word
        for (int i = 0; i < wordArr.length; i++) {
            System.out.print(wordArr[dupArray.array[i].index] + " ");
        }
        System.out.println();
    }
      
    // Driver program to test above functions
    public static void main(String args[]) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        printAnagramsTogether(wordArr);
    }
}