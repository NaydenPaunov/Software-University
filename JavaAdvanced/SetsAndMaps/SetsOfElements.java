package SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;

public class SetsOfElements {

	public static void main(String[] args) {
		
		//Input
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		HashSet<Integer> firstNumbers = new HashSet<>();
		HashSet<Integer> secondNumbers = new HashSet<>();
		
		//Input data in hashSet
		for(int i = 0 ; i < n ; i++){
			int num = Integer.parseInt(scanner.nextLine());
			firstNumbers.add(num);
		}
		for(int j = 0 ; j < m ; j++){
			int num = Integer.parseInt(scanner.nextLine());
			secondNumbers.add(num);
		}
		
		//Print
		StringBuilder numbers = new StringBuilder("");
		for(Integer number : firstNumbers){
			if(secondNumbers.contains(number)){
				numbers.append(number).append(" ");
			}
		}
		
		System.out.print(numbers);
		
	}

}
