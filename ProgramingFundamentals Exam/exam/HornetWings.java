package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 26.2.2017 г..
 */
public class HornetWings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer wingFlaps = Integer.parseInt(reader.readLine());
        //Distance for 1000 wing flaps
        Double distanceInMeter = Double.parseDouble(reader.readLine());
        //how many wing flaps he can make, before he stops to take a break for 5 seconds
        Integer endurance = Integer.parseInt(reader.readLine());

        Double totalDistance = (wingFlaps / 1000) * distanceInMeter ;
        Integer flapsForSecond =  (wingFlaps / 100) ;
        Integer restsSeconds = (wingFlaps / endurance) * 5;
        Integer totalRest = flapsForSecond + restsSeconds;

        System.out.printf("%.2f m.%n%d s.",totalDistance,totalRest);

    }
}
