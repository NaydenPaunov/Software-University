package soft_uni.car_dealer_exercise.service.api;

import soft_uni.car_dealer_exercise.domain.dto.CarDto;
import soft_uni.car_dealer_exercise.domain.dto.output.CarOutputDto;
import soft_uni.car_dealer_exercise.domain.dto.root.CarRootDto;

import java.util.List;

public interface CarService  {
    void createMany(CarRootDto dtos);

    List<CarOutputDto> getAllByMake(String make);

    List<CarOutputDto> getAllWithParts();


}
