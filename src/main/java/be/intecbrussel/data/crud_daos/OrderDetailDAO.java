package be.intecbrussel.data.crud_daos;


import be.intecbrussel.entities.Orderdetail;
import be.intecbrussel.entities.OrderdetailPK;

public interface OrderDetailDAO {

    void createOrderDetail(Orderdetail orderDetail);
    Orderdetail readOrderDetail(OrderdetailPK orderdetailPK);
    void updateOrderDetail(Orderdetail orderDetail);
    void deleteOrderDetail(Orderdetail orderDetail);

}
