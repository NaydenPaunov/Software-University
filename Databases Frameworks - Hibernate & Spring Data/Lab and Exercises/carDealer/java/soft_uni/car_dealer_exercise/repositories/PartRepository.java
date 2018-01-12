package soft_uni.car_dealer_exercise.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soft_uni.car_dealer_exercise.domain.model.Part;

@Repository
public interface PartRepository extends CrudRepository<Part, Long> {
}
