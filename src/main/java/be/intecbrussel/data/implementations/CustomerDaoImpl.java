package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.CustomerDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CustomerDaoImpl implements CustomerDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createCustomer(Customer customer) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Customer.class, customer.getCustomerNumber()) == null){
                em.persist(customer);
                System.out.println("Customer: " + customer.getCustomerNumber() + " - created");
            } else {
                em.merge(customer);
            }
            transaction.commit();
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
            System.out.println("Customer: " + customer.getCustomerNumber() + " - updated");
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
            Customer customerToDelete = em.find(Customer.class, customer.getCustomerNumber());
            em.remove(customerToDelete);
            transaction.commit();
//            System.out.println("Customer: " + customer.getCustomerNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
