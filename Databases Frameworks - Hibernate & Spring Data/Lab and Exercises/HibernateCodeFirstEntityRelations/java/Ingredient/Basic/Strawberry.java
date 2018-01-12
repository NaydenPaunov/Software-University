package Ingredient.Basic;

import Ingredient.BasicIngredient;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "ST")
public class Strawberry extends BasicIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(4.85);

    private static final  String NAME = "Strawberry";

    public Strawberry() {
        super(NAME, PRICE);
    }
}
