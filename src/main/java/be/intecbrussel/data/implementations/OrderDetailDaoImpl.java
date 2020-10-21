package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.OrderDetailDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDetailDaoImpl implements OrderDetailDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(OrderDetail.class, orderDetail.getOrderLineNumber()) == null){
                em.persist(orderDetail);
                System.out.println("OrderDetail: " + orderDetail.getOrderLineNumber() + " - created");
            } else {
                em.merge(orderDetail);
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
    public OrderDetail readOrderDetail(OrderDetailPK orderDetailPK) {
        OrderDetail orderDetail = new OrderDetail();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            orderDetail = em.find(OrderDetail.class, orderDetailPK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return orderDetail;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(orderDetail);
            transaction.commit();
            System.out.println("OrderDetail: " + orderDetail.getOrderLineNumber() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            OrderDetail orderDetailToDelete = em.find(OrderDetail.class, orderDetail.getOrderLineNumber());
            em.remove(orderDetailToDelete);
            transaction.commit();
            System.out.println("OrderDetail: " + orderDetail.getOrderLineNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
