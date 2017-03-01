package DefiningClassesExr.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0){
            String[] input = reader.readLine().split("\\s+");
            Car car = null;
            String model = input[0];
            Integer engineSpeed = Integer.parseInt(input[1]);
            Integer endginPower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed,endginPower);
            Integer cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < input.length - 1; i += 2) {
                Double tirePressure = Double.parseDouble(input[i]);
                Integer tireAge = Integer.parseInt(input[i + 1]);
                Tire tire = new Tire(tirePressure,tireAge);
                tires.add(tire);
            }

            car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }

        String command = reader.readLine();
        switch (command){
            case "fragile": printFragileCars(cars);
                break;
            case "flamable": printFlamableCars(cars);
                break;
        }
    }

    private static void printFlamableCars(List<Car> cars) {
        for (Car car : cars) {
            if(car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250){
                System.out.println(car.getModel());
            }
        }
    }

    private static void printFragileCars(List<Car> cars) {
        for (Car car : cars) {
            Boolean bool = false;
           if(car.getCargo().getCargoType().equals("fragile")) {
               for (Tire tire : car.getTires()) {
                   if(tire.getTirePressure() < 1 ){
                      bool = true;
                   }
               }
               if(bool){
                   System.out.println(car.getModel());
               }
           }else{
               return;
           }
        }
    }


}
