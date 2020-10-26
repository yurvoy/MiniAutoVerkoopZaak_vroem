package be.intecbrussel.entities;

import java.io.Serializable;
import java.util.Objects;

public class PaymentPK implements Serializable {

    private Customer customer;
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(Customer customer, String checkNumber) {
        this.customer = customer;
        this.checkNumber = checkNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentPK paymentPK = (PaymentPK) o;
        return customer == paymentPK.customer &&
                Objects.equals(checkNumber, paymentPK.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, checkNumber);
    }
}
