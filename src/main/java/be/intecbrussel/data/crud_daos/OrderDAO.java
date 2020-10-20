package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.Order;

import java.util.List;

public interface OrderDAO {

    void createOrder(Order order);
    Order readOrder(int orderNumber);
    void updateOrder(Order order);
    void deleteOrder(Order order);
    List<Order> readAllOrders();
}
