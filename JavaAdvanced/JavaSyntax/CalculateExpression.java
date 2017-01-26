package JavaSyntax;

import java.util.Scanner;

public class CalculateExpression {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		
		// Calculate first formula
		double inBracketsF1 = (Math.pow(a, 2) + Math.pow(b, 2))/(Math.pow(a, 2) - Math.pow(b, 2));
		double firstFormulaDegree = ( a + b + c )/Math.sqrt(c);
		double firstFormula = Math.pow(inBracketsF1,firstFormulaDegree);
		
		// Calculate second formula
		double inBracketsF2 = (Math.pow(a,2) + Math.pow(b, 2) - Math.pow(c, 3));
		double secondFormulaDegree = a-b;
		double secondFormula = Math.pow(inBracketsF2, secondFormulaDegree);
		
		// Calculate Average between numbers and first and second formula 
		double numbersAverage = (a+b+c)/3;
		double formulaAverage = (firstFormula + secondFormula)/2;
		double average = Math.abs(numbersAverage - formulaAverage);
		
		// Printing results
		System.out.printf("F1 result: %.2f; ",firstFormula);
		System.out.printf("F2 result: %.2f; ",secondFormula);
		System.out.printf("Diff: %.2f",average);
		
		
		
		
	}

}
