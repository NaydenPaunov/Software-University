package Ingredient.Basic;

import Ingredient.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "LR")
public class Lavender extends BasicIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(2);

    private static final String NAME = "Lavender";

    public Lavender() {
        super(NAME, PRICE);
    }
}
