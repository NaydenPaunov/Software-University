package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TruckTur {

	public static void main(String[] args) {
		
	        Scanner scanner = new Scanner(System.in);
	        //Input 
	        int pumps = Integer.parseInt(scanner.nextLine());
	        ArrayDeque<String> petrolField = new ArrayDeque<>();
	        
	        //add elements in queue 
	        for (int i = 0; i < pumps; i++) {
	            petrolField.addLast(scanner.nextLine());
	        }

	        int startIndex = 0;
	        boolean finishTour = false;
	        while (true) {
	            String petrolStation = petrolField.pollFirst();
	            petrolField.addLast(petrolStation);

	            String[] params = petrolStation.split("\\s+");
	            long fuel = Long.parseLong(params[0]);
	            long distance = Long.parseLong(params[1]);
	            fuel -= distance;
	            int countStations = 1;
	            while (fuel >= 0) {
	                String nextStation = petrolField.pollFirst();
	                String[] nextParams = nextStation.split("\\s+");
	                if (nextStation.equals(petrolStation)) {
	                    finishTour = true;
	                    break;
	                }
	                petrolField.addLast(nextStation);
	                fuel += Long.parseLong(nextParams[0]);
	                fuel -= Long.parseLong(nextParams[1]);
	                countStations++;
	            }

	            if (finishTour) {
	                break;
	            }
	            startIndex += countStations;
	        }

	        System.out.println(startIndex);
	    

	}

}
