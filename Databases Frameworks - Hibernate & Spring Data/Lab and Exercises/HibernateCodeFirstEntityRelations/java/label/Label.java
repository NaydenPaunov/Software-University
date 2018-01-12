package label;

import Shampoo.BasicShampoo;

import java.io.Serializable;

interface Label extends Serializable {
    long getId();

    void setId(long id);

    String getTitle();

    void setTitle(String title);

    String getSubtitle();

    void setSubtitle(String subtitle);

    BasicShampoo getBasicShampoo();

    void setBasicShampoo(BasicShampoo basicShampoo);
}
