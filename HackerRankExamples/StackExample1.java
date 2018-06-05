/*
Input:
{}()
({()})
{}(
[]

Output:
true
true
false
true
*/

import java.util.*;

class StackExample1 {
	
	static HashMap<Character, Character> map = new HashMap<Character, Character>();
	static {
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
	}
	
	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] input = expression.toCharArray();
		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
				case '{':
				case '[':
				case '(':
					stack.push(input[i]);
					break;

				case '}':
				case ']':
				case ')':
					if (stack.empty()) {
						return false;
					}
					Character item = stack.peek();
					if (map.get(item) == input[i]) {
						stack.pop();
					} else {
						return false;
					}
					break;
			}
		}
		if (stack.empty()) {
			return true;
		}
		return false;
	}


	public static void main(String []argh) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			if (isBalanced(sc.next())) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		
	}
}