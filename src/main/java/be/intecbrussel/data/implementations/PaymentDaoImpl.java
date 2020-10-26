package be.intecbrussel.data.implementations;

import be.intecbrussel.data.crud_daos.PaymentDAO;
import be.intecbrussel.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.entities.Payment;
import be.intecbrussel.entities.PaymentPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PaymentDaoImpl implements PaymentDAO {
    private EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();

    @Override
    public void createPayment(Payment payment) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            if (em.find(Payment.class, new PaymentPK(payment.getCustomer(), payment.getCheckNumber())) == null){
                em.persist(payment);
                System.out.println("Payment: " + payment.getCheckNumber() + " - created");
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
            System.out.println("Payment: " + payment.getCheckNumber() + " - updated");
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
            Payment paymentToDelete = em.find(Payment.class, payment.getCheckNumber());
            em.remove(paymentToDelete);
            transaction.commit();
            System.out.println("Payment: " + payment.getCheckNumber() + " - deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
