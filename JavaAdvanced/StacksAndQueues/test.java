package StacksAndQueues;

import java.util.ArrayDeque;

public class test {

	public static void main(String[] args) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		stack.push(2);
		stack.push(55);
		stack.push(102);
		
		System.out.println(stack.toArray());

	}

}
