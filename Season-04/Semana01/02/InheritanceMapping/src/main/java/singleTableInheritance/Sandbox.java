package singleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("electronics");

        EntityManager em = emf.createEntityManager();

        Phone phone = new Phone();
        phone.setPrice(550);
        phone.setNumberOfKeys(3);

        AirFrier airFrier = new AirFrier();
        airFrier.setPrice(100);
        airFrier.setPower(120);

        em.getTransaction().begin();
        em.persist(phone);
        em.persist(airFrier);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
