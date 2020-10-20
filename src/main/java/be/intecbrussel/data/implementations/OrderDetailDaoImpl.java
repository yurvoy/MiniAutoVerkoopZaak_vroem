package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.OrderDetailDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.pk.OrderDetailPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(OrderDetail.class, orderDetail.getId()) == null){
                em.persist(orderDetail);
                System.out.println("OrderDetail: " + orderDetail.getId() + " - created");
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
            System.out.println("OrderDetail: " + orderDetail.getId() + " - updated");
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
            OrderDetail orderDetailToDelete = em.find(OrderDetail.class, orderDetail.getId());
            em.remove(orderDetailToDelete);
            transaction.commit();
            System.out.println("OrderDetail: " + orderDetail.getId() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<OrderDetail> readAllOrderDetails() {
        EntityManager em = null;
        List<OrderDetail> orderDetailsList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            orderDetailsList = em.createQuery("SELECT o FROM OrderDetail o", OrderDetail.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return orderDetailsList;
    }
}
