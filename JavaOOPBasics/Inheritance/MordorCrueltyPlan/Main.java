package Inheritance.MordorCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = reader.readLine().split("\\s+");
        Integer happines = 0;
        for (int i = 0; i < foods.length; i++) {
            if((foods[i].toLowerCase()).equals("cram")){
                happines += 2;
            }else if((foods[i].toLowerCase()).equals("lembas")){
                happines += 3;
            }else if((foods[i].toLowerCase()).equals("apple")) {
                happines += 1;
            }else if((foods[i].toLowerCase()).equals("melon")) {
                happines += 1;
            }else if((foods[i].toLowerCase()).equals("honeycake")) {
                happines += 5;
            }else if((foods[i].toLowerCase()).equals("mushrooms")) {
                happines -= 10;
            }else {
                happines -= 1;
            }
        }
        System.out.println(happines);
         if(happines < -5){
             System.out.println("Angry");
         }else if(happines >= -5 && happines < 0 ){
             System.out.println("Sad");
         }else if(happines >= 0 &&  happines < 15){
             System.out.println("Happy");
         }else if(happines >= 15){
             System.out.println("JavaScript");
         }

    }
}
