package javaBasics;

import java.util.Scanner;
/*
Задача 1. Цена на жилище
Напишете програма, която да пресмята цената на ново жилище, което има кухня, баня и 3 стаи. На входа програмата получава площта на кухнята и най-малката стая. Трябва да пресметнете площта на отделните помещения, за да намерите общата площ, като знаете че:
•	Банята е наполовина по-малка от най-малката стая.
•	Втората стая е 10% по-голяма от най-малката стая.
•	Третата стая е 10% по-голяма от втората стая.
Към общата площ трябва да се прибавят 5% за коридор. На входа програмата получава и цена на квадратен метър.
*/
public class exam_exr1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double areaShortestRoom = Double.parseDouble(input.nextLine());
		double areaKitchen = Double.parseDouble(input.nextLine());
		double priceMeter = Double.parseDouble(input.nextLine());
		
		double areaBathroom  = areaShortestRoom / 2;
		double secondRoom = areaShortestRoom  + (10*areaShortestRoom)/100;
		double thirtRoom = secondRoom + (10*secondRoom)/100;
		
		double alAllArea1 = areaShortestRoom + areaKitchen + areaBathroom + secondRoom + thirtRoom;
		double allArea = alAllArea1  + (5*alAllArea1)/100;
		
		
		double price = allArea*priceMeter;
		System.out.printf("%.2f",price);
		
	}

}
