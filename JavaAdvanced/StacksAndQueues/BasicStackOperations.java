package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {

	public static void main(String[] args) {
		
		//Input data
		Scanner scanner = new Scanner(System.in);
		
		String[] info = scanner.nextLine().split("\\s+");
		String[] numbers = scanner.nextLine().split("\\s+");
		
		int elementsToPush = Integer.valueOf(info[0]);
		int elementsToPop = Integer.valueOf(info[1]);
		int elementSearch = Integer.valueOf(info[2]);
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		//Push elements in the stack
		for(int i = 0 ; i < elementsToPush ; i++){
			
			int num = Integer.valueOf(numbers[i]);
			stack.push(num);
		}
		
		//Pop elements in the stack
		for(int j = 0 ; j < elementsToPop ; j++)
		{
			stack.pop();
		}
		
		//Check for searching number  and check minimum value
		int minValue = 0;
		boolean checkSearch = false;
		
		for(int g = 0 ; g < elementsToPush - elementsToPop; g++){
			 int number = stack.pop();
			 if(minValue < number){
				 minValue = number;
			 }
			 
			 if(number == elementSearch ){
				 checkSearch = true;
			 }
			 
		}
		
		//Print
		if(checkSearch){
			System.out.println("true");
		}
		else{
			System.out.println(minValue);
		}
		
	}

}
