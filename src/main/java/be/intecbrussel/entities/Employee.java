package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "classicmodels", catalog = "")
public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;
    private Collection<Customer> customers;
    private Office office;
    private Employee reportsTo;
    private Collection<Employee> managedEmployees;

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
                Objects.equals(reportsTo, employee.reportsTo) &&
                Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, reportsTo, jobTitle);
    }

    @Override
    public String toString() {
        return "[Employee]" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", office=" + office;
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

    @ManyToOne
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    @OneToMany(mappedBy = "reportsTo")
    public Collection<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Collection<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }
}
