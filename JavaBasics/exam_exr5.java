package javaBasics;

import java.util.Scanner;

/*
Задача 5. Ракета
Да се напише програма, която прочита от конзолата цяло четно число N и чертае ракета, като в примерите по-долу.
Ракетата има ширина – 3 * N колони. 
 n = 4
...../\.....
..../  \....
.../    \...
../      \..
..********..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
..|\\\\\\|..
../******\..
./********\.	

n = 6
......../\........
......./  \.......
....../    \......
...../      \.....
..../        \....
.../          \...
...************...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
...|\\\\\\\\\\|...
.../**********\...
../************\..
./**************\.	
*/

public class exam_exr5 {

	
	static String repeatStr(String strToRepeat, int count) {
		   StringBuilder sb = new StringBuilder();
		   
		   for (int i = 0; i < count; i++) {
		      sb.append(strToRepeat);
		   } 

		   return sb.toString();
		}

	
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		
		 int n = Integer.parseInt(input.nextLine());
		 
		 // n*3 -2
		 int formula1 = (n*3 - 2)/2;
		 int Spaces = 0;
		 for(int i = 1 ; i <= n ; i++)
		 {  
			
		   System.out.println(repeatStr(".",formula1) + "/" + repeatStr(" ",Spaces) + "\\" +  repeatStr(".",formula1) );	
		   formula1--;
		   Spaces +=2;
		 }
		 
		 System.out.println(repeatStr(".",n/2) + repeatStr("*",n*2) +repeatStr(".",n/2) );
		 
		 for(int j = 1 ; j <= n*2 ; j++)
		 {   int formula2 = n*2 - 2;
			 System.out.println(repeatStr(".",n/2) + "|" + repeatStr("\\",formula2) + "|" +repeatStr(".",n/2));
		 }
		
		 
		 int formula3 = n/2;
		 int formula4 = 2*n-2;
		 for(int g = 1 ; g <= n/2 ; g++)
		 {  
			
			 System.out.println(repeatStr(".",formula3) + "/" + repeatStr("*",formula4)+"\\" + repeatStr(".",formula3));
			 formula3 -=1;
			 formula4 +=2;
		 }
		 
		 
	}

}
