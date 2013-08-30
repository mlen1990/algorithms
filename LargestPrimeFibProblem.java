/* LargestPrimeFibProblem.java */

/*
 *  Let's say you have a problem where you need to find the smallest prime
 *  Fibonacci number x that is greater than a minimum n. When you find x,
 *  you now want to find the sum of the prime divisors of x + 1. This
 *  class is specifically designed to combine various methods to find that
 *  sum.
 */
public class LargestPrimeFibProblem {

  /*
   *  To compile this program using the command line, type
   *  "javac LargestPrimeFibProblem.java"
   *  To run this program using the command line, type
   *  "java LargestPrimeFibProblem <n>"
   *  On a successful run, the smallest prime Fibonacci number x and the
   *  sum of the prime divisors of x + 1 will be printed to stdout.
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: java LargestPrimeFibProblem <n>");
      return;
    }
    int x = Fibonacci.min(Integer.parseInt(args[0]));
    System.out.println("The smallest prime Fibonacci number is: " + x);
    System.out.println("Sum of the prime divisors of x+1 is: " + Prime.sumPrime(x+1));
  }
}
