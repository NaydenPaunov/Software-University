package needForSpeed.core;

import needForSpeed.entities.cars.Car;
import needForSpeed.entities.cars.PerformanceCar;
import needForSpeed.entities.cars.ShowCar;
import needForSpeed.entities.garage.Garage;
import needForSpeed.entities.races.CasualRace;
import needForSpeed.entities.races.DragRace;
import needForSpeed.entities.races.DriftRace;
import needForSpeed.entities.races.Race;

import java.util.HashMap;
import java.util.Map;

import static needForSpeed.utilities.Constants.*;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }


    public void register(int id, String type, String brand, String model, int
            yearOfProduction, int horsepower, int acceleration, int suspension, int
                          durability){
        Car car = null;
        switch (type){
            case PERFORMANCE_CAR_TYPE :
                car = new PerformanceCar(brand,model,yearOfProduction,horsepower,acceleration,suspension,durability);
                break;
            case SHOW_CAR_TYPE :
                car = new ShowCar(brand,model,yearOfProduction,horsepower,acceleration,suspension,durability);
                break;
        }
        this.cars.putIfAbsent(id,car);
    }

    public String check(int id){
        if(this.cars.containsKey(id)){
            return this.cars.get(id).toString();
        }
        return  null;
    }

    public void open(int id, String type, int length, String route, int prizePool){
        Race race = null;
        switch (type) {
            case CASUAL_RACE_TYPE:
                race = new CasualRace(length, route, prizePool);
                break;
            case DRIFT_RACE_TYPE:
                race = new DriftRace(length, route, prizePool);
                break;
            case DRAG_RACE_TYPE:
                race = new DragRace(length, route, prizePool);
                break;
        }
        this.races.putIfAbsent(id,race);
    }

    public void participate(int carId, int raceId){
        if(this.cars.containsKey(carId) && this.races.containsKey(raceId) &&
                !this.garage.getParkedCars().contains(this.cars.get(carId))){
            Race race = this.races.get(raceId);
            Car car = this.cars.get(carId);

            race.addCar(car);

        }
    }

    public String start(int id) {
        if (this.races.containsKey(id) && this.races.get(id).getParticipants().size() != 0) {
            return this.races.remove(id).toString();
        }
        return "Cannot start the race with zero participants.";
    }

    public void park(int id){
        if(this.cars.containsKey(id)){
            Car car = this.cars.get(id);
            long countOfRaces = this.races.values().stream().filter(r -> r.getParticipants().contains(car)).count();
            if(countOfRaces == 0){
                this.garage.park(car);
            }
        }

        this.garage.park(this.cars.get(id));
    }

    public void unpark(int id){
        if(this.cars.containsKey(id) && this.garage.getParkedCars().contains(this.cars.get(id))){
            Car car = this.cars.get(id);
            this.garage.unPark(car);
        }
    }

    public void tune(int tuneIndex, String addOn){
        if(this.garage.getParkedCars().size() != 0){
            this.garage.tune(tuneIndex,addOn);
        }
    }
}
