package be.intecbrussel.app;

import be.intecbrussel.data.daos.*;
import be.intecbrussel.data.implementations.*;
import be.intecbrussel.entities.*;
import be.intecbrussel.entities.pk.PaymentPK;

import java.math.BigDecimal;

public class TestApp {
    public static void main(String[] args) {

        // Create DAOs
        CustomerDAO CustomerDAO = new CustomerDaoImpl();
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();
        OfficeDAO officeDAO = new OfficeDaoImpl();
        OrderDAO orderDAO = new OrderDaoImpl();
        PaymentDAO paymentDAO = new PaymentDaoImpl();
        ProductDAO productDAO = new ProductDaoImpl();
        ProductLineDAO productLineDAO = new ProductLineDaoImpl();


        // Create entities
        Employee newEmployee = employeeDAO.readEmployee(1143);
        newEmployee.setEmployeeNumber(1001);
        employeeDAO.createEmployee(newEmployee);

        Customer newCustomer = CustomerDAO.readCustomer(103);
        newCustomer.setCustomerNumber(101);
        CustomerDAO.createCustomer(newCustomer);

        Office newOffice = officeDAO.readOffice("4");
        newOffice.setOfficeCode("8");
        officeDAO.createOffice(newOffice);

        Order newOrder = orderDAO.readOrder(10100);
        newOrder.setOrderNumber(10099);
        orderDAO.createOrder(newOrder);

        PaymentPK newPK = new PaymentPK(CustomerDAO.readCustomer(103), "HQ336336");
        Payment newPayment = paymentDAO.readPayment(newPK);
        newPayment.setId(new PaymentPK(newCustomer, "YU121986"));
        paymentDAO.createPayment(newPayment);

        Product newProduct = productDAO.readProduct("S10_1949");
        newProduct.setProductCode("S33_1986");
        productDAO.createProduct(newProduct);

        ProductLine newProductLine = productLineDAO.readProductLine("Trains");
        newProductLine.setProductLine("Bike");
        productLineDAO.createProductLine(newProductLine);

        // Print created entities
        System.out.println(CustomerDAO.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));
        System.out.println(officeDAO.readOffice("8"));
        System.out.println(orderDAO.readOrder(10099));
        System.out.println(paymentDAO.readPayment(new PaymentPK(newCustomer, "YU121986")));
        System.out.println(productDAO.readProduct("S33_1986"));
        System.out.println(productLineDAO.readProductLine("Bike"));


        // Update entities
        newEmployee.setFirstName("Yvonnick");
        newEmployee.setLastName("Urvoy");
        newEmployee.setEmail("yvonnick.urvoy@gmail.com");
        newEmployee.setJobTitle("Java IoT student");
        newEmployee.setExtension("x1986");
        newEmployee.setOfficeCode(officeDAO.readOffice("8"));
        employeeDAO.updateEmployee(newEmployee);

        newCustomer.setCustomerName("INTEC Brussel");
        newCustomer.setContactFirstName("Bart");
        newCustomer.setContactLastName("Hunerbein");
        newCustomer.setPhone("+322.411.29.07");
        newCustomer.setAddressLine1("Rouppeplein 16");
        newCustomer.setCity("Brussels");
        newCustomer.setPostalCode("1000");
        newCustomer.setState("Brussels region");
        newCustomer.setCountry("Belgium");
        newCustomer.setCreditLimit(BigDecimal.valueOf(100000));
        newCustomer.setSalesRepEmployeeNumber(newEmployee);
        CustomerDAO.updateCustomer(newCustomer);

        System.out.println(CustomerDAO.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));

    }
}
