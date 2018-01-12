package Shampoo;

import java.math.BigDecimal;
import java.util.Set;

import Ingredient.BasicIngredient;
import Size.Size;
import label.BasicLabel;

interface Shampoo {

    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    BasicLabel getLabel();

    void setLabel(BasicLabel label);

    Set<BasicIngredient> getIngredients();

    void setIngredients (Set<BasicIngredient> ingredients);

}
