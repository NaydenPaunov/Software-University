package soft_uni.car_dealer_exercise.domain.dto.root;

import soft_uni.car_dealer_exercise.domain.dto.SupplierDto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {
    @XmlElement(name = "supplier")
    private List<SupplierDto> supplierDtos;

    public SupplierRootDto() {
        supplierDtos = new ArrayList<>();
    }

    public List<SupplierDto> getSupplierDtos() {
        return supplierDtos;
    }

    public void setSupplierDtos(List<SupplierDto> supplierDtos) {
        this.supplierDtos = supplierDtos;
    }
}
