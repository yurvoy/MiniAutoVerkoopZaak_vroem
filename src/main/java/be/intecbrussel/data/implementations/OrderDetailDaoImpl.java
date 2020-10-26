package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.OrderDetailDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Orderdetail;
import be.intecbrussel.entities.OrderdetailPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class OrderDetailDaoImpl implements OrderDetailDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createOrderDetail(Orderdetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Orderdetail.class, orderDetail.getOrderLineNumber()) == null){
                em.persist(orderDetail);
                System.out.println("Orderdetail: " + orderDetail.getOrderLineNumber() + " - created");
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
    public Orderdetail readOrderDetail(OrderdetailPK orderdetailPK) {
        EntityManager em = null;
        Orderdetail orderdetail = null;
        try {
            em = emf.createEntityManager();
            orderdetail = em.find(Orderdetail.class, orderdetailPK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return orderdetail;
    }

    @Override
    public void updateOrderDetail(Orderdetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(orderDetail);
            transaction.commit();
            System.out.println("Orderdetail: " + orderDetail.getOrderLineNumber() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteOrderDetail(Orderdetail orderDetail) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Orderdetail orderDetailToDelete = em.find(Orderdetail.class, orderDetail.getOrderLineNumber());
            em.remove(orderDetailToDelete);
            transaction.commit();
            System.out.println("Orderdetail: " + orderDetail.getOrderLineNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
