package soft_uni.car_dealer_exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft_uni.car_dealer_exercise.domain.model.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
