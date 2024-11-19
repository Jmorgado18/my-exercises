package ManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("security");

        EntityManager em = emf.createEntityManager();

        User user = new User();
        user.setUsername("CodeCadet");
        user.setPassword("cenas");

        SecurityGroup sGroup = new SecurityGroup();
        sGroup.addUser(user);

        user.addSgroups(sGroup);

        em.getTransaction().begin();
        em.persist(user);
        em.persist(sGroup);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
