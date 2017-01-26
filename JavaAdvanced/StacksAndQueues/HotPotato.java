package StacksAndQueues;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayDeque;

public class HotPotato {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] children = scanner.nextLine().split("\\s+");
		Integer n = Integer.valueOf(scanner.nextLine());
		
		ArrayDeque<String> queue = new ArrayDeque<>();
		
		Collections.addAll(queue, children);
		
		while(queue.size() > 1)
		{  
			for(int i = 1 ; i < n ; i++)
			{
			String firstChildren = queue.poll();
			queue.offer(firstChildren);
			}
			
			System.out.println("Removed " + queue.poll());
		}
		
		System.out.println("Last is " + queue.poll());
		
		
	}

}
