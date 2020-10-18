package be.intecbrussel.entities;

import be.intecbrussel.entities.embeddable.OrderDetailId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderDetailId orderDetailId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int customerNumber;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int checkNumber;
    private Date paymentDate;
    private double amount;

    public Payment() {
    }
}
