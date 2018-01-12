package soft_uni.car_dealer_exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import soft_uni.car_dealer_exercise.domain.model.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> getAllByMake(String make);
}
