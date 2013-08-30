/* Prime.java */

public class Prime {

  /*
   *  To call this method in another method use "Prime.isPrime(n)"
   *  Given an integer, this method determines if the integer is prime.
   *  @param n an integer
   *  @return true if n is prime and false is not prime.
   */
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /*
   *  To call this method in another method use "Prime.sumPrime(n)"
   *  This method returns the sum of a number's prime divisors.
   *  @param n an integer
   *  @return an integer representing the sum of the prime divisors of n.
   */
  public static int sumPrime(int n) {
    int sum = 0;
    for (int i = 2; i < n; i++) {
      if (n % i == 0 && isPrime(i)) {
        sum += i;
      }
    }
    return sum;
  }
}
