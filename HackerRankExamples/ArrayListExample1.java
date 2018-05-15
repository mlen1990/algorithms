import java.io.*;
import java.util.*;

/*
Example Input:
5
5 41 77 74 22 44 
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Output:
74
52
37
ERROR!
ERROR!

*/

public class ArrayListExample1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<List<Integer>> lists = new ArrayList<List<Integer>>(n);
        String[] values;
        List<Integer> list;
        for (int i = 0; i < n; i++) {
            values = scan.nextLine().split(" ");
            list = new ArrayList<Integer>();
            for (int j = 0; j < values.length; j++) {
                list.add(Integer.parseInt(values[j]));
            }
            lists.add(list);
        }
        System.out.println(lists);
        int nQueries = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < nQueries; i++) {
            values = scan.nextLine().split(" ");
            int v1 = Integer.parseInt(values[0]) - 1;
            int v2 = Integer.parseInt(values[1]);
            try {
                list = lists.get(v1);
                System.out.println(list.get(v2));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }
}