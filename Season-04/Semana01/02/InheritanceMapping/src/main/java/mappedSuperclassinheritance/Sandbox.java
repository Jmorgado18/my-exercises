package mappedSuperclassinheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("music");

        EntityManager em = emf.createEntityManager();

        Guitar guitar = new Guitar();
        guitar.setTunning("EADGBE");
        guitar.setType("Chordophone");

        Piano piano = new Piano();
        piano.setTunning("Standard");
        piano.setType("Chordophones");

        em.getTransaction().begin();
        em.persist(guitar);
        em.persist(piano);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
