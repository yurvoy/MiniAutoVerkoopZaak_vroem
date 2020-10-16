package be.intecbrussel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetail.class)
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

}
