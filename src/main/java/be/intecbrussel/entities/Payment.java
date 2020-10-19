package be.intecbrussel.entities;

import be.intecbrussel.entities.pk.PaymentPK;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {
    @EmbeddedId
    PaymentPK id;

    private LocalDate paymentDate;
    private BigDecimal amount;

    public Payment() {
    }

    public PaymentPK getId() {
        return id;
    }

    public void setId(PaymentPK id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "[Payment]" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDate, amount);
    }
}


