package Shampoo;

import Size.Size;
import label.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {

    private static final String PINK_PANTHER = "Pink Panther";
    private static final BigDecimal PRICE = BigDecimal.valueOf(8.50);

    public PinkPanther(BasicLabel label) {
        super(PINK_PANTHER, Size.MEDIUM, label, PRICE);
    }
}
