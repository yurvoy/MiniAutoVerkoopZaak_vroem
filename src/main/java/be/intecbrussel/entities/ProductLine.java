package be.intecbrussel.entities;

import javax.persistence.*;

@Entity
@Table(name = "productlines")
public class ProductLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;
}
