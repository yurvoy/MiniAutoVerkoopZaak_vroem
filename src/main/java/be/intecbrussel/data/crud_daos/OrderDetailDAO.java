package be.intecbrussel.data.crud_daos;

import be.intecbrussel.entities.OrderDetail;
import be.intecbrussel.entities.OrderDetailPK;


public interface OrderDetailDAO {

    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(OrderDetailPK orderDetailPK);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(OrderDetail orderDetail);

}
