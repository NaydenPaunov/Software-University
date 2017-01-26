package Matrices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortAndPrintArray {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		//Input array length
		int arrayLength = Integer.parseInt(scanner.nextLine());
		
		String[] names = new String[arrayLength];
		
	
		//Introduce data in the array
		for(int i = 0 ; i < arrayLength ; i++)
		{
			names[i] = scanner.nextLine();
		}
		
		//Sort array
		Arrays.sort(names);
		
		//Print array
		for(String name : names)
		{
			System.out.println(name);
		}

	}

}
