package be.intecbrussel.entities;

import be.intecbrussel.entities.pk.OrderDetailPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    OrderDetailPK id;

    private int quantityOrdered;
    private double priceEach;
    private short orderLineNumber;

    public OrderDetail() {
    }

    public OrderDetailPK getId() {
        return id;
    }

    public void setId(OrderDetailPK id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "[OrderDetail]" +
                "id=" + id +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return quantityOrdered == that.quantityOrdered &&
                Double.compare(that.priceEach, priceEach) == 0 &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantityOrdered, priceEach, orderLineNumber);
    }
}
