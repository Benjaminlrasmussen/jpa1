package com.mycompany.jpa1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Facade
{

    private EntityManager eManager;

    public Facade(EntityManagerFactory emf)
    {
        eManager = emf.createEntityManager();
    }

    public void createCustomer(Customer customer)
    {
        eManager.getTransaction().begin();
        eManager.persist(customer);
        eManager.getTransaction().commit();
    }

    public Customer findCustomer(String email)
    {
        List<Customer> list = eManager.createNamedQuery("findCustomer", Customer.class).setParameter("email", email).getResultList();

        if (list != null && list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }

    public List<Customer> findAllCustomers(String email)
    {
        return eManager.createNamedQuery("findAllCustomers", Customer.class).setParameter("email", email).getResultList();
    }

    public void createOrder(CustomerOrder order, Customer customer)
    {
        order.setCustomer(customer);
        customer.addOrder(order);
        
        eManager.getTransaction().begin();
        eManager.persist(order);
        eManager.getTransaction().commit();
    }

    public void closeEntityManager()
    {
        eManager.close();
    }
}
