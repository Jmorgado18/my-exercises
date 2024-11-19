package ManyToOne;

import OneToOne.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("store");

        EntityManager em = emf.createEntityManager();

        Category category = new Category();
        category.setName("Beauty");

        Product product = new Product();
        product.setCategory(category);
        product.setName("Blush");

        em.getTransaction().begin();
        em.persist(category);
        em.persist(product);
        em.getTransaction().commit();


        em.close();
        emf.close();

    }

}
