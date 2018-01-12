package soft_uni.car_dealer_exercise.service.api;

import soft_uni.car_dealer_exercise.domain.dto.PartDto;
import soft_uni.car_dealer_exercise.domain.dto.SupplierDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;
import soft_uni.car_dealer_exercise.domain.model.Supplier;

public interface PartService {
    void createMany(PartRootDto dtos);
    void create(PartDto dto, Supplier supplier);
}
