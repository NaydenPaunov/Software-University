package DefiningClassesExr.SpeedRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Main {
    public static List<Car> carList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Integer numberOfCars = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = reader.readLine().split("\\s+");
            addCars(input);
        }

        String line = reader.readLine();
        while (!line.equals("End")){
            String[] input = line.split("\\s+");
            tryToDriveCars(input);
            line = reader.readLine();
        }

        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    private static void tryToDriveCars(String[] input) {
        String carModel = input[1];
        Integer wandetDistance = Integer.parseInt(input[2]);
        for (Car car : carList) {
            if(car.getCarModel().equals(carModel)){
                car.moveCar(wandetDistance);
            }
        }
    }

    private static void addCars(String[] input) {
        String currentCarModel = input[0];
        Double fuelAmount = Double.parseDouble(input[1]);
        Double fuelCost = Double.parseDouble(input[2]);
        Car currentCar = new Car(currentCarModel,fuelAmount,fuelCost);
        carList.add(currentCar);
    }
}


