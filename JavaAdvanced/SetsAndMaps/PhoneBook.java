package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TreeMap<String,String> phoneBook = new TreeMap<>();
		
		//Add numbers in phoneBook until see search
		while(true){
			String[] input = scanner.nextLine().split("-");
			
			if(input[0].equals("search")){
				break;
			}	
			phoneBook.put(input[0], input[1]);
		}
		
		//Search number in phoneBook until see Stop
		while(true){
			String input = scanner.nextLine();
			if(input.equals("stop")){
				break;
			}
			
			if(!phoneBook.containsKey(input)){
				System.out.println("Contact " + input + " does not exist.");
			}else{
				System.out.println(input + " -> " + phoneBook.get(input));
				}
			}
			
		}
		
	}

