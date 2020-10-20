package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.pk.OrderDetailPK;


import java.util.List;

public interface OrderDetailDAO {

    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(OrderDetailPK orderDetailPK);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> readAllOrderDetails();
}
