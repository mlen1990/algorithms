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
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		while (sc.hasNext()) {
			stack = new Stack<Character>();
			String input=sc.next();
			for (int i = 0; i < input.length(); i++) {
				if (stack.empty()) {
					stack.push(input.charAt(i));
				} else {
					Character item = stack.peek();
					if ((item == '[' && input.charAt(i) == ']') || (item == '{' && input.charAt(i) == '}') || (item == '(' && input.charAt(i) == ')')) {
						stack.pop();
					} else {
						stack.push(input.charAt(i));
					}
				}
			}
			if (stack.empty()) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
            //Complete the code
		}
		
	}
}