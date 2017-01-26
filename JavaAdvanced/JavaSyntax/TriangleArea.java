package JavaSyntax;
import java.util.Scanner;
 
 
public class TriangleArea {
 
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                String aAsString = input.nextLine();
                String[] pointA = aAsString.split(" ");
                String bAsString = input.nextLine();
                String[] pointB = bAsString.split(" ");
                String cAsString = input.nextLine();
                String[] pointC = cAsString.split(" ");
                int ax = Integer.parseInt(pointA[0]);
                int ay = Integer.parseInt(pointA[1]);
                int bx = Integer.parseInt(pointB[0]);
                int by = Integer.parseInt(pointB[1]);
                int cx = Integer.parseInt(pointC[0]);
                int cy = Integer.parseInt(pointC[1]);
                int area = (ax*(by-cy) + bx*(cy-ay) + cx*(ay-by))/2;
                if(area>0){
                System.out.println(area);
                       
                }
                else {
                        System.out.println(area*-1);
                }
               
 
        }
 
}