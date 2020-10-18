package be.intecbrussel.entities.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentId implements Serializable {

    private int customerNumber;
    private String checkNumber;

    public PaymentId() {
    }

    public PaymentId(int customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
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
        PaymentId paymentId = (PaymentId) o;
        return customerNumber == paymentId.customerNumber &&
                Objects.equals(checkNumber, paymentId.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }
}
