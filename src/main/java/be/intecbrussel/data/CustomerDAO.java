package be.intecbrussel.data;

import be.intecbrussel.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    void createCustomer(Customer customer);
    Customer readCustomer(int customerId);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);

    List<Customer> readAllCustomers();
}
