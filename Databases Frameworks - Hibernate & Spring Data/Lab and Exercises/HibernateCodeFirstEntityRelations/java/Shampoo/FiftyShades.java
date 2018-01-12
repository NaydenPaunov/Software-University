package Shampoo;

import Size.Size;
import label.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {

    private static final BigDecimal PRICE = BigDecimal.valueOf(6.69);
    private static final String FIFTY_SHADES = "Fifty Shades";

    public FiftyShades(BasicLabel label) {
        super(FIFTY_SHADES, Size.SMALL, label, PRICE);
    }
}
