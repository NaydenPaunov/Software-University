package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {

	public static void main(String[] args) {
		//Input data
				Scanner scanner = new Scanner(System.in);
				
				String[] info = scanner.nextLine().split("\\s+");
				String[] numbers = scanner.nextLine().split("\\s+");
				
				int elementsToAdd = Integer.valueOf(info[0]);
				int elementsToRemove = Integer.valueOf(info[1]);
				int elementSearch = Integer.valueOf(info[2]);
				
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				
				//Push elements in the queue
				for(int i = 0 ; i < elementsToAdd; i++){
					
					int num = Integer.valueOf(numbers[i]);
					queue.add(num);
				}
				
				//Pop elements in the stack
				for(int j = 0 ; j < elementsToRemove ; j++)
				{
					queue.remove();
				}
				
				//Check for searching number  and check minimum value
				int minValue = Integer.MAX_VALUE;
				boolean checkSearch = false;
				
				for(int g = 0 ; g < elementsToAdd - elementsToRemove; g++){
					 int number = queue.remove();
					 if(minValue > number){
						 minValue = number;
					 }
					 
					 if(number == elementSearch ){
						 checkSearch = true;
					 }
					 
				}
				
				if(elementsToAdd - elementsToRemove == 0){
					minValue = 0;
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