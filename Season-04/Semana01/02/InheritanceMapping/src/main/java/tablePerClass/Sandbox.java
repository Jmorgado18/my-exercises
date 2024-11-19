package tablePerClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("animals");

        EntityManager em = emf.createEntityManager();

        Gazelle gazelle = new Gazelle();
        gazelle.setMaxChildren(1);
        gazelle.setMaxSpeed(120);

        Octopus octopus = new Octopus();
        octopus.setMaxChildren(100);
        octopus.setNumberOfArms(8);

        em.getTransaction().begin();
        em.persist(gazelle);
        em.persist(octopus);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
