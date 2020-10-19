package be.intecbrussel.data.implementations;

import be.intecbrussel.data.daos.OrderDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Office;
import be.intecbrussel.entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();


    @Override
    public void createOrder(Order order) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Office.class, order.getOrderNumber()) == null){
                em.persist(order);
            } else {
                em.merge(order);
            }
            transaction.commit();
            if (order != null) {
                System.out.println("Office: " + order.getOrderNumber() + " - created");
            }
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
            System.out.println(order);
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
            em.remove(order);
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

    @Override
    public List<Order> readAllOrders() {
        EntityManager em = null;
        List<Order> ordersList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            ordersList = em.createQuery("SELECT o FROM Order o", Order.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return ordersList;
    }
}
