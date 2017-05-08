package org.dipesh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class StackProblems {
	private Stack<Character> stk = null;

	public static void main(String[] args) throws IOException {
		StackProblems sp = new StackProblems();
		System.out.println("Enter Expression : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputExpr = br.readLine();
		System.out.println(sp.infixToPostfix(inputExpr));
	}

	public StackProblems() {
		stk = new Stack<>();
	}

	public String infixToPostfix(String expression) {
		StringBuilder str = new StringBuilder();
		if (expression == null) {
			return null;
		}
		for (int i = 0; i < expression.length(); i++) {
			Character ch = expression.charAt(i);
			if (isOperand(ch)) {
				str.append(ch);
			} else if (isOperator(ch)) {
				while (!stk.isEmpty() && !isOpeningParanthesis(stk.peek())
						&& hasHigherPrecedence(stk.peek(), ch)) {
					str.append(stk.pop());
				}
				stk.push(ch);
			} else if(isOpeningParanthesis(ch)){
				stk.push(ch);
			}else if(isClosingParanthesis(ch)){
				while(!stk.isEmpty() && isOpeningParanthesis(ch)){
					str.append(stk.pop());
				}
				stk.pop();
			}
		}
		while(!stk.empty()){
			str.append(stk.pop());
		}
		return str.toString();
	}

	private boolean isClosingParanthesis(Character ch) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isOpeningParanthesis(Character ch) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isOperator(Character ch) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasHigherPrecedence(Character ch1, Character ch2) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isOperand(Character ch) {
		// TODO Auto-generated method stub
		return false;
	}

}
