package soft_uni.car_dealer_exercise.service.api;

import org.springframework.stereotype.Service;
import soft_uni.car_dealer_exercise.domain.dto.SupplierDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;

public interface SupplierService {
    void create(SupplierDto dto);
}
