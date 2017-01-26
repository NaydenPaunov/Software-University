package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    String inputStr = scanner.nextLine();
	    
	    ArrayDeque<Character> reversed = new ArrayDeque<>();
	    for(Character ch :inputStr.toCharArray())
	    {
	    	reversed.push(ch);
	    }
	    
	    while(!reversed.isEmpty())
	    {
	    	System.out.print(reversed.pop());
	    }
	}

}
