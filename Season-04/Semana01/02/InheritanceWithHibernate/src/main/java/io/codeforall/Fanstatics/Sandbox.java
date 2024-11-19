package io.codeforall.Fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        //MappedSuperClass


        MappedSuperclass.Customer customer = new MappedSuperclass.Customer();
        MappedSuperclass.Account account = new MappedSuperclass.Account();
        customer.setName("Joao");
        account.setBallance(1000.00);

        MappedSuperclass.Customer customer2 = new MappedSuperclass.Customer();
        MappedSuperclass.Account account2 = new MappedSuperclass.Account();
        customer2.setName("David");
        account2.setBallance(100.00);

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        //TablePerClass



    }
}
