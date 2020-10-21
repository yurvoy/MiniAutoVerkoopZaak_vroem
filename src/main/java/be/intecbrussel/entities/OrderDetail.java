package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails", schema = "classicmodels", catalog = "")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;
    private Order order;
    private Product product;

    @Id
    @Column(name = "orderNumber", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

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
        OrderDetail that = (OrderDetail) o;
        return orderNumber == that.orderNumber &&
                quantityOrdered == that.quantityOrdered &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }

    @ManyToOne
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
