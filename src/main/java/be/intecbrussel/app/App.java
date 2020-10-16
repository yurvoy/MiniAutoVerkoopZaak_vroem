package be.intecbrussel.app;

import be.intecbrussel.data.CustomerDAO;
import be.intecbrussel.data.CustomerDaoImpl;
import be.intecbrussel.data.EmployeeDAO;
import be.intecbrussel.data.EmployeeDaoImpl;
import be.intecbrussel.entities.Customer;
import be.intecbrussel.entities.Employee;
import be.intecbrussel.entities.Office;

public class App {
    public static void main(String[] args) {

        // Create DAOs
        CustomerDAO customerDAO = new CustomerDaoImpl();
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();


        // Create entities
        Employee newEmployee = employeeDAO.readEmployee(1143);
        newEmployee.setEmployeeNumber(1001);
        System.out.println(newEmployee);
        employeeDAO.createEmployee(newEmployee);

        Customer newCustomer = customerDAO.readCustomer(103);
        newCustomer.setCustomerNumber(101);
        newCustomer = new Customer(101);
        customerDAO.createCustomer(newCustomer);

        System.out.println(customerDAO.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));


//        // Update entities
//        newEmployee.setFirstName("Yvonnick");
//        newEmployee.setLastName("Urvoy");
//        newEmployee.setEmail("yvonnick.urvoy@gmail.com");
//        newEmployee.setJobTitle("Java IoT student");
//        newEmployee.setOffice(new Office("4"));
//        newEmployee.setExtension("x1986");
//        employeeDAO.updateEmployee(newEmployee);
//
//        newCustomer.setCustomerName("INTEC Brussel");
//        newCustomer.setContactFirstName("Bart");
//        newCustomer.setContactLastName("Hunerbein");
//        newCustomer.setAddressLine1("Rouppeplein 16");
//        newCustomer.setCity("Brussels");
//        newCustomer.setPostalCode("1000");
//        newCustomer.setCountry("Belgium");
//        newCustomer.setCreditLimit(1000000);
//        customerDAO.updateCustomer(newCustomer);
//
//        System.out.println(customerDAO.readCustomer(101));
//        System.out.println(employeeDAO.readEmployee(1001));

    }
}
