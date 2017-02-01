package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		int n = Integer.parseInt(scanner.nextLine());
		TreeSet<String> elements = new TreeSet<>();
	
		//Add elements in TreeSet
		for(int i = 0 ; i < n ; i++){
			String[] input = scanner.nextLine().split(" ");
			 for(int j = 0 ; j < input.length ; j++)
			 {
				 elements.add(input[j]);
			 }
		}
		
		//Print
		StringBuilder elementsToPrint = new StringBuilder("");
		for(String element : elements){
			elementsToPrint.append(element).append(" ");
		}
		
		System.out.println(elementsToPrint);
	}

}
