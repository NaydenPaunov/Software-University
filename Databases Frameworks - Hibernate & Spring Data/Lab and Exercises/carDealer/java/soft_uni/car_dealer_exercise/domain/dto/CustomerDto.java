package soft_uni.car_dealer_exercise.domain.dto;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;
    @XmlElement(name = "birth-date")
    private Date bornOn;

    public CustomerDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Date getBornOn() {
        return this.bornOn;
    }

    public void setBornOn(Date bornOn) {
        this.bornOn = bornOn;
    }
}
