package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("citizens");

        EntityManager em = emf.createEntityManager();

        Person person = new Person();
        person.setName("Leonardo");
        person.setAge(15);

        CV cv = new CV();
        cv.setPerson(person);

        person.setCv(cv);

        em.getTransaction().begin();
        em.persist(person);
        em.persist(cv);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
