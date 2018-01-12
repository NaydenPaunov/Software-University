package soft_uni.car_dealer_exercise.domain.dto.output;

import soft_uni.car_dealer_exercise.domain.dto.PartDto;
import soft_uni.car_dealer_exercise.domain.dto.root.PartRootDto;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarOutputDto {
    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;
    @XmlElement(name = "parts")
    private PartRootDto parts;

    public CarOutputDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartRootDto getParts() {
        return parts;
    }

    public void setParts(PartRootDto parts) {
        this.parts = parts;
    }
}