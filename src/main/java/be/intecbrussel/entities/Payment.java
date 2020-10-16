package be.intecbrussel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "payments")
@IdClass(Payment.class)
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int checkNumber;
    private Date paymentDate;
    private double amount;

}
