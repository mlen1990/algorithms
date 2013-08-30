/* BinarySearch.java */

public class BinarySearch {

  /*
   *  To call this method in another method use
   *  "BinarySearch.binarySearch(a, key, imin, imax)"
   *  Iteratively find the index of the key in a sorted array of
   *  characters.
   *  @param a an array of characters
   *  @param key the character that we are searching for in the array
   *  @param imin the start index
   *  @param imax the end index
   *  @return an integer representing the location of the key in the
   *  array. If the key does not exist within imin and imax then return -1.
   */
  public static int binarySearch(char[] a, char key, int imin, int imax) {
    if (a.length == 0) {
      return -1;
    }
    while (imax >= imin) {
      int imid = (imin + imax)/2;
      if (a[imid] < key) {
        imin = imid + 1;
      } else if (a[imid] > key) {
        imax = imid - 1;
      } else {
        return imid;
      }
    }
    return -1;
  }

  /*
   *  To call this method in another method use
   *  "BinarySearch.binarySearch(a, key, imin, imax)"
   *  Iteratively find the index of the key in a sorted array of integers. 
   *  @param a an array of integers
   *  @param key the integer that we are searching for in the array
   *  @param imin the start index
   *  @param imax the end index
   *  @return an integer representing the location of the key in the
   *  array. If the key does not exist within imin and imax then return -1.
   */
  public static int binarySearch(int[] a, int key, int imin, int imax) {
    if (a.length == 0) {
      return -1;
    }
    while (imax >= imin) {
      int imid = (imin + imax)/2;
      if (a[imid] < key) {
        imin = imid + 1;
      } else if (a[imid] > key) {
        imax = imid - 1;
      } else {
        return imid;
      }
    }
    return -1;
  }
}
