package be.intecbrussel.entities.pk;

import be.intecbrussel.entities.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentPK implements Serializable {
    @ManyToOne
    @JoinColumn(name =  "customerNumber")
    private Customer customer;
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(Customer customerNumber, String checkNumber) {
        this.customer = customerNumber;
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentPK paymentPK = (PaymentPK) o;
        return Objects.equals(customer, paymentPK.customer) &&
                Objects.equals(checkNumber, paymentPK.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, checkNumber);
    }
}
