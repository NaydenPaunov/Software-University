package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedHashMap<String,String> emails = new  LinkedHashMap<>();
		
		while(true){
			//Input and check for stop
			String name = scanner.nextLine();
			if(name.equals("stop")){
				break;
			}
			String email = scanner.nextLine();
			
			//Check for uk us and com
			char emailLastChar = email.charAt(email.length() -1 );
			
			if(emailLastChar == 'k' || emailLastChar == 's' || emailLastChar == 'm'){
				
			}else{
				emails.put(name, email);
			}
			
		}
		//Print
		for(String key : emails.keySet()){
			System.out.println(key + " -> " + emails.get(key));
		
		}

	}
}
