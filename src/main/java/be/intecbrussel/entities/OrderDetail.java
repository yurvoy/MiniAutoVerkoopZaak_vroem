package be.intecbrussel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name =  "productCode")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name =  "orderNumber")
    private Order orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private short orderLineNumber;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Order orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
