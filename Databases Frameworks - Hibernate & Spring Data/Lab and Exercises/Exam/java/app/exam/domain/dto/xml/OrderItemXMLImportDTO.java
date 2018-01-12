package app.exam.domain.dto.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemXMLImportDTO {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "quantity")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
