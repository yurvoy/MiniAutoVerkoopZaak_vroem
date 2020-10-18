package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Employee> employeesList;

    public Office() {
    }

    public Office(String officeCode) {
        this.officeCode = officeCode;
    }
}
