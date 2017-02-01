package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MinerTask {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		 LinkedHashMap<String,Long> minerTask = new  LinkedHashMap<>();
		
		String resources = "";
		int i = 0;
		while(true){
			//Input
			String input = scanner.nextLine();
			//Check input = Stop
			if(input.equals("stop")){
				break;
			}
			
			//add quantity
			if(i % 2 == 0){
			  resources = input;
			}else{
				if(minerTask.containsKey(resources)){
					long quantity = Long.parseLong(input);
					minerTask.put(resources, (minerTask.get(resources)+quantity));
				}else{
					long quantity = Long.parseLong(input);
					minerTask.put(resources, quantity);
				}
				
			}
			
			i++;
		}
		//Print
		for(String key : minerTask.keySet()){
			System.out.println(key + " -> " + minerTask.get(key));
		}

	}

}
