package be.intecbrussel.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle;

    @OneToOne
    @JoinColumn(name = "reportsTo")
    private Employee employeeToReports;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "officeCode")
    private Office office;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Customer> customersList;

    public Employee() {
        this.employeeNumber = 0;
    }

    public Employee(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getEmployeeToReport() {
        return employeeToReports;
    }

    public void setEmployeeToReport(Employee employeeToReports) {
        this.employeeToReports = employeeToReports;
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    @Override
    public String toString() {
        return "[Employee]" +
                " Number=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
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
                Objects.equals(employeeToReports, employee.employeeToReports) &&
                Objects.equals(office, employee.office) &&
                Objects.equals(customersList, employee.customersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, jobTitle, employeeToReports, office, customersList);
    }
}
