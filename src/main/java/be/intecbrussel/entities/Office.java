package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "offices", schema = "classicmodels", catalog = "")
public class Office {
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
    private Collection<Employee> employeesByOfficeCode;

    @Id
    @Column(name = "officeCode", nullable = false, length = 10)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
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
    @Column(name = "state", nullable = true, length = 50)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    @Column(name = "postalCode", nullable = false, length = 15)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "territory", nullable = false, length = 10)
    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(officeCode, office.officeCode) &&
                Objects.equals(city, office.city) &&
                Objects.equals(phone, office.phone) &&
                Objects.equals(addressLine1, office.addressLine1) &&
                Objects.equals(addressLine2, office.addressLine2) &&
                Objects.equals(state, office.state) &&
                Objects.equals(country, office.country) &&
                Objects.equals(postalCode, office.postalCode) &&
                Objects.equals(territory, office.territory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
    }

    @Override
    public String toString() {
        return "[Office]" +
                "officeCode='" + officeCode + '\'' +
                ", city='" + city;
    }

    @OneToMany(mappedBy = "office")
    public Collection<Employee> getEmployeesByOfficeCode() {
        return employeesByOfficeCode;
    }

    public void setEmployeesByOfficeCode(Collection<Employee> employeesByOfficeCode) {
        this.employeesByOfficeCode = employeesByOfficeCode;
    }
}
