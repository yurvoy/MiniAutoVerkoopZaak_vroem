package be.intecbrussel.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "classicmodels", catalog = "")
public class Order {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private Collection<Orderdetail> orderdetails;
    private Customer customer;

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "orderDate", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "requiredDate", nullable = false)
    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Basic
    @Column(name = "shippedDate", nullable = true)
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 15)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = -1)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(requiredDate, order.requiredDate) &&
                Objects.equals(shippedDate, order.shippedDate) &&
                Objects.equals(status, order.status) &&
                Objects.equals(comments, order.comments) &&
                Objects.equals(orderdetails, order.orderdetails) &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, requiredDate, shippedDate, status, comments, orderdetails, customer);
    }

    @Override
    public String toString() {
        return "[Order]" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate;
    }

    @OneToMany(mappedBy = "order")
    public Collection<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(Collection<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
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
