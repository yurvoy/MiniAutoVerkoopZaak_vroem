package be.intecbrussel.data.daos;

import be.intecbrussel.entities.Payment;

import java.util.List;

public interface PaymentDAO {

    void createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
    List<Payment> readAllPayments();
}
