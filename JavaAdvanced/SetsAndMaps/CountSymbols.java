package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.nextLine();
		char[] characters = new char[text.length()];
		TreeMap<Character,Integer> counter = new TreeMap<>();
		
		for(int i = 0 ; i < text.length(); i++){
			characters[i] = text.charAt(i);
			if(!counter.containsKey(characters[i])){
				counter.put(characters[i], 1);
			}else{
				counter.put(characters[i], (counter.get(characters[i]) + 1));
			}
				
		}
		
		for(Character key : counter.keySet()){
			System.out.println(key + ": "+ counter.get(key) +" time/s");
		}
		
		
	    

	}

}
