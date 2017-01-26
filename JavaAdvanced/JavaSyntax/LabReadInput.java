package JavaSyntax;

import java.util.Scanner;

public class LabReadInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String first = scanner.next();
		String second = scanner.next();
		int firstNum = scanner.nextInt();
		int secondNum = scanner.nextInt();
		int thirdNum = scanner.nextInt();
		String lastString = scanner.next();
		
		System.out.printf("%s %s %s %d",first,second,lastString,firstNum+secondNum+thirdNum);
	}

}
