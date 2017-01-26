package javaBasics;

import java.util.Scanner;
/*
Задача 2. Магазин за цветя
Мария иска да купи подарък на сина си. Тя работи в магазин за цветя. В магазина идва поръчка за цветя. Напишете програма, която 
пресмята сумата от поръчката и дали печалбата е достатъчна за подаръка. Цветята имат следните цени:
•	Магнолии – 3.25 лева
•	Зюмбюли – 4 лева
•	Рози – 3.50 лева
•	Кактуси – 8 лева 
От общата сума, Мария трябва да плати 5% данъци. 

*/

public class exam_exr2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double magnolias = 3.25;
		double hyacinths = 4;
		double roses = 3.50;
		double cactuses = 8;
		
		int numMagnolias = input.nextInt();
		int numHyacinths = input.nextInt();
		int numRoses = input.nextInt();
		int numCactuses = input.nextInt();
		double giftPrice = input.nextDouble();
		
		
		double sumWithoutTax = numMagnolias*magnolias + numHyacinths*hyacinths + roses*numRoses + cactuses*numCactuses;
		double sum = sumWithoutTax-(5*sumWithoutTax)/100;
		
		if(giftPrice > sum)
		{
			double needed = giftPrice - sum ;
			double n = Math.ceil(needed);
			
			System.out.printf("She will have to borrow %.0f leva.",n);
		}
		else
		{
			double enought = sum - giftPrice;
			System.out.printf("She is left with %d leva.",(int)enought);
		}
		
		
		
		
	}

}
