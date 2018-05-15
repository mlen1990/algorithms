/*

Input:
5
1 -2 4 -5 1

Output:
9
*/

import java.io.*;
import java.util.*;

public class SubArrayExample {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] intArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int sum1;
        for (int i = 0; i < intArray.length; i++) {
        	for (int j = 0; j < intArray.length; j++) {
        		sum1 = 0;
        		for (int k = i; k < j + 1; k++) {
        			sum1 += intArray[k];
        		}
        		if (sum1 < 0) {
        			sum++;
        		}
        		// System.out.println("[ " + i + " : " + j + " ] => " + sum1);
        	}

        }
        System.out.println(sum);
    }
}