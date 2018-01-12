package Shampoo;

import Size.Size;
import label.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    private static final String FRESH_NUKE = "Fresh Nuke";
    private static final BigDecimal PRICE = BigDecimal.valueOf(9.33);

    public FreshNuke(BasicLabel label) {
        super(FRESH_NUKE, Size.BIG ,label, PRICE);
    }
}
