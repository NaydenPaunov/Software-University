package soft_uni.car_dealer_exercise.domain.dto.root;

import soft_uni.car_dealer_exercise.domain.dto.CarDto;
import soft_uni.car_dealer_exercise.domain.dto.CustomerDto;
import soft_uni.car_dealer_exercise.domain.dto.output.CarOutputDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRootDto {
    @XmlElement(name = "car")
    private List<CarOutputDto> cars;

    public CarRootDto() {
    }

    public List<CarOutputDto> getCars() {
        return cars;
    }

    public void setCars(List<CarOutputDto> cars) {
        this.cars = cars;
    }
}
