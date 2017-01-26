package JavaSyntax;

import java.util.Scanner;
import java.math.BigDecimal;

public class LabEuroTrip {

	public static void main(String[] args) {
		//Euro Trip
		
		Scanner scanner = new Scanner(System.in);
		
		double quantity = scanner.nextDouble();
		
		BigDecimal exchangeRate = new BigDecimal("4210500000000");
		BigDecimal priceInLeva = new BigDecimal(1.20 * quantity);
		BigDecimal totalPrice = priceInLeva.multiply(exchangeRate);
	 
		System.out.printf("%.2f marks",totalPrice);
		

	}

}
