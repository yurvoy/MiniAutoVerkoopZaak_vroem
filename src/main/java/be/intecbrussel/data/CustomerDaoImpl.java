package be.intecbrussel.data;

import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createCustomer(Customer customer) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(customer);
            transaction.commit();
            System.out.println("Customer: " + customer.getCustomerName() + " - created");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Customer readCustomer(int customerId) {
        EntityManager em = null;
        Customer customer = new Customer();
        try {
            em = emf.createEntityManager();
            customer = em.find(Customer.class, customerId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(customer);
            transaction.commit();
            System.out.println("Customer: " + customer.getCustomerName() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(customer);
            transaction.commit();
            System.out.println("Customer: " + customer.getCustomerName() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> readAllCustomers() {
        EntityManager em = null;
        List<Customer> customersList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            customersList = em.createQuery("SELECT c FROM Customer c", Customer.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return customersList;
    }
}
