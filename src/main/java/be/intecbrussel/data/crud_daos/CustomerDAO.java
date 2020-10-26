package be.intecbrussel.data.crud_daos;


import be.intecbrussel.entities.Customer;

public interface CustomerDAO  {

    void createCustomer(Customer customer);
    Customer readCustomer(int customerId);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);

}
