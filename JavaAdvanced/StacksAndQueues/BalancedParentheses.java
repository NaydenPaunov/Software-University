package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BalancedParentheses {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String parentheses = scanner.nextLine();
		char[] brackets = parentheses.toCharArray();
		
		ArrayDeque<Character> queue = new ArrayDeque<>();
	    
		if (brackets.length % 2 != 0) {
	            System.out.println("NO");
	            return;
	        }
		 
		for(int i = 0 ; i < brackets.length ; i++){
			queue.add(brackets[i]);
		}
	
		boolean isBalanced = false ;
		
		while(!queue.isEmpty()){
			char first = queue.pollFirst();
			char last = queue.pollLast();
			
			if(first == '(' && last == ')'){
				isBalanced = true;
			}
			else if(first == '[' && last == ']'){
				isBalanced = true;
			}
			else if(first == '{' && last == '}'){
				isBalanced = true;
			}
			else
			{
				isBalanced=false;
			}
		
	
		}	
			if(isBalanced){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
	 	}
		
	}

}
