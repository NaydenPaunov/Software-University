package SetsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Collections
		ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
		HashSet<String> regular = new HashSet<>();
		TreeSet<String> vip = new TreeSet<>();

		// Add guest and check is it PARTY stared
		while(true){
			String input = scanner.nextLine();
			
			if(input.equals("PARTY")){
 				break;
			}
			
			if(numbers.contains(input.charAt(0))){
				vip.add(input);
			}else{
				regular.add(input);
			}
		}
		
		//Remove guest
		while(true){
			String guestCome = scanner.nextLine();
			
			if(guestCome.equals("END")){
			   break;	
			}
			
			if(numbers.contains(guestCome.charAt(0))){
				vip.remove(guestCome);
				
			}else{
				regular.remove(guestCome);
			}	
		}
		
		//Collect all guests in VIP collection 
		vip.addAll(regular);
		
		//Print
		System.out.println(regular.size());
		
		for(String guests : vip){
			System.out.println(guests);
		}
	}

}

