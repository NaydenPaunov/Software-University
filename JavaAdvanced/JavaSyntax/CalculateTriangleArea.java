package JavaSyntax;

import java.util.Scanner;

public class CalculateTriangleArea {

	public static void triangleArea(double heigth , double base){
		double area = (heigth*base)/2;
		System.out.printf("Area = %.2f",area);
		
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double heigth = scanner.nextDouble();
		double base = scanner.nextDouble();
		
		triangleArea(heigth,base);
	}

}
