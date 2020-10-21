package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "classicmodels", catalog = "")
@IdClass(PaymentPK.class)
public class Payment {
    private LocalDate paymentDate;
    private BigDecimal amount;
    private int customerNumber;
    private String checkNumber;
    private Customer customer;

    public Payment() {
    }

    @Basic
    @Column(name = "paymentDate", nullable = false)
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return customerNumber == payment.customerNumber &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(checkNumber, payment.checkNumber) &&
                Objects.equals(customer, payment.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentDate, amount, customerNumber, checkNumber, customer);
    }

    @Id
    @Column(name = "customerNumber", nullable = false)
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @Column(name = "checkNumber", nullable = false, length = 50)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}


