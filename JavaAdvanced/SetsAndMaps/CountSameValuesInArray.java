package SetsAndMaps;

import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesInArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input split
		String[] input = scanner.nextLine().split(" ");
		// Collection
		HashMap<String,Integer> results = new HashMap<>();
		
		//Check is it number present in the collection 
		for(int i = 0 ; i < input.length ; i++){
			
			if(!results.containsKey(input[i])){
				results.put(input[i],1);
			}
			else{
				results.put(input[i], results.get(input[i]) +1 );
			}
		}
		//Print
		for(String key : results.keySet()){
			System.out.println(key + " - " + results.get(key) +" times");
		}
	}

}
