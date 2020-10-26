package be.intecbrussel.app;

import be.intecbrussel.data.crud_daos.*;
import be.intecbrussel.data.implementations.*;
import be.intecbrussel.entities.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {

        // Create DAOs
        CustomerDAO customerDao = new CustomerDaoImpl();
        EmployeeDAO employeeDAO = new EmployeeDaoImpl();
        OfficeDAO officeDAO = new OfficeDaoImpl();
        OrderDAO orderDAO = new OrderDaoImpl();
        OrderDetailDAO orderDetailDAO = new OrderDetailDaoImpl();
        PaymentDAO paymentDAO = new PaymentDaoImpl();
        ProductDAO productDAO = new ProductDaoImpl();
        ProductLineDAO productLineDAO = new ProductLineDaoImpl();


        // Create entities
        Employee newEmployee = employeeDAO.readEmployee(1002);
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

        Product newProduct = productDAO.readProduct("S10_1949");
        newProduct.setProductCode("S33_1986");
        productDAO.createProduct(newProduct);

        Productline newProductLine = productLineDAO.readProductLine("Trains");
        newProductLine.setProductLine("Bike");
        productLineDAO.createProductLine(newProductLine);

        OrderdetailPK odPK = new OrderdetailPK(newProduct, newOrder);
        Orderdetail newOrderDetail = orderDetailDAO.readOrderDetail(odPK);
        newOrderDetail.setProduct(newProduct);
        orderDetailDAO.createOrderDetail(newOrderDetail);

        PaymentPK newPK = new PaymentPK(customerDao.readCustomer(103), "HQ336336");
        Payment newPayment = paymentDAO.readPayment(newPK);
        newPayment.setCheckNumber("YU121986");
        paymentDAO.createPayment(newPayment);

        // Print created entities
        System.out.println("\n### ENTITIES TO UPDATE ###");
        System.out.println(customerDao.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));
        System.out.println(officeDAO.readOffice("8"));
        System.out.println(orderDAO.readOrder(10099));
        System.out.println(productDAO.readProduct("S33_1986"));
        System.out.println(productLineDAO.readProductLine("Bike"));
        System.out.println(orderDetailDAO.readOrderDetail(odPK));
        System.out.println(paymentDAO.readPayment(new PaymentPK(newCustomer, "YU121986")));



        // Update entities
        newOffice.setCity("Brussels");
        newOffice.setCountry("Belgium");
        newOffice.setPostalCode("1000");
        officeDAO.updateOffice(newOffice);

        newProduct.setProductName("GRAVEL EDR OFFROAD VAN RYSEL GRX");
        newProduct.setProductVendor("Decathlon");
        newProduct.setProductDescription("Gravel bike");
        newProduct.setProductline(newProductLine);
        productDAO.updateProduct(newProduct);

        newProductLine.setHtmlDescription("https://www.decathlon.be/fr/p/velo-gravel-edr-offroad-van-rysel-grx-1x/_/R-p-327757?mc=8601607");
        newProductLine.setTextDescription("100% carbon");
        productLineDAO.updateProductLine(newProductLine);

        newOrder.setComments("Customer needs to buy soms bikes !");
        orderDAO.updateOrder(newOrder);

        newOrderDetail.setPriceEach(BigDecimal.valueOf(2000));
        newOrderDetail.setQuantityOrdered(12);
        orderDetailDAO.updateOrderDetail(newOrderDetail);

        newPayment.setAmount(BigDecimal.valueOf(24000));
        newPayment.setPaymentDate(LocalDate.ofEpochDay(19-10-2020));
        paymentDAO.updatePayment(newPayment);

        newEmployee.setFirstName("Yvonnick");
        newEmployee.setLastName("Urvoy");
        newEmployee.setEmail("yvonnick.urvoy@gmail.com");
        newEmployee.setJobTitle("Java IoT student");
        newEmployee.setExtension("x1986");
        newEmployee.setOffice(officeDAO.readOffice("8"));
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
        customerDao.updateCustomer(newCustomer);

        System.out.println("\n### ENTITIES UPDATED ###");
        System.out.println(customerDao.readCustomer(101));
        System.out.println(employeeDAO.readEmployee(1001));
        System.out.println(officeDAO.readOffice("8"));
        System.out.println(orderDAO.readOrder(10099));
        System.out.println(productDAO.readProduct("S33_1986"));
        System.out.println(productLineDAO.readProductLine("Bike"));
        System.out.println(orderDetailDAO.readOrderDetail(new OrderdetailPK(newProduct, newOrder)));
        System.out.println(paymentDAO.readPayment(new PaymentPK(newCustomer, "YU121986")));



//   //      Delete entities
//        customerDao.deleteCustomer(newCustomer);
//        employeeDAO.deleteEmployee(newEmployee);
//        officeDAO.deleteOffice(newOffice);
//        orderDAO.deleteOrder(newOrder);
//        paymentDAO.deletePayment(newPayment);
//        productDAO.deleteProduct(newProduct);
//        productLineDAO.deleteProductLine(newProductLine);

    }
}
