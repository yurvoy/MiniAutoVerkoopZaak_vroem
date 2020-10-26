package be.intecbrussel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "classicmodels", catalog = "")
public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private BigDecimal creditLimit;
    private Employee salesRep;
    private Collection<Order> orders;
    private Collection<Payment> payments;

    @Id
    @Column(name = "customerNumber", nullable = false)
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Basic
    @Column(name = "customerName", nullable = false, length = 50)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "contactLastName", nullable = false, length = 50)
    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    @Basic
    @Column(name = "contactFirstName", nullable = false, length = 50)
    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "addressLine1", nullable = false, length = 50)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2", nullable = true, length = 50)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 50)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "postalCode", nullable = true, length = 15)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "creditLimit", nullable = true, precision = 2)
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerNumber == customer.customerNumber &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(contactLastName, customer.contactLastName) &&
                Objects.equals(contactFirstName, customer.contactFirstName) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(addressLine1, customer.addressLine1) &&
                Objects.equals(addressLine2, customer.addressLine2) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(postalCode, customer.postalCode) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(creditLimit, customer.creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, creditLimit);
    }

    @Override
    public String toString() {
        return "[Customer]" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", creditLimit=" + creditLimit +
                ", salesRep=" + salesRep;
    }

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    public Employee getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Employee salesRep) {
        this.salesRep = salesRep;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Collection<Payment> payments) {
        this.payments = payments;
    }
}
