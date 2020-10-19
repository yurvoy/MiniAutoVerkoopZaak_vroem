package be.intecbrussel.app;

import be.intecbrussel.data.daos.*;
import be.intecbrussel.data.implementations.*;
import be.intecbrussel.entities.*;
import be.intecbrussel.entities.pk.PaymentPK;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {

        // Create DAOs
        CustomerDAO customerDao = new CustomerDaoImpl();
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

        Customer newCustomer = customerDao.readCustomer(103);
        newCustomer.setCustomerNumber(101);
        customerDao.createCustomer(newCustomer);

        Office newOffice = officeDAO.readOffice("4");
        newOffice.setOfficeCode("8");
        officeDAO.createOffice(newOffice);

        Order newOrder = orderDAO.readOrder(10100);
        newOrder.setOrderNumber(10099);
        orderDAO.createOrder(newOrder);

        PaymentPK newPK = new PaymentPK(customerDao.readCustomer(103), "HQ336336");
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
        System.out.println("### ENTITIES TO UPDATE ###");
        System.out.println(customerDao.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));
        System.out.println(officeDAO.readOffice("8"));
        System.out.println(orderDAO.readOrder(10099));
        System.out.println(paymentDAO.readPayment(new PaymentPK(newCustomer, "YU121986")));
        System.out.println(productDAO.readProduct("S33_1986"));
        System.out.println(productLineDAO.readProductLine("Bike"));


        // Update entities
        newOffice.setCity("Brussels");
        newOffice.setCountry("Belgium");
        newOffice.setPostalCode("1000");
        officeDAO.updateOffice(newOffice);

        newProduct.setProductName("GRAVEL EDR OFFROAD VAN RYSEL GRX");
        newProduct.setProductVendor("Decathlon");
        newProduct.setProductDescription("Gravel bike");
        productDAO.updateProduct(newProduct);

        newProductLine.setHtmlDescription("https://www.decathlon.be/fr/p/velo-gravel-edr-offroad-van-rysel-grx-1x/_/R-p-327757?mc=8601607");
        newProductLine.setImage("https://contents.mediadecathlon.com/p1889684/k$f84d37e6c0508466f350be380a1b0f0c/sq/VELO+GRAVEL+EDR+OFFROAD+VAN+RYSEL+GRX+1X.webp?f=1000x1000");
        newProductLine.setTextDescription("100% carbon");
        productLineDAO.updateProductLine(newProductLine);

        newOrder.setCustomer(customerDao.readCustomer(101));
        newOrder.setComments("Customer needs to buy soms bikes !");
        orderDAO.updateOrder(newOrder);

        newPayment.setAmount(BigDecimal.valueOf(2000));
        newPayment.setPaymentDate(LocalDate.ofEpochDay(19-10-2020));
        paymentDAO.updatePayment(newPayment);

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
        customerDao.updateCustomer(newCustomer);

        System.out.println("### ENTITIES UPDATED ###");
        System.out.println(customerDao.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));
        System.out.println(officeDAO.readOffice("8"));
        System.out.println(orderDAO.readOrder(10099));
        System.out.println(paymentDAO.readPayment(new PaymentPK(newCustomer, "YU121986")));
        System.out.println(productDAO.readProduct("S33_1986"));
        System.out.println(productLineDAO.readProductLine("Bike"));


        // Delete entities
        customerDao.deleteCustomer(customerDao.readCustomer(101));
        employeeDAO.deleteEmployee(employeeDAO.readEmployee(1001));
        officeDAO.deleteOffice(officeDAO.readOffice("8"));
        orderDAO.deleteOrder(orderDAO.readOrder(10099));
        paymentDAO.deletePayment(paymentDAO.readPayment(newPK));
        productDAO.deleteProduct(productDAO.readProduct("S33_1986"));
        productLineDAO.deleteProductLine(productLineDAO.readProductLine("Bike"));

    }
}
