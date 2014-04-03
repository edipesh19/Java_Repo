package com.scispike.effectivejava.solution.ch04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Stack<E> {
	private Vector<E> stack;
	private int top = -1; // index of the top element

	public Stack() {
		stack = new Vector<E>();
	}

	public void push(E obj) {
		stack.add(obj);
		top++;
	}

	public void pushAll(Collection<? extends E> src) {
		for (E e : src)
			push(e);
	}
	
	public E pop() {
		if (top == -1) {
			return null; // stack is empty
		}
		E temp = stack.get(top);
		stack.remove(top);
		top--;
		return temp;
	}

	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	@Override
	public String toString() {
		return stack.toString();
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

        stack.push("Washington");
        stack.push("Adams");
        stack.push("Jefferson");
        
        System.out.printf("Stack contains %d elements.\n", stack.size());
        
        while (!stack.isEmpty()) {
                System.out.println(stack.pop());
        }
        
        stack.push("Madison");

        System.out.printf("Stack contains %d elements.\n", stack.size());
        System.out.println(stack.pop());
        
        System.out.printf("Stack contains %d elements.\n", stack.size());
        
        Collection<String> src = new ArrayList<String>();
        src.add("Washington");
        src.add("Adams");
        
        stack.pushAll(src);
        System.out.println(stack);
        
        Collection<String> sink = new ArrayList<String>();
        stack.popAll(sink);
        System.out.println(sink);
	}

}
