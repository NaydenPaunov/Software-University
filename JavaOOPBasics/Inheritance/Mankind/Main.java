package Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInfo = reader.readLine().split("\\s+");
        String[] workerInfo = reader.readLine().split("\\s+");

        String studentFirstName = studentInfo[0];
        String studentLastName = studentInfo[1];
        String studentFacultyNumber = studentInfo[2];

        String workerFirstName = workerInfo[0];
        String workerLastName = workerInfo[1];
        Double workerWeekSalary =Double.parseDouble(workerInfo[2]);
        Double wordkerPerDay = Double.parseDouble(workerInfo[3]);

        try {
            Student student = new Student(studentFirstName,studentLastName,studentFacultyNumber);
            Worker worker = new Worker(workerFirstName,workerLastName,workerWeekSalary,wordkerPerDay);
            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }



    }
}
