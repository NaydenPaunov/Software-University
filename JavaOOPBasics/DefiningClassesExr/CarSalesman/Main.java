package DefiningClassesExr.CarSalesman;

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

        List<Engine> engineList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0){
            String[] line = reader.readLine().split("\\s+");
            Engine engine = null;
            String engineModel = line[0];
            Integer enginePower = Integer.parseInt(line[1]);

            switch (line.length){
                case 2 :
                    engine = new Engine(engineModel,enginePower);
                    break;
                case 3 :
                    try {
                        Integer displacement =Integer.parseInt(line[2]);
                        engine = new Engine(engineModel,enginePower,displacement);
                    }catch (NumberFormatException ex ){
                        String efficiency = reader.readLine();
                        engine = new Engine(engineModel,enginePower,efficiency);
                    }
                    break;
                case 4 :
                    Integer displacement = Integer.parseInt(line[2]);
                    String efficiency = line[3];
                    engine = new Engine(engineModel,enginePower,displacement,efficiency);
                    break;
            }
            engineList.add(engine);
        }

        Integer m = Integer.parseInt(reader.readLine());

        while (m-- > 0){
            String[] line = reader.readLine().split("\\s+");
            Car car = null;
            String carModel = line[0];
            String carEngine = line[1];

            switch (line.length){
                case 2 :
                    car = new Car(carModel,carEngine);
                    break;
                case 3 :
                    try{
                        Integer carWeight = Integer.parseInt(line[2]);
                        car = new Car(carModel,carEngine,carWeight);
                    }catch (NumberFormatException ex){
                        String carColor = line[2];
                        car = new Car(carModel,carEngine,carColor);
                    }
                    break;
                case 4:
                    Integer carWeight = Integer.parseInt(line[2]);
                    String carColor = line[3];
                    car = new Car(carModel,carEngine,carWeight,carColor);
                    break;
            }
            cars.add(car);
        }
        printLines(cars,engineList);
    }

    private static void printLines(List<Car> cars, List<Engine> engineList) {
        try {
        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println("  " + car.getEngine()+":");
            for (Engine engine : engineList) {
                if(car.getEngine().equals(engine.getEngineModel())){
                    System.out.println("    Power: " + engine.getEnginePower());
                    if(engine.getDisplacement() != null){
                        System.out.println("    Displacement: " + engine.getDisplacement());
                    }else{
                        System.out.println("    " + "Displacement: n/a");
                    }
                    if(engine.getEfficiency() != null){
                        System.out.println("    Efficiency: " + engine.getEfficiency());
                    }else{
                        System.out.println("    Efficiency: n/a");
                    }
                }
            }
            if(car.getWeight() != null){
                System.out.println("  Weight: " + car.getWeight());
            }else {
                System.out.println("  Weight: n/a");
            }
            if(car.getColor() != null){
                System.out.println("  Color: " + car.getColor());
            }else {
                System.out.println("  Color: n/a");
            }
        }
    }catch (NullPointerException ex){}
}
}
