package be.intecbrussel.data.implementations;

import be.intecbrussel.data.daos.PaymentDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Payment;
import be.intecbrussel.entities.pk.PaymentPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createPayment(Payment payment) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Payment.class, payment.getId()) == null){
                em.persist(payment);
                System.out.println("Payment: " + payment.getId() + " - created");
            } else {
                em.merge(payment);
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
    public Payment readPayment(PaymentPK paymentPK) {
        Payment payment = new Payment();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            payment = em.find(Payment.class, paymentPK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return payment;
    }

    @Override
    public void updatePayment(Payment payment) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(payment);
            transaction.commit();
            System.out.println("Payment: " + payment.getId() + " - updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deletePayment(Payment payment) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(payment);
            transaction.commit();
            System.out.println("Payment: " + payment.getId() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Payment> readAllPayments() {
        EntityManager em = null;
        List<Payment> paymentsList = new ArrayList<>();
        try {
            em = emf.createEntityManager();
            paymentsList = em.createQuery("SELECT p FROM Payment p", Payment.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return paymentsList;
    }
}
