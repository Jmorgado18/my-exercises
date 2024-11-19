package io.codeforall.fanstatics;

import com.example.tableperclass.Employee;
import com.example.singletable.Vehicle;
import com.example.joinedtable.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("inheritance-example");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Table per Class
            Employee emp = new Employee("John Doe", 30, "Engineering");
            em.persist(emp);

            // Single Table
            Vehicle vehicle = new Vehicle("Car Model X", 5, "Sedan");
            em.persist(vehicle);

            // Joined Table
            Product product = new Product("Laptop", 2, 1200.99);
            em.persist(product);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
