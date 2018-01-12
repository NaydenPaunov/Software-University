import Ingredient.Basic.Mint;
import Ingredient.Basic.Nettle;
import Ingredient.Basic.Strawberry;
import Ingredient.BasicIngredient;
import Ingredient.Chemical.AmmoniumChloride;
import Shampoo.BasicShampoo;
import Shampoo.FiftyShades;
import Shampoo.FreshNuke;
import label.BasicLabel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Application Test
public class MainClass {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("shampooCompany");

        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label = new BasicLabel("Fresh Nuke Shampoo", "Containts mint and nettle");

        BasicShampoo shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        em.persist(shampoo);

        em.getTransaction().commit();
        em.close();


    }
}
