package SetsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class HandsOfCards {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
		
		//HashMap with card Power
		HashMap<String,Integer> power = new HashMap<>();
		
		power.put("2", 2);
		power.put("3", 3);
		power.put("4", 4);
		power.put("5", 5);
		power.put("6", 6);
		power.put("7", 7);
		power.put("8", 8);
		power.put("9", 9);
		power.put("10", 10);
		power.put("J", 11);
		power.put("Q", 12);
		power.put("K", 13);
		power.put("A", 14);

		power.put("S", 4);
		power.put("H", 3);
		power.put("D", 2);
		power.put("C", 1);
		
		String input = "";
		
		//Add card in LinkedHashMap 
		while(true){
	       input = scanner.nextLine();
	       
	       if(input.equals("JOKER")){
	    	   break;
	       }
	       
	       String[] nameAndCards = input.split(": ");
	       String name = nameAndCards[0];
	       String[] allCards = nameAndCards[1].split(", ");
	       
	       HashSet<String> cards = new HashSet<>();
	       for(int i = 0 ; i < allCards.length ; i++){
	    	   cards.add(allCards[i]);
	       }
	       
	       if(!players.containsKey(name)){
	    	   players.put(name, cards);
	       }else{
	    	   for(int i = 0 ; i < allCards.length ; i++){
	    	   players.get(name).add(allCards[i]);
	    	   }
	       }
		}
		
		//Check TotalPower and print
		StringBuilder output = new StringBuilder("");
		for (String name : players.keySet()) {
            Integer totalScore = 0;
            for (String card : players.get(name)) {
            		StringBuilder cardData = new StringBuilder(card);
            		String type = "" + cardData.charAt(card.length() -1);
            		Integer mult = power.get(type);

            		cardData.deleteCharAt(card.length() - 1);

            		int powers = power.get(cardData.toString()) * mult;
          	
            		totalScore += powers;
            }
		
            String outputLine = String.format("%s: %s", name, totalScore);

            output.append(outputLine).append("\n");
		
		}
		System.out.println(output);

	}


}