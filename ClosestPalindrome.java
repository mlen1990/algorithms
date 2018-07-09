// running time O(d), where d is the number of digits in the number
public class ClosestPalindrome {

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int closestPlandrome(int number) {
        int increase = number - 1;
        while (!isPalindrome(Integer.toString(Math.abs(increase)))) {
            increase--;
        }

        int decrease = number + 1;
        while (!isPalindrome(Integer.toString(Math.abs(decrease)))) {
            decrease++;
        }

        if (Math.abs(number - increase) > Math.abs(number - decrease)) {
            return decrease;
        } else {
            return increase;
        }
    }

    public static void main(String[] args) {
        System.out.println(closestPlandrome(Integer.parseInt(args[0])));
    }
}