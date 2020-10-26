package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails", schema = "classicmodels", catalog = "")
@IdClass(value=OrderdetailPK.class)
public class Orderdetail {
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;
    private Order order;
    private Product product;

    @Basic
    @Column(name = "quantityOrdered", nullable = false)
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @Basic
    @Column(name = "priceEach", nullable = false, precision = 2)
    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    @Basic
    @Column(name = "orderLineNumber", nullable = false)
    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderdetail that = (Orderdetail) o;
        return quantityOrdered == that.quantityOrdered &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(priceEach, that.priceEach) &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantityOrdered, priceEach, orderLineNumber, order, product);
    }

    @Override
    public String toString() {
        return "[Orderdetail]" +
                "quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                ", order=" + order +
                ", product=" + product;
    }

    @ManyToOne
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", nullable = false)
    @Id
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", nullable = false)
    @Id
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
