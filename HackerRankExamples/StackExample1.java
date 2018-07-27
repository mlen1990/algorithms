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
			if (map.containsKey(input[i])) {
				stack.push(input[i]);
			} else {
				if (stack.empty()) {
					return false;
				} else {
					Character item = stack.peek();
					if (map.get(item) == input[i]) {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stack.empty();
	}

	// javac StackExample1.java && java -ea StackExample1
	public static void main(String []argh) {
		assert(true == isBalanced("{}([])"));
	    assert(false == isBalanced("([}])"));
	    assert(true == isBalanced("([])"));
	    assert(true == isBalanced("()[]{}[][]"));
	    assert(false == isBalanced("()[]{}[][]}"));
	    assert(false == isBalanced("()[]{]}[][]"));
	    assert(false == isBalanced("()]"));
	}
}