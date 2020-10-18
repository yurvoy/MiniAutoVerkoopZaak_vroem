package be.intecbrussel.entities;

import be.intecbrussel.entities.embeddable.OrderDetailId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderDetailId orderDetailId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int orderNumber;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String productCode;

    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    public OrderDetail() {
    }
}
