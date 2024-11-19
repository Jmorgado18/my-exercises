package joinedTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chips");

        EntityManager em = emf.createEntityManager();

        SoC soC = new SoC();
        soC.setMaxSpeed(1000);
        soC.setName("Apple");

        TickTock tickTock = new TickTock();
        tickTock.setMaxSpeed(500);
        tickTock.setPerformance("low");

        em.getTransaction().begin();
        em.persist(soC);
        em.persist(tickTock);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
