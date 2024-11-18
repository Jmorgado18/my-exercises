package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class sandbox {

    public static void main(String[] args) {

        Integer id;

// Use the test persistence unit to configure a new
// entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

// Open a new database connection by getting a new
// entity manager from the entity manager factory

        EntityManager em = emf.createEntityManager();
        Cadet cadet = new Cadet();
        Address address = new Address();
        address.setCity("Porto");
        address.setStreet("Rua do sobe e desce nº69");
        address.setZipcode("4435");

        // cadet.setId(1);
        cadet.setName("Joao Morgado");
        cadet.setAge(33);
        cadet.setAddress(address);
        cadet.setPassword("atuamaedequatro");

        em.getTransaction().begin();
        em.persist(cadet);
        em.getTransaction().commit();


        findById(cadet.getId());



        // Used to test the database connection, should return 2
        // System.out.println("Result: " +
        //       em.createNativeQuery("select 1 + 1").getSingleResult());


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();


    }

    private static void findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println(em.find(Cadet.class, 1));
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}