package be.intecbrussel.entities;

import be.intecbrussel.entities.pk.OrderDetailPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailPK.class)
public class OrderDetail implements Serializable {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

}
