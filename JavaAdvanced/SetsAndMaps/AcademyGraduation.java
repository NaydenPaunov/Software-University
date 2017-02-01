package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		int n = Integer.parseInt(scanner.nextLine());
		TreeMap<String, Double> graduationResults = new TreeMap<>();
		
		//Get input and calculate Scores
		for(int i = 0 ; i < n ; i++){
			String name = scanner.nextLine();
			String[] scores = scanner.nextLine().split(" ");
			
			double sumOfScores = 0;
			for(String score : scores){
				sumOfScores += Double.parseDouble(score);
			}
			
			graduationResults.put(name, (sumOfScores/scores.length));
		}
		
		//Print
		for(String key : graduationResults.keySet()){
			System.out.println(key + " is graduated with " + graduationResults.get(key));
		}

	}

}
