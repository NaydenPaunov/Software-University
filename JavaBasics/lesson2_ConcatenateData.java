package ProgramiBasics;

import java.util.Scanner;

public class lesson2_ConcatenateData {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("First name : ");
		String fistName = input.nextLine();
		System.out.print("Last name : ");
		String lastName = input.nextLine();
		System.out.print("Town : ");
		String town = input.nextLine();
		System.out.print("Age : ");
		int age = input.nextInt();
		
		System.out.printf("You are %s %s, a %d-years old person from %s.",fistName,lastName,age,town);
		
			
		

	}

}
