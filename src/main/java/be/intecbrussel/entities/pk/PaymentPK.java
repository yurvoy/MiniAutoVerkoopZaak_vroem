package be.intecbrussel.entities.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class PaymentPK implements Serializable {

    private int customerNumber;
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(int customerNumber, String checkNumber) {
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
        PaymentPK paymentPK = (PaymentPK) o;
        return customerNumber == paymentPK.customerNumber &&
                Objects.equals(checkNumber, paymentPK.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }
}
