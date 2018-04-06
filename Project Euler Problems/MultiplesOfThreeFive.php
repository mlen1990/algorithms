<?php

/**
 *
 * 	If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * 	Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

class MultiplesOfThreeFive {

	/**
	 *
	 *	Naive solution: Iterate from 0 to $limit - 1 and use mod to determine if a number is divisble by 3 or 5
	 *
	 *	@param int $limit
	 *
	 *	@return int - Sum of all even fibonacci numbers where the final number does not exceed the $limit
	 *
	 */
	public static function naiveSum($limit) {
		if ($limit < 0) {
			return 0;
		}
		$sum = 0;
		for ($i = 0; $i < $limit; $i++) {
			if ($i % 3 === 0 || $i % 5 === 0) {
				$sum += $i;
			}
		}
		return $sum;
	}

	/**
	 *
	 *	Optimized solution: Use sum 1/2 * n * (n + 1)
	 *
	 *	@param int $limit
	 *
	 *	@return int - Sum of all even fibonacci numbers where the final number does not exceed the $limit
	 *
	 */
	public static function optimizedSum($limit) {
		if ($limit < 0) {
			return 0;
		}
		
		$n1 = floor(($limit - 1) / 3);
		$n2 = floor(($limit - 1) / 5);
		$n3 = floor(($limit - 1) / 15);

		return (int) (3/2 * $n1 * ($n1 + 1) + 5/2 * $n2 * ($n2 + 1) - 15/2 * $n3 * ($n3 + 1));
	}

	/**
	 *
	 *	@param none
	 *
	 *	@return none
	 *
	 */
	public static function testSums() {
		$test1 = MultiplesOfThreeFive::naiveSum(-1);
		echo ($test1 !== 0 ? "Error: Incorrect Sum: $test1 !== 0\n" : "Pass test 1\n");
		$test2 = MultiplesOfThreeFive::naiveSum(2);
		echo ($test2 !== 0 ? "Error: Incorrect Sum: $test2 !== 0\n" : "Pass test 2\n");
		$test3 = MultiplesOfThreeFive::naiveSum(4);
		echo ($test3 !== 3 ? "Error: Incorrect Sum: $test3 !== 3\n" : "Pass test 3\n");
		$test4 = MultiplesOfThreeFive::naiveSum(7);
		echo ($test4 !== 14 ? "Error: Incorrect Sum: $test4 !== 14\n" : "Pass test 4\n");
		$test5 = MultiplesOfThreeFive::naiveSum(10);
		echo ($test5 !== 23 ? "Error: Incorrect Sum: $test5 !== 23\n" : "Pass test 5\n");
		$test6 = MultiplesOfThreeFive::naiveSum(1000);
		echo ($test6 !== 233168 ? "Error: Incorrect Sum: $test6 !== 233168\n" : "Pass test 6\n");

		$sum1 = MultiplesOfThreeFive::naiveSum(-1);
		$sum2 = MultiplesOfThreeFive::optimizedSum(-1);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 7\n");
		$sum1 = MultiplesOfThreeFive::naiveSum(2);
		$sum2 = MultiplesOfThreeFive::optimizedSum(2);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 8\n");
		$sum1 = MultiplesOfThreeFive::naiveSum(4);
		$sum2 = MultiplesOfThreeFive::optimizedSum(4);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 9\n");
		$sum1 = MultiplesOfThreeFive::naiveSum(7);
		$sum2 = MultiplesOfThreeFive::optimizedSum(7);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 10\n");
		$sum1 = MultiplesOfThreeFive::naiveSum(10);
		$sum2 = MultiplesOfThreeFive::optimizedSum(10);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 11\n");
		$sum1 = MultiplesOfThreeFive::naiveSum(1000);
		$sum2 = MultiplesOfThreeFive::optimizedSum(1000);
		echo ($sum1 !== $sum2 ? "Error: Incorrect Sum: $sum1 !== $sum2\n" : "Pass test 12\n");
	}

}

MultiplesOfThreeFive::testSums();