package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.Payment;
import be.intecbrussel.entities.pk.PaymentPK;

import java.util.List;

public interface PaymentDAO {

    void createPayment(Payment payment);
    Payment readPayment(PaymentPK paymentPK);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
    List<Payment> readAllPayments();
}
