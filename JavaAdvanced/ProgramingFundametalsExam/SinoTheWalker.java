package ProgramingFundametalsExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by na4oy on 20.2.2017 г..
 */
public class SinoTheWalker {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String myTime = reader.readLine().trim();
        Integer numberOfSteps = Integer.parseInt(reader.readLine().trim());
        Integer secondForEachStep = Integer.parseInt(reader.readLine().trim());

        Integer secondNeeded = numberOfSteps * secondForEachStep;

        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
        Date data = dataFormat.parse(myTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.SECOND, secondNeeded);
        String newTime = dataFormat.format(cal.getTime());
        System.out.println("Time Arrival: " + newTime);

    }
}
