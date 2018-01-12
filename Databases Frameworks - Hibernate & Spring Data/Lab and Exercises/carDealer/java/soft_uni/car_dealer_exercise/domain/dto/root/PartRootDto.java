package soft_uni.car_dealer_exercise.domain.dto.root;

import soft_uni.car_dealer_exercise.domain.dto.PartDto;
import soft_uni.car_dealer_exercise.domain.model.Part;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootDto {
    @XmlElement(name = "part")
    private Set<PartDto> parts;

    public PartRootDto() {
        parts = new HashSet<>();
    }

    public Set<PartDto> getParts() {
            return parts;
        }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }
}
