package be.intecbrussel.entities;

import be.intecbrussel.entities.pk.PaymentPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payments")
@IdClass(PaymentPK.class)
public class Payment implements Serializable {
    private int customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private double amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
