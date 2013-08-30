/* Fibonacci.java */

public class Fibonacci {

  /*
   *  To call this method in another method use
   *  "Fibonacci.iterativeFib(n)"
   *  This function computes the nth fibonacci number iteratively.
   *  @param n the nth fibonacci number to be computed.
   *  @return an integer representing the nth fibonacci number.
   *  Running time: O(n)
   *  Space Complexity: O(1)
   */
  public static int iterativeFib(int n) {
    if (n < 0) {
      System.out.println("Input must be positive.");
      return -1;
    } else if (n == 1) {
      return 1;
    }
    int f1 = 0;
    int f2 = 1;
    int fn = 0;
    for (int i = 2; i < n + 1; i++) {
      fn = f1 + f2;
      f1 = f2;
      f2 = fn;
    }
    return fn;
  }

  /*
   *  To call this method in another method use
   *  "Fibonacci.recursiveFib(n)"
   *  This function computes the nth Fibonacci number recursively.
   *  @param n the nth fibonacci number to be computed.
   *  @return an integer representing the nth fibonacci number.
   */
  public static int recursiveFib(int n) {
    if (n < 0) {
      System.err.println("The input must be positive.");
      return -1;
    } else if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return recursiveFib(n - 1) + recursiveFib(n - 2);
    }
  }

  /*
   *  To call this method in another method use
   *  "Fibonacci.min(n)"
   *  This method computes the first prime fibonacci number larger than
   *  a given minimum. For example, the first prime fibonacci number
   *  larger than 10 is 13.
   *  @param n a number
   *  @return the first fibonacci number larger than n
   */
  public static int min(int n) {
    int x = 0;
    for (int i = 3; i < n; i++) {
      x = iterativeFib(i);
      if (x > n && Prime.isPrime(x)) {
        break;
      }
    }
    return x;
  }
}
