package javaBasics;

import java.util.Scanner;

/*
Задача 4. Логистика
Отговаряте за логистиката на различни товари. В зависимост от теглото на товара е нужно различно превозно средство. Цената на тон, за която се превозва товара е различна за всяко превозно средство:
•	До 3 тона – микробус (200 лева на тон);
•	От 4 до 11 тона – камион (175 лева на тон);
•	12 и повече тона – влак (120 лева на тон).
Вашата задача е да изчислите средната цена на тон превозен товар, както и процента на тоновете  превозвани с всяко превозно средство, спрямо общото тегло(в тонове) на всички товари.

*/

public class exam_exr4 {

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 
		 int NumberT = input.nextInt();
		
		 int byBus = 200;
		 int byTruck = 175;
		 int byTrain = 120;
		 double Tax = 0;
		 double sum = 0;
		 
		 int WithaBus = 0;
		 int WithTruck = 0;
		 int WithTrain = 0;
		 
		 for(int i = 0 ; i < NumberT ; i++)
		 {
			 int n  = input.nextInt();
			  sum += n;
			  
			  if( n < 4)
			  {
				  Tax = Tax + n*200;
				  WithaBus += n;
			  }
			  else if(n >= 4 && n<12)
			  {
				  Tax = Tax + n*175;
				  WithTruck +=n;
			  }
			  else if(n >= 12)
			  {
				  Tax = Tax + n*120;
				  WithTrain +=n;
			  }
		 }
		 
		 double Sredno = Tax/sum ;
		 double busPersent = (WithaBus / sum )*100;
		 double truckPersent = (WithTruck / sum)*100;
		 double trainPersent = (WithTrain/sum)*100;
		 
		 System.out.printf("%.2f %n",Sredno);
		
		 System.out.printf("%.2f",busPersent); System.out.println("%");
		 System.out.printf("%.2f",truckPersent); System.out.println("%");
		 System.out.printf("%.2f",trainPersent); System.out.println("%");
		 

	}

}
