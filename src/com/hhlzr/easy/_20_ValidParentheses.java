package com.hhlzr.easy;

import java.util.Stack;

public class _20_ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "{(}";
		System.out.println(isValid(test));
	}
    public static boolean isValid(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	char ch = s.charAt(i);
        	if(!stack.isEmpty()){
        		switch (ch) {
				case '}':
					if(stack.peek()=='{')
						stack.pop();
                    else
                        stack.push(ch);
					break;
				case ']':
					if(stack.peek()=='[')
						stack.pop();
                    else
                        stack.push(ch);
					break;
				case ')':
					if(stack.peek()=='(')
						stack.pop();
                    else
                        stack.push(ch);
					break;
				default:
                    stack.push(ch);
					break;
				}
        	}else
        		stack.push(ch);
        }
        return stack.isEmpty();
    }
    
    public boolean solution1(String s) {
//    	Short java solution
    	Stack<Character> stack = new Stack<Character>();
    	for (char c : s.toCharArray()) {
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty() || stack.pop() != c)
    			return false;
    	}
    	return stack.isEmpty();
    }
}
