package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.OrderDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDaoImpl implements OrderDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrder(Order order) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Order.class, order.getOrderNumber()) == null){
                em.persist(order);
                System.out.println("Order: " + order.getOrderNumber() + " - created");
            } else {
                em.merge(order);
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
    public Order readOrder(int orderNumber) {
        Order order = new Order();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            order = em.find(Order.class, orderNumber);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(order);
            transaction.commit();
            System.out.println("Order: " + order.getOrderNumber() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOrder(Order order) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Order orderToDelete = em.find(Order.class, order.getOrderNumber());
            em.remove(orderToDelete);
            transaction.commit();
            System.out.println("Order: " + order.getOrderNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
