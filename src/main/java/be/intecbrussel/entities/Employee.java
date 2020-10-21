package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "classicmodels", catalog = "")
public class Employee {
    @Id
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name ="reportsTo")
    private Employee reportsTo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode")
    @MapsId("officeCode")
    private Office office;
    private Integer reportsToId;
    private Collection<Customer> customers;
    private Collection<Employee> managedEmployees;

    public Employee() {
    }

    public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, String jobTitle, Employee reportsTo, Office officeCode) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.jobTitle = jobTitle;
        this.reportsTo = reportsTo;
        this.office = office;
    }

    @Id
    @Column(name = "employeeNumber", nullable = false)
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "extension", nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "jobTitle", nullable = false, length = 50)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @ManyToOne
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public String toString() {
        return "[Employee]" +
                " Number=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", office='" + office.getOfficeCode() + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(extension, employee.extension) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(reportsTo, employee.reportsTo) &&
                Objects.equals(office, employee.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, jobTitle, reportsTo, office);
    }

    @Basic
    @Column(name = "reportsTo", nullable = true)
    public Integer getReportsToId() {
        return reportsToId;
    }

    public void setReportsToId(Integer reportsToId) {
        this.reportsToId = reportsToId;
    }

    @OneToMany(mappedBy = "salesRep")
    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false)
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @OneToMany(mappedBy = "reportsTo")
    public Collection<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Collection<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }
}
