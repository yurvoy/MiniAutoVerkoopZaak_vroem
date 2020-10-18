package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private double creditLimit;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee employee;

    public Customer() {
    }

    public Customer(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employee getEmployeeNumber() {
        return employee;
    }

    public void setEmployeeNumber(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "{Customer]" +
                " Number=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerNumber == customer.customerNumber &&
                Double.compare(customer.creditLimit, creditLimit) == 0 &&
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
                Objects.equals(employee, customer.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, creditLimit, employee);
    }
}
