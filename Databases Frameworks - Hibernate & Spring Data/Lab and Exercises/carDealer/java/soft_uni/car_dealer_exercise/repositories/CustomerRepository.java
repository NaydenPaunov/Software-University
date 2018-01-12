package soft_uni.car_dealer_exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import soft_uni.car_dealer_exercise.domain.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
